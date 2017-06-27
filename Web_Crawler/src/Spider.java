//Author: Md Farhadur Reza, Romas James Hada,

import java.awt.FlowLayout;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.*;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
//import com.google.gson.Gson;





/**
 * Spider defines a framework for writing a web crawler.  Users can
 * change the behavior of the spider by overriding methods.
 * Default spider does a breadth first crawl starting from a
 * given URL up to a specified maximum number of pages, saving (caching)
 * the pages in a given directory.  Also adds a "BASE" HTML command to
 * cached pages so links can be followed from the cached version.
 *
 * 
 */

public class Spider extends javax.swing.JFrame{

	
    public HashMap<String,String> url_map_spider = new HashMap <String,String>();

    public HashMap<String,String> url_map_spider_select = new HashMap <String,String>();
	public int count4=0;
	  
    JButton select_buttton;
	  
	String dirName = "C:\\java_workspace\\Web_Crawler\\corpus\\";
		
	File directory = new File(dirName);
	  
	static URL firstURL;
	
  /**
   * The queue of links maintained by the spider
   */
  protected List<Link> linksToVisit = new LinkedList<Link>();

  /**
   * Flag to purposely slow the crawl for debugging purposes
   */
  protected boolean slow = false;

  /**
   * The object to be used to retrieve pages
   */
  protected HTMLPageRetriever retriever = new HTMLPageRetriever();

  /**
   * The directory to save the downloaded files to.
   */
 // protected File saveDir;

  /**
   * The number of pages indexed.  In the default implementation
   * a page is considered to be indexed only if it is written to a
   * file.
   */
  protected int count = 0;

  /**
   * The maximum number of pages to be indexed.
   */
  protected int maxCount = 50;

  /**
   * The URLs that have already been visited.
   */
  protected HashSet<Link> visited;
  
  
  /*public Spider()
  {
	setLayout(new FlowLayout());
    setTitle("Recommendation Sytsem");
    getContentPane().setLayout(null);
    
    setSize(1000,600);
    setVisible(false);
    
        getContentPane().add(textArea);
    	textArea.setFont(new Font("Serif", Font.ITALIC, 16));
    	textArea.setLineWrap(true);
    	textArea.setWrapStyleWord(true);
    	
    	 
    	 textArea.setBounds(10,50,250,80);
    	 
    	 textArea.setVisible(true);
    	 
    	 getContentPane().add(textArea2);
     	textArea2.setFont(new Font("Serif", Font.ITALIC, 16));
     	textArea2.setLineWrap(true);
     	textArea2.setWrapStyleWord(true);
     	
     	 
     	 textArea2.setBounds(10,180,250,80);
     	 
     	 textArea2.setVisible(true);
     
    	 
     	 getContentPane().add(textArea3);
      	textArea3.setFont(new Font("Serif", Font.ITALIC, 16));
      	textArea3.setLineWrap(true);
      	textArea3.setWrapStyleWord(true);
      	
      	 
      	 textArea3.setBounds(10,290,250,80);
      	 
      	 textArea3.setVisible(true);
      	 
      	 
      	getContentPane().add(textArea4);
       	textArea4.setFont(new Font("Serif", Font.ITALIC, 16));
       	textArea4.setLineWrap(true);
       	textArea4.setWrapStyleWord(true);       	       	 
       	textArea4.setBounds(10,420,250,90);       	 
       	textArea4.setVisible(true);    	 
       	 
       	getContentPane().add(textArea5);
     	textArea5.setFont(new Font("Serif", Font.ITALIC, 16));
     	textArea5.setLineWrap(true);
     	textArea5.setWrapStyleWord(true);    	 
     	textArea5.setBounds(500,50,150,40);    	 
     	textArea5.setVisible(true);
     	
     	getContentPane().add(textArea6);
     	textArea6.setFont(new Font("Serif", Font.ITALIC, 16));
     	textArea6.setLineWrap(true);
     	textArea6.setWrapStyleWord(true);    	 
     	textArea6.setBounds(500,180,150,40);    	 
     	textArea6.setVisible(true);
     	
     	getContentPane().add(textArea7);
     	textArea7.setFont(new Font("Serif", Font.ITALIC, 16));
     	textArea7.setLineWrap(true);
     	textArea7.setWrapStyleWord(true);    	 
     	textArea7.setBounds(500,290,150,40);    	 
     	textArea7.setVisible(true);
     	
     	getContentPane().add(textArea8);
     	textArea8.setFont(new Font("Serif", Font.ITALIC, 16));
     	textArea8.setLineWrap(true);
     	textArea8.setWrapStyleWord(true);    	 
     	textArea8.setBounds(500,420,150,40);    	 
     	textArea8.setVisible(true);
     	 
         	
       	 
    	// check_Scroll5 = new JScrollPane(textArea);
    	 //getContentPane().add(check_Scroll5);
    	//areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	//areaScrollPane.setPreferredSize(new Dimension(250, 250));
    	
    	
   	 
    
    label1.setText("User's Priority List");
    getContentPane().add(label1);
    label1.setBounds(20,10,120,10);
    
    
  //Shipping Time
    label2.setText("Shipping Time");
    getContentPane().add(label2);
    label2.setBounds(280,30,100,15);
    
    label3.setText("Priority");
    getContentPane().add(label3);
    label3.setBounds(400,30,50,15);
    
    check_list.setVisibleRowCount(5);
    check_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    check_Scroll= new JScrollPane(check_list);
  //  getContentPane().add(url_list);  
    getContentPane().add(check_Scroll); 
   // select_buttton= new JButton("Select");
    //url_list.setBounds(500,36,90,90);
    check_Scroll.setBounds(280,50,40,80);
    
    check_list.addListSelectionListener(
    		new ListSelectionListener(){
    			public void valueChanged(ListSelectionEvent event){
    				selection_list.setListData(check_list.getSelectedValues());
    			}
    		}
    		
    		);
    
    shipping_time= check_list.getSelectedIndex();
    
    
    //getContentPane().add(select_buttton);
    
  //  select_buttton.setBounds(650,36,90,30);
    
    selection_list= new JList();
    selection_list.setVisibleRowCount(1);
    
    selection_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    select_Scroll= new JScrollPane(selection_list);
    getContentPane().add(select_Scroll);
    select_Scroll.setBounds(400,50,30,30);
    
    //Product Cost
    
    label4.setText("Product Cost");
    getContentPane().add(label4);
    label4.setBounds(280,160,100,15);
    
    label5.setText("Priority");
    getContentPane().add(label5);
    label5.setBounds(400,160,50,15);
    
    check_list2.setVisibleRowCount(5);
    check_list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    check_Scroll2= new JScrollPane(check_list2);
  //  getContentPane().add(url_list);  
    getContentPane().add(check_Scroll2); 
   // select_buttton= new JButton("Select");
    //url_list.setBounds(500,36,90,90);
    check_Scroll2.setBounds(280,180,40,80);
    
    check_list2.addListSelectionListener(
    		new ListSelectionListener(){
    			public void valueChanged(ListSelectionEvent event){
    				select_product.setListData(check_list2.getSelectedValues());
    			}
    		}
    		
    		);
    
    
    
    
   
    
    //getContentPane().add(select_buttton);
    
  //  select_buttton.setBounds(650,36,90,30);
    
    select_product= new JList();
    select_product.setVisibleRowCount(1);
    
    select_product.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    select_Scroll2= new JScrollPane(select_product);
    getContentPane().add(select_Scroll2);
    select_Scroll2.setBounds(400,180,30,30);
    
    
    
  //Shopping Portal
    label6.setText("Shopping Portal");
    getContentPane().add(label6);
    label6.setBounds(280,280,100,15);
    
    label7.setText("Priority");
    getContentPane().add(label7);
    label7.setBounds(400,280,50,15);
    
    check_list3.setVisibleRowCount(5);
    check_list3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    check_Scroll3= new JScrollPane(check_list3);
  //  getContentPane().add(url_list);  
    getContentPane().add(check_Scroll3); 
   // select_buttton= new JButton("Select");
    //url_list.setBounds(500,36,90,90);
    check_Scroll3.setBounds(280,300,40,80);
    
    check_list3.addListSelectionListener(
    		new ListSelectionListener(){
    			public void valueChanged(ListSelectionEvent event){
    				select_portal.setListData(check_list3.getSelectedValues());
    			}
    		}
    		
    		);
    
    //getContentPane().add(select_buttton);
    
  //  select_buttton.setBounds(650,36,90,30);
    
    select_portal= new JList();
    select_portal.setVisibleRowCount(1);
    
    select_portal.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    select_Scroll3= new JScrollPane(select_portal);
    getContentPane().add(select_Scroll3);
    select_Scroll3.setBounds(400,300,30,30);
    
    //Product State
    
    label8.setText("Product State");
    getContentPane().add(label8);
    label8.setBounds(280,410,100,15);
    
    label9.setText("Priority");
    getContentPane().add(label9);
    label9.setBounds(400,410,50,15);
    
    check_list4.setVisibleRowCount(5);
    check_list4.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    check_Scroll4= new JScrollPane(check_list4);
  //  getContentPane().add(url_list);  
    getContentPane().add(check_Scroll4); 
   // select_buttton= new JButton("Select");
    //url_list.setBounds(500,36,90,90);
    check_Scroll4.setBounds(280,435,40,80);
    
    check_list4.addListSelectionListener(
    		new ListSelectionListener(){
    			public void valueChanged(ListSelectionEvent event){
    				product_state.setListData(check_list4.getSelectedValues());
    			}
    		}
    		
    		);
    
    //getContentPane().add(select_buttton);
    
  //  select_buttton.setBounds(650,36,90,30);
    
    product_state= new JList();
    product_state.setVisibleRowCount(1);
    
    product_state.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    select_Scroll4= new JScrollPane(product_state);
    getContentPane().add(select_Scroll4);
    select_Scroll4.setBounds(400,435,30,30);
    
    // Portal Trustability
    
    
    label12.setText("User's Website Trustworthiness");
    getContentPane().add(label12);
    label12.setBounds(500,10,200,10);
    
  //Amazon
    label11.setText("Amazon");
    getContentPane().add(label11);
    label11.setBounds(700,30,100,15);
    
    label10.setText("Reliability");
    getContentPane().add(label10);
    label10.setBounds(820,30,80,15);
    
    check_list5.setVisibleRowCount(5);
    check_list5.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    check_Scroll5= new JScrollPane(check_list5);
  //  getContentPane().add(url_list);  
    getContentPane().add(check_Scroll5); 
   // select_buttton= new JButton("Select");
    //url_list.setBounds(500,36,90,90);
    check_Scroll5.setBounds(700,50,40,80);
    
    check_list5.addListSelectionListener(
    		new ListSelectionListener(){
    			public void valueChanged(ListSelectionEvent event){
    				select_amazon.setListData(check_list5.getSelectedValues());
    			}
    		}
    		
    		);
    
    //getContentPane().add(select_buttton);
    
  //  select_buttton.setBounds(650,36,90,30);
    
    select_amazon= new JList();
    select_amazon.setVisibleRowCount(1);
    
    select_amazon.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    select_Scroll5= new JScrollPane(select_amazon);
    getContentPane().add(select_Scroll5);
    select_Scroll5.setBounds(820,50,30,30);
    
    //Ebay reliability
    
    label14.setText("Ebay");
    getContentPane().add(label14);
    label14.setBounds(700,160,100,15);
    
    label15.setText("Reliability");
    getContentPane().add(label15);
    label15.setBounds(820,160,80,15);
    
    check_list6.setVisibleRowCount(5);
    check_list6.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    check_Scroll6= new JScrollPane(check_list6);
  //  getContentPane().add(url_list);  
    getContentPane().add(check_Scroll6); 
   // select_buttton= new JButton("Select");
    //url_list.setBounds(500,36,90,90);
    check_Scroll6.setBounds(700,180,40,80);
    
    check_list6.addListSelectionListener(
    		new ListSelectionListener(){
    			public void valueChanged(ListSelectionEvent event){
    				select_ebay.setListData(check_list6.getSelectedValues());
    			}
    		}
    		
    		);
    
    //getContentPane().add(select_buttton);
    
  //  select_buttton.setBounds(650,36,90,30);
    
    select_ebay= new JList();
    select_ebay.setVisibleRowCount(1);
    
    select_ebay.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    select_Scroll6= new JScrollPane(select_ebay);
    getContentPane().add(select_Scroll6);
    select_Scroll6.setBounds(820,180,30,30);
    
    
    
  //Groupon
    label16.setText("Groupon");
    getContentPane().add(label16);
    label16.setBounds(700,280,100,15);
    
    label17.setText("Reliability");
    getContentPane().add(label17);
    label17.setBounds(820,280,80,15);
    
    check_list7.setVisibleRowCount(5);
    check_list7.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    check_Scroll7= new JScrollPane(check_list7);
  //  getContentPane().add(url_list);  
    getContentPane().add(check_Scroll7); 
   // select_buttton= new JButton("Select");
    //url_list.setBounds(500,36,90,90);
    check_Scroll7.setBounds(700,300,40,80);
    
    check_list7.addListSelectionListener(
    		new ListSelectionListener(){
    			public void valueChanged(ListSelectionEvent event){
    				select_groupon.setListData(check_list7.getSelectedValues());
    			}
    		}
    		
    		);
    
    //getContentPane().add(select_buttton);
    
  //  select_buttton.setBounds(650,36,90,30);
    
    select_groupon= new JList();
    select_groupon.setVisibleRowCount(1);
    
    select_groupon.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    select_Scroll7= new JScrollPane(select_groupon);
    getContentPane().add(select_Scroll7);
    select_Scroll7.setBounds(820,300,30,30);
    
    //Buy
    
    label18.setText("Buy");
    getContentPane().add(label18);
    label18.setBounds(700,410,100,15);
    
    label19.setText("Reliability");
    getContentPane().add(label19);
    label19.setBounds(820,410,80,15);
    
    check_list8.setVisibleRowCount(5);
    check_list8.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    check_Scroll8= new JScrollPane(check_list8);
  //  getContentPane().add(url_list);  
    getContentPane().add(check_Scroll8); 
   // select_buttton= new JButton("Select");
    //url_list.setBounds(500,36,90,90);
    check_Scroll8.setBounds(700,435,40,80);
    
    check_list8.addListSelectionListener(
    		new ListSelectionListener(){
    			public void valueChanged(ListSelectionEvent event){
    				select_buy.setListData(check_list8.getSelectedValues());
    			}
    		}
    		
    		);
    
    //getContentPane().add(select_buttton);
    
  //  select_buttton.setBounds(650,36,90,30);
    
    select_buy= new JList();
    select_buy.setVisibleRowCount(1);
    
    select_buy.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    select_Scroll8= new JScrollPane(select_buy);
    getContentPane().add(select_Scroll8);
    select_Scroll8.setBounds(820,435,30,30);
    
    
  
    
    
  }
  
*/
  /**
   * Checks command line arguments and performs the crawl.  <p> This
   * implementation calls <code>processArgs</code> and
   * <code>doCrawl</code>.
   *
   * @param args Command line arguments.
   */
  
  
  
  
  public void go() {
    //processArgs(args);
    doCrawl();
  }

  /**
   * Processes command-line arguments.  <p> The following options are
   * handled by this function:
   * <ul>
   * <li>-safe : Check for and obey robots.txt and robots META tag
   * directives.</li>
   * <li>-d &lt;directory&gt; : Store indexed files in &lt;directory&gt.</li>
   * <li>-c &lt;count&gt; : Store at most &lt;count&gt; files.</li>
   * <li>-u &lt;url&gt; : Start at &lt;url&gt;.</li>
   * <li>-slow : Pause briefly before getting a page.  This can be
   * useful when debugging.
   * </ul>
   * <p/>
   * Each option has a corresponding
   * <code>handleXXXCommandLineOption</code> function that will be
   * called when the option is found.  Subclasses may find it
   * convenient to change how options are handled by overriding
   * those methods instead of this one.  Only the above options will
   * be dealt with by this function, and the input array will remain
   * unchanged.  Note that if the flag for an option appears in the
   * input array, any value associated with that option will be
   * assumed to follow.  Thus if a "-c" flag appears in
   * <code>args</code>, the next value in <code>args</code> will be
   * blindly treated as the count.
   *
   * @param args Array of arguments as passed in from the command
   *             line.
   */
 /* public void processArgs(String[] args) {
    int i = 0;

    while (i < args.length) {

      if (args[i].charAt(0) == '-') {

        if (args[i].equals("-safe"))
          handleSafeCommandLineOption();
        else if (args[i].equals("-d"))
          handleDCommandLineOption(args[++i]);
        else if (args[i].equals("-c"))
          handleCCommandLineOption(args[++i]);
        else if (args[i].equals("-u"))
          handleUCommandLineOption(args[++i]);
        else if (args[i].equals("-slow"))
          handleSlowCommandLineOption();
      }
      ++i;
    }
  }
*/
  /**
   * Called when "-safe" is passed in on the command line.  <p> This
   * implementation sets <code>retriever</code> to a {@link
   * SafeHTMLPageRetriever SafeHTMLPageRetriever}.
   */
 /* protected void handleSafeCommandLineOption() {
    retriever = new SafeHTMLPageRetriever();
  }*/

  /**
   * Called when "-d" is passed in on the command line.  <p> This
   * implementation sets <code>saveDir</code> to <code>value</code>.
   *
   * @param value The value associated with the "-d" option.
   */
  /*protected void handleDCommandLineOption(String value) {
    saveDir = new File(value);
    if(!saveDir.exists()) {
      if (!saveDir.mkdir()) {
        throw new IllegalArgumentException("Failed to create directory " + saveDir.toString());
      } else {
        System.out.println("Created destination directory " + saveDir.toString());
      }
    }
  }*/

  /**
   * Called when "-c" is passed in on the command line.  <p> This
   * implementation sets <code>maxCount</code> to the integer
   * represented by <code>value</code>.
   *
   * @param value The value associated with the "-c" option.
   */
  protected void handleCCommandLineOption(String value) {
    maxCount = Integer.parseInt(value);
  }

  /**
   * Called when "-u" is passed in on the command line.  <p> This
   * implementation adds <code>value</code> to the list of links to
   * visit.
   *
   * @param value The value associated with the "-u" option.
   */
  protected void handleUCommandLineOption(String value) {
    linksToVisit.add(new Link(value));
  }

  /**
   * Called when "-slow" is passed in on the command line.  <p> This
   * implementation sets a flag that will be used in <code>go</code>
   * to pause briefly before downloading each page.
   */
  protected void handleSlowCommandLineOption() {
    slow = true;
  }

  /**
   * Performs the crawl.  Should be called after
   * <code>processArgs</code> has been called.  Assumes that
   * starting url has been set.  <p> This implementation iterates
   * through a list of links to visit.  For each link a check is
   * performed using {@link #visited visited} to make sure the link
   * has not already been visited.  If it has not, the link is added
   * to <code>visited</code>, and the page is retrieved.  If access
   * to the page has been disallowed by a robots.txt file or a
   * robots META tag, or if there is some other problem retrieving
   * the page, then the page is skipped.  If the page is downloaded
   * successfully {@link #indexPage indexPage} and {@link
   * #getNewLinks getNewLinks} are called if allowed.
   * <code>go</code> terminates when there are no more links to visit
   * or <code>count &gt;= maxCount</code>
   */
  public void doCrawl() {
	  
	//Gui2 g=new Gui2();;
	int count5=0;
    if (linksToVisit.size() == 0) {
      System.err.println("Exiting: No pages to visit.");
      System.exit(0);
    }
    visited = new HashSet<Link>();
    while (linksToVisit.size() > 0 && count < maxCount) {
      // Pause if in slow mode
      if (slow) {
        synchronized (this) {
          try {
            wait(1);
          }
          catch (InterruptedException e) {
          }
        }
      }
      // Take the top link off the queue
      Link link = linksToVisit.remove(0);
      System.out.println("Trying: " + link);
      // Skip if already visited this page
      if (!visited.add(link)) {
        //System.out.println("Already visited");
        continue;
      }
      if (!linkToHTMLPage(link)) {
        //System.out.println("Not HTML Page");
        continue;
      }
      HTMLPage currentPage = null;
      // Use the page retriever to get the page
      try {
        currentPage = retriever.getHTMLPage(link);
       
        
       //count5++;
      }
      catch (PathDisallowedException e) {
        //System.out.println(e);
        continue;
      }
      if (currentPage.empty()) {
        //System.out.println("No Page Found");
        continue;
      }
      if (currentPage.indexAllowed()) {
    	  count++;
    	  url_map_spider.put("P"+MoreString.padWithZeros(count,2),link.getURL().toString());
        
        System.out.println("Indexing" + "(" + count + "): " + link);
        indexPage(currentPage);
        //indexPage(currentPage);
        //count4++;
      }
      if (count < maxCount) {
        List<Link> newLinks = getNewLinks(currentPage);
        // System.out.println("Adding the following links" + newLinks);
        // Add new links to end of queue
        linksToVisit.addAll(newLinks);
      }
    }
  }

  /**
   * Check if this is a link to an HTML page.
   *
   * @return true if a directory or clearly an HTML page
   */
  protected boolean linkToHTMLPage(Link link) {
    String extension = MoreString.fileExtension(link.getURL().getPath());
    if (extension.equals("") || extension.equalsIgnoreCase("html") ||
        extension.equalsIgnoreCase("htm") || extension.equalsIgnoreCase("shtml"))
      return true;
    return false;
  }

  /**
   * Returns a list of links to follow from a given page.
   * Subclasses can use this method to direct the spider's path over
   * the web by returning a subset of the links on the page.
   *
   * @param page The current page.
   * @return Links to be visited from this page
   */
  /*protected List<Link> getNewLinks(HTMLPage page) {
	
	  return new LinkExtractor(page).extractLinks();
  }
  */
  
  
  private String getDirectory(URL u) {
	    String directory = u.getPath();
	    if (directory.indexOf(".") != -1)
	      directory = directory.substring(0, directory.lastIndexOf("/"));
	    return directory;
	  }
  
  public List<Link> getNewLinks(HTMLPage page) {
	    List<Link> links = new LinkExtractor(page).extractLinks();
	    URL url = page.getLink().getURL();

	    ListIterator<Link> iterator = links.listIterator();
	    while (iterator.hasNext()) {
	      Link link = iterator.next();
	      if (!url.getHost().equals(link.getURL().getHost()))
	        iterator.remove();
	      else if (!link.getURL().getPath().startsWith(getDirectory(firstURL)))
	        iterator.remove();
	    }
	    return links;
	  }

  /**
   * "Indexes" a <code>HTMLpage</code>.  This version just writes it
   * out to a file in the specified directory with a "P<count>.html" file name.
   *
   * @param page An <code>HTMLPage</code> that contains the page to
   *             index.
   */
  protected void indexPage(HTMLPage currentPage,int count2) {
	 // int count=0;
  /*  page.write(saveDir,
        "P" + MoreString.padWithZeros(count, (int) Math.floor(MoreMath.log(maxCount, 10)) + 1));*/
    
	  //String url_substring = currentPage.link.getURL().toString().substring(currentPage.link.getURL().toString().length()-5, currentPage.link.getURL().toString().length()-1);  
	  
    if(currentPage.indexAllowed()){
   /* if(currentPage.link.getURL().toString().contains("amazon")){
        currentPage.write(directory,"Amazon"+MoreString.padWithZeros(count, (int) Math.floor(MoreMath.log(maxCount, 10)) + 1));

}


if(currentPage.link.getURL().toString().contains("ebay")){
        currentPage.write(directory,"Ebay"+MoreString.padWithZeros(count, (int) Math.floor(MoreMath.log(maxCount, 10)) + 1));

}

if(currentPage.link.getURL().toString().contains("bestbuy")){
        currentPage.write(directory,"Bestbuy"+MoreString.padWithZeros(count, (int) Math.floor(MoreMath.log(maxCount, 10)) + 1));

}

if(currentPage.link.getURL().toString().contains("groupon")){
        currentPage.write(directory,"Groupon"+MoreString.padWithZeros(count, (int) Math.floor(MoreMath.log(maxCount, 10)) + 1));

}
    	
else */
	currentPage.write(directory,"P"+MoreString.padWithZeros(count2,2));
//count2++;
    }
    
  }

  protected void indexPage(HTMLPage currentPage) {
		 // int count=0;
	  /*  page.write(saveDir,
	        "P" + MoreString.padWithZeros(count, (int) Math.floor(MoreMath.log(maxCount, 10)) + 1));*/
	    
		  //String url_substring = currentPage.link.getURL().toString().substring(currentPage.link.getURL().toString().length()-5, currentPage.link.getURL().toString().length()-1);  
		  
	    if(currentPage.indexAllowed()){
	   /* if(currentPage.link.getURL().toString().contains("amazon")){
	        currentPage.write(directory,"Amazon"+MoreString.padWithZeros(count, (int) Math.floor(MoreMath.log(maxCount, 10)) + 1));

	}


	if(currentPage.link.getURL().toString().contains("ebay")){
	        currentPage.write(directory,"Ebay"+MoreString.padWithZeros(count, (int) Math.floor(MoreMath.log(maxCount, 10)) + 1));

	}

	if(currentPage.link.getURL().toString().contains("bestbuy")){
	        currentPage.write(directory,"Bestbuy"+MoreString.padWithZeros(count, (int) Math.floor(MoreMath.log(maxCount, 10)) + 1));

	}

	if(currentPage.link.getURL().toString().contains("groupon")){
	        currentPage.write(directory,"Groupon"+MoreString.padWithZeros(count, (int) Math.floor(MoreMath.log(maxCount, 10)) + 1));

	}
	    	
	else */
		currentPage.write(directory,"P"+MoreString.padWithZeros(count,2));
	//count2++;
	    }
	    
	  }

  
  
  /**
   * Spider the web according to the following command options:
   * <ul>
   * <li>-safe : Check for and obey robots.txt and robots META tag
   * directives.</li>
   * <li>-d &lt;directory&gt; : Store indexed files in &lt;directory&gt.</li>
   * <li>-c &lt;maxCount&gt; : Store at most &lt;maxCount&gt; files (default is 10,000).</li>
   * <li>-u &lt;url&gt; : Start at &lt;url&gt;.</li>
   * <li>-slow : Pause briefly before getting a page.  This can be
   * useful when debugging.
   * </ul>
   */
  public static void main(String args[]) {
	 // String url ="https://www.google.com/#q=laptop";
	 
	  String dirName = "C:\\java_workspace\\Web_Crawler\\corpus\\";
	  //String url2 ="http://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=TV";
	 // String url2 ="http://www.ebay.com/sch/i.html?_trksid=p2050601.m570.l1313.TR0.TRC0.Xlaptop&_nkw=laptop&_sacat=0&_from=R40";
	  String url2="http://www.ebay.com";
	  String query="laptop";
	
	  Link lp2 = new Link(url2);
	  Spider sp=new Spider();  
	 // EconoShoppingGuideHome g= new EconoShoppingGuideHome();
  	
  	  //g.Gui3();
  	
  	//g.assignment();
  	  //g.setVisible(true);
	
	//  DirectorySpider dsp=new DirectorySpider(); 
	  
	  sp.linksToVisit.add(lp2);
	  
	  Spider.firstURL=lp2.getURL();
      //dsp.go();
	  
	 
      //System.out.println(yp.topCategoryLink);
	  sp.go();
	  
	 // System.out.println("Shipping Time"+ gp.shipping_time);
	  
	  /*
	 
		
		HTMLPageRetriever ht= new HTMLPageRetriever();
		Link lp;
		HTMLPage currentPage = null;
		//int count=0;
		
		for (int m = 0; m < 40; m = m + 4) 
		{
		String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&start="+m+"&q=";
		//String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
		//String query = "lenovo wireless";
		
		String query = g.input_query;
		
		String charset = "UTF-8";

		try{
		URL url = new URL(address + URLEncoder.encode(query, charset));
		Reader reader = new InputStreamReader(url.openStream(), charset);
		GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

		int total = results.getResponseData().getResults().size();
		System.out.println("total: "+total);

		// Show title and URL of each results
		for(int i=0; i<=3; i++)
		{
			//System.out.println("Title: " + results.getResponseData().getResults().get(i).getTitle());
			//System.out.println("URL: " + results.getResponseData().getResults().get(i).getUrl() + "\n");
			
			try{
			lp= new Link(results.getResponseData().getResults().get(i).getUrl());
			
			
			
			try {
		        currentPage = ht.getHTMLPage(lp);;
		      }
		      catch (PathDisallowedException e) {
		        System.out.println(e);
		        continue;
		      }
			
			
			
			sp.indexPage(currentPage);
			
		
			
		}
			finally
			{
				
			}
			
		}
		
		
		}
		catch(MalformedURLException k)
		{
			
		}
		
		catch(IOException z)
		{
			
		}
		
		
		
		}
		
	
	  
*/
      
	  short docType = DocumentIterator.TYPE_TEXT;
      boolean stem = false, feedback = true;
      String flag = "-html";
      InvertedIndex index = new InvertedIndex(new File(dirName), docType, stem, feedback);
      index.print();
      // Interactively process queries to this index.
      index.processQueries(query);
     
      
      for(String s: index.url_name_list)
      	   System.out.println(s);   
   	  
      
      Iterator<String> iterator6 = sp.url_map_spider.keySet().iterator();  
      
      while (iterator6.hasNext()) {  
          String key = iterator6.next().toString();  
          String value = sp.url_map_spider.get(key).toString();  
          
          System.out.println(key + " " + value);  
       }  
      
        
      for(String s: index.url_name_list)
      {
      	String s2= s.substring(0, s.length()-5);
      	Iterator<String> iterator = sp.url_map_spider.keySet().iterator();  
	        
   	        while (iterator.hasNext()) 
   	        {  
   	           String key = iterator.next().toString();  
   	          String value2 = sp.url_map_spider.get(key).toString();
   	          
   	           
   	           if(s2.equalsIgnoreCase(key))
   	           {
   	            
   	           
   	           System.out.println(key + " " + value2); 
   	        	   
   	           sp.url_map_spider_select.put(key, value2);	  
   	           
   	          	
   	           }
   	        }  
      	
      	
      }
      
      Iterator<String> iterator7 = sp.url_map_spider_select.keySet().iterator();  
      
      while (iterator7.hasNext()) {  
          String key = iterator7.next().toString();  
          String value = sp.url_map_spider_select.get(key).toString();  
          String key2= value.split("\\.")[1];
          
          System.out.println(key + " " + value); 
          
          //sp.url_map_spider_website.put(key2, value);
          //final_list.add(value);
   
      }
      
  
  }


}



