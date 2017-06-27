//Author: Md Farhadur Reza, Romas James Hada
// Dec 06, 2013


import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.*;

import EconomicOnlineShopping.EcoShopGuide;
import EconomicOnlineShopping.EconomicShoppingGuide;

import com.google.gson.Gson;


/**
 * EconoShoppingGuideHome creates the GUI interface for taking user inputs on
 * user priority constraints, websites priority, user query, selection of Google API
 * or Web Crawler, start searching and outputs the searching results, after applying 
 * vector space model and after applying personalozed ranking algorithm. User can also
 * choose the url to go to that webpage.
 *
 * 
 */

public class EconoShoppingGuideHome extends javax.swing.JFrame implements Runnable{
	
	
	  public Thread backgroundThread;
	 
	  JLabel label0 = new JLabel();
	  JLabel label31 = new JLabel();	
	  JLabel label1 = new JLabel();
	  JLabel label2 = new JLabel();
	  JLabel label3 = new JLabel();
	  JLabel label4 = new JLabel();	  
	  JLabel label5 = new JLabel();
	  JLabel label6 = new JLabel();
	  JLabel label7 = new JLabel();
	  JLabel label8 = new JLabel();
	  JLabel label9 = new JLabel();
	  JLabel label10 = new JLabel();	  
	  JLabel label11 = new JLabel();
	  JLabel label12 = new JLabel();
	  JLabel label13 = new JLabel();	  
	  JLabel label30 = new JLabel();	  	  
	  JLabel label14 = new JLabel();
	  JLabel label15 = new JLabel();
	  JLabel label16 = new JLabel();	  
	  JLabel label17 = new JLabel();
	  JLabel label18 = new JLabel();
	  JLabel label19 = new JLabel();	  
	  JLabel label20 = new JLabel();
	  JLabel label21 = new JLabel();
	  JLabel label22 = new JLabel();	  
	  JLabel label23 = new JLabel();
	  JLabel label24 = new JLabel();
	  JLabel label25 = new JLabel();	  
	  JLabel label26 = new JLabel();	  
	  JLabel final_label = new JLabel();
	  JLabel personalized_label = new JLabel();
	  JLabel label40= new JLabel();
	  	  
	  JButton begin = new JButton();
	  JButton select_button;	  
	  JButton personalized_button;
	  
	  JTextField url = new JTextField();
	  JTextField url_depth = new JTextField();
	  JTextField type_url = new JTextField();
	  JTextArea output_url = new JTextArea();
	  JScrollPane errorScroll = new JScrollPane();
	 
	  JTextArea errors = new JTextArea();
	  JLabel current = new JLabel();	 
	  JLabel url_label = new JLabel();
	  
	  public static String shipping_time;
	  public static String Value;
	  public JTextField shipping;
	  public JTextField cost_product;
	  public JTextField portal;
	  public JTextField state_product;
	 
	  public JTextField final_select_url;
	  public JTextField personalized_select_url;
	 
	  public JTextField crawling_api;
	 
	  public JTextField crawling_url= new JTextField();
	 
	  public JTextField query2 = new JTextField();
	  public String input_query;
	 
	  public int shipping_value;
	  public int product_cost_value;
	  public int portal_value;
	  public int product_state_value;
	 
	 
	  public double shipping_percentage;
	  public double product_cost_percentage;
	  public double portal_percentage;
	  public double product_state_percentage;	 
	  public String crawling_api_select;	 
	  public Retrieval ret;
	 
	  public JTextField amazon;
	  public JTextField ebay;
	  public JTextField groupon;
	  public JTextField buy;
	 
	  public int amazon_value;
	  public int ebay_value;
	  public int groupon_value;
	  public int buy_value;
	 
	  public double amazon_percentage;
	  public double ebay_percentage;
	  public double groupon_percentage;
	  public double buy_percentage;
	 
	  public HashMap<String,String> url_map = new HashMap <String,String>();
	  public HashMap<String,String> url_map_select = new HashMap <String,String>();
	  public HashMap<String,String> url_map_website = new HashMap <String,String>();
	  public HashMap<String,String> url_map_spider_website = new HashMap <String,String>();
	  public HashMap<String,String> url_map_spider_select = new HashMap <String,String>();
	  public String url_website;
	  public int count2=0;
	  
	  //public Collection final_list = new ArrayList();
	  
	  public ArrayList<String> final_list= new ArrayList<String>();
	  
	  public ArrayList<String> personalized_list= new ArrayList<String>();
	
	  public String [] names ={"1","2","3", "4", "5","6","7","8", "9", "10"};	
	  
	  public String [] names2 ={"Google_API","Web_Crawler"};	

	  public JList check_list0= new JList(names2);
	  
	  public JComboBox check_list_crawling_api = new JComboBox(names2);
	  
	  public JList check_list= new JList(names);
	  JList check_list2= new JList(names);
	  JList check_list3= new JList(names);
	  JList check_list4= new JList(names);
	  JList selection_list;
	  JList select_product;
	  JList select_portal;
	  JList product_state;
	  
	  public JList final_check_list; 
	  
	  public JList personalized_check_list;
	  
	  public JScrollPane final_check_Scroll; 
	  public JScrollPane personalized_check_Scroll;

	  JList check_list5= new JList(names);
	  JList check_list6= new JList(names);
	  JList check_list7= new JList(names);
	  JList check_list8= new JList(names);
	  JList select_amazon;
	  JList select_ebay;
	  JList select_groupon;
	  JList select_buy;
	  public boolean cancel = false;
	  
	  
	    JTextArea textArea = new JTextArea(
	    	    "While shopping online how much priority " +
	    	    "you want to give for shipping time?"
	    	);
	    
	    
	    JTextArea textArea2 = new JTextArea(
	    	    "While shopping, how much you care "
	    	    +"about the total cost of the product?"
	    	);
	    
	    JTextArea textArea3 = new JTextArea(
	    	    "While shopping online, how much care about "+ 
	    	    "the shopping portal you are buying from?"
	    	);
	  
	    JTextArea textArea4 = new JTextArea(
	    	    "While shopping online, how much you care " +
	    	    "about the current state of the product you are buying"+
	    	    		"(Brand New, Used, Refurbished)?"
	    	);
	    
	    
	    JTextArea textArea5 = new JTextArea(
	    	    "www.amazon.com" 
	    	);
	    
	    
	    JTextArea textArea6 = new JTextArea(
	    	    "www.ebay.com"
	    	    
	    	);
	    
	    JTextArea textArea7 = new JTextArea(
	    	    "www.groupon.com" 
	    	    
	    	);
	  
	    JTextArea textArea8 = new JTextArea(
	    	    "www.bestbuy.com"
	    	 
	    	);
	    
	    JScrollPane check_Scroll0;
	  JScrollPane check_Scroll;
	  JScrollPane select_Scroll;
	  
	  JScrollPane check_Scroll2;
	  JScrollPane select_Scroll2;
	  
	  JScrollPane check_Scroll3;
	  JScrollPane select_Scroll3;
	  
	  JScrollPane check_Scroll4;
	  JScrollPane select_Scroll4;
	  
	 // JScrollPane check_Scroll5;
	 // JScrollPane select_Scroll6;
	  
	  
	  JScrollPane check_Scroll5;
	  JScrollPane select_Scroll5;
	  
	  JScrollPane check_Scroll6;
	  JScrollPane select_Scroll6;
	  
	  JScrollPane check_Scroll7;
	  JScrollPane select_Scroll7;
	  
	  JScrollPane check_Scroll8;
	  JScrollPane select_Scroll8;
	  
	  
	  // This method shows the GUI to the user for inputs and selections
	  public void Gui3()
	  {
		  	setLayout(new FlowLayout());
	     	setTitle("Personalized E-Shopping Guide");
	     	getContentPane().setLayout(null);
	    
	    	setSize(1300,750);
	    	setVisible(false);
	    
	    	begin.setText("Begin Search");
	    	begin.setActionCommand("Begin Search");
	        getContentPane().add(begin);
	        begin.setBounds(900,20,200,24);
	    
	    
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
	    	
	    	
	     	
	     	
	     	
	     	 //Crawling or API
		    
		   
		    
		    label0.setText("Google API or Crawling");
		    getContentPane().add(label0);
		    label0.setBounds(250,550,150,80);
		    
		/*   // check_list_crawling_api
		    check_list0.setVisibleRowCount(2);
		    check_list0.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		    check_Scroll0= new JScrollPane(check_list0);
		  //  getContentPane().add(url_list);  
		    getContentPane().add(check_Scroll0); 
		   // select_buttton= new JButton("Select");
		    //url_list.setBounds(500,36,90,90);
		    check_Scroll0.setBounds(390,580,100,50);
		    
		    check_list0.addListSelectionListener(
		    		new ListSelectionListener(){
		    			public void valueChanged(ListSelectionEvent event){
		    				//select_ebay.setListData(check_list6.getSelectedValues());
		    				crawling_api.setText(check_list0.getSelectedValue().toString());
		    			}
		    		}
		    		
		    		);*/
		    
		    
		  //  check_list_crawling_api.addActionListener(new ActionListener())
		    
		    getContentPane().add(check_list_crawling_api); 
		    check_list_crawling_api.setBounds(390,580,100,30);
		   // crawling_api.setText("Google_API");
		    check_list_crawling_api.addActionListener(new ActionListener() {
		    	 public void actionPerformed(ActionEvent e) {
		    		
		    	    JComboBox cb = (JComboBox)e.getSource();
		    	    String select_name = (String)cb.getSelectedItem();
		    		 crawling_api.setText(select_name);
		    	 }
		     });
		    
		    
		    //getContentPane().add(select_buttton);
		    
		  //  select_buttton.setBounds(650,36,90,30);
		    
		    crawling_api= new JTextField("Google_API");
		   	 getContentPane().add(crawling_api);
		   	crawling_api.setBounds(500,580,100,30);
		    
		   /* select_ebay= new JList();
		    select_ebay.setVisibleRowCount(1);
		    
		    select_ebay.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		    select_Scroll6= new JScrollPane(select_ebay);
		    getContentPane().add(select_Scroll6);
		    select_Scroll6.setBounds(820,180,30,30);
		    */
  	
	     	
	     	
	    label1.setText("User's Priority List");
	    getContentPane().add(label1);
	    label1.setBounds(20,10,120,10);
	    
	    
	    label26.setText("Enter a Query");
	    getContentPane().add(label26);
	    label26.setBounds(300,530,80,24);
	    
	    getContentPane().add(query2);
	    query2.setBounds(390,530,200,24);
	    
	    
	    label30.setText("Crawling URL");
	    getContentPane().add(label30);
	    label30.setBounds(620,580,80,20);
	    
	    getContentPane().add(crawling_url);
	    crawling_url.setBounds(620,605,200,30);
	    
	    
	    
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
	    
	    //selection_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    
	    check_list.addListSelectionListener(
	    		new ListSelectionListener(){
	   
	    			public void valueChanged(ListSelectionEvent event){
	    			//	selection_list.setListData(check_list.getSelectedValues());
	    				
	    				//shipping= check_list.getSelectedValue().toString();
	    				
	    				//Value= (String) check_list.getSelectedValue();
	    				shipping.setText(check_list.getSelectedValue().toString());
	    				
	    				 
	    			}
	    		}
	    		
	    		);
	    
	    shipping = new JTextField("5");
    	 getContentPane().add(shipping);
    shipping.setBounds(400,50,30,30);
	    
	
	   
	    
	    //getContentPane().add(select_buttton);
	    
	  //  select_buttton.setBounds(650,36,90,30);
	    
	 /*   selection_list= new JList();
	    selection_list.setVisibleRowCount(1);
	    
	    selection_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    select_Scroll= new JScrollPane(selection_list);
	    getContentPane().add(select_Scroll);
	    select_Scroll.setBounds(400,50,30,30);
	    
	    */
	   
	    
    
    
	    
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
	    				//select_product.setListData(check_list2.getSelectedValues());
	    				cost_product.setText(check_list2.getSelectedValue().toString());
	    			}
	    		}
	    		
	    		);
	    
	    
	    
	    cost_product= new JTextField("5");
   	 getContentPane().add(cost_product);
   	cost_product.setBounds(400,180,30,30);
	   
	    
	    //getContentPane().add(select_buttton);
	    
	  //  select_buttton.setBounds(650,36,90,30);
	    
	  /*  select_product= new JList();
	    select_product.setVisibleRowCount(1);
	    
	    select_product.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    select_Scroll2= new JScrollPane(select_product);
	    getContentPane().add(select_Scroll2);
	    select_Scroll2.setBounds(400,180,30,30);*/
	    
	    
	    
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
	    				//select_portal.setListData(check_list3.getSelectedValues());
	    				portal.setText(check_list3.getSelectedValue().toString());
	    			}
	    		}
	    		
	    		);
	    
	    //getContentPane().add(select_buttton);
	    
	  //  select_buttton.setBounds(650,36,90,30);
	    
	    portal= new JTextField("5");
	   	 getContentPane().add(portal);
	   	portal.setBounds(400,300,30,30);
	    
	  /*  select_portal= new JList();
	    select_portal.setVisibleRowCount(1);
	    
	    select_portal.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    select_Scroll3= new JScrollPane(select_portal);
	    getContentPane().add(select_Scroll3);
	    select_Scroll3.setBounds(400,300,30,30);*/
	    
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
	    				//product_state.setListData(check_list4.getSelectedValues());
	    				state_product.setText(check_list4.getSelectedValue().toString());
	    			}
	    		}
	    		
	    		);
	    
	    //getContentPane().add(select_buttton);
	    
	  //  select_buttton.setBounds(650,36,90,30);
	    
	    state_product= new JTextField("5");
	   	 getContentPane().add(state_product);
	   	state_product.setBounds(400,435,30,30);
	    
	    /*product_state= new JList();
	    product_state.setVisibleRowCount(1);
	    
	    product_state.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    select_Scroll4= new JScrollPane(product_state);
	    getContentPane().add(select_Scroll4);
	    select_Scroll4.setBounds(400,435,30,30);*/
	    
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
	    				//select_amazon.setListData(check_list5.getSelectedValues());
	    				amazon.setText(check_list5.getSelectedValue().toString());
	    			}
	    		}
	    		
	    		);
	    
	    //getContentPane().add(select_buttton);
	    
	  //  select_buttton.setBounds(650,36,90,30);
	    
	    amazon= new JTextField("5");
	   	 getContentPane().add(amazon);
	   	amazon.setBounds(820,50,30,30);
	    
	   /* select_amazon= new JList();
	    select_amazon.setVisibleRowCount(1);
	    
	    select_amazon.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    select_Scroll5= new JScrollPane(select_amazon);
	    getContentPane().add(select_Scroll5);
	    select_Scroll5.setBounds(820,50,30,30);*/
	    
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
	    				//select_ebay.setListData(check_list6.getSelectedValues());
	    				ebay.setText(check_list6.getSelectedValue().toString());
	    			}
	    		}
	    		
	    		);
	    
	    //getContentPane().add(select_buttton);
	    
	  //  select_buttton.setBounds(650,36,90,30);
	    
	    ebay= new JTextField("5");
	   	 getContentPane().add(ebay);
	   	ebay.setBounds(820,180,30,30);
	    
	   /* select_ebay= new JList();
	    select_ebay.setVisibleRowCount(1);
	    
	    select_ebay.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    select_Scroll6= new JScrollPane(select_ebay);
	    getContentPane().add(select_Scroll6);
	    select_Scroll6.setBounds(820,180,30,30);
	    */
	    
	    
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
	    				//select_groupon.setListData(check_list7.getSelectedValues());
	    				groupon.setText(check_list7.getSelectedValue().toString());
	    			}
	    		}
	    		
	    		);
	    
	    //getContentPane().add(select_buttton);
	    
	  //  select_buttton.setBounds(650,36,90,30);
	    
	    groupon= new JTextField("5");
	   	 getContentPane().add(groupon);
	   	groupon.setBounds(820,300,30,30);
	    
	  /*  select_groupon= new JList();
	    select_groupon.setVisibleRowCount(1);
	    
	    select_groupon.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    select_Scroll7= new JScrollPane(select_groupon);
	    getContentPane().add(select_Scroll7);
	    select_Scroll7.setBounds(820,300,30,30);*/
	    
	    //Buy
	    
	    label18.setText("BestBuy");
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
	    				//select_buy.setListData(check_list8.getSelectedValues());
	    				buy.setText(check_list8.getSelectedValue().toString());
	    			}
	    		}
	    		
	    		);
	    
	    //input_query= query2.getText();
	    
	    //getContentPane().add(select_buttton);
	    
	  //  select_buttton.setBounds(650,36,90,30);
	    
	    buy= new JTextField("5");
	   	 getContentPane().add(buy);
	   	buy.setBounds(820,435,30,30);
	   	
	   	final_label.setText("Initial Search Results");
	    getContentPane().add(final_label);
	    final_label.setBounds(900,50,150,30);
	    
	    
		
	    
	    label40.setText("Selected URL");
	    getContentPane().add(label40);
	    label40.setBounds(900, 260, 100, 30);
	    
	    personalized_label.setText("Personalized Search Results");
	    getContentPane().add(personalized_label);
	    personalized_label.setBounds(900,400,200,30);
	    
	   	
	    JLabel label43= new JLabel();
	    
	    label43.setText("Selected URL");
	    getContentPane().add(label43);
	    label43.setBounds(900, 600, 100, 30);
	    
	    /*select_buy= new JList();
	    select_buy.setVisibleRowCount(1);
	    
	    select_buy.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    select_Scroll8= new JScrollPane(select_buy);
	    getContentPane().add(select_Scroll8);
	    select_Scroll8.setBounds(820,435,30,30);*/
	    
	    
	  /*  String oneS="1";
	    JRadioButton oneB = new JRadioButton(oneS);
	    oneB.setMnemonic(KeyEvent.VK_B);
	    oneB.setActionCommand(oneS);
	    oneB.setSelected(true);
	    getContentPane().add(oneB);
	    
	    ButtonGroup group = new ButtonGroup();
	    group.add(oneB);
	    
	    oneB.addActionListener(this);
	    
	    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
	    getContentPane().add(radioPanel,BorderLayout.LINE_START);
	    
	    radioPanel.add(oneB);*/
	    
	    select_button= new JButton("Go to the Webpage");
	    
	    select_button.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent event){
	    				try{
	    			    	java.awt.Desktop.getDesktop().browse(java.net.URI.create(final_select_url.getText().toString()));
	    			    }
	    			    catch(Exception e){
	    			    	
	    			    }
	    			}
	    		}
	    		
	    		);
	    
	    getContentPane().add(select_button);
	    
	    select_button.setBounds(900,350,200,30);
	    
	    
       personalized_button= new JButton("Go to the Webpage");
	    
	    personalized_button.addActionListener(
	    		new ActionListener(){
	    			public void actionPerformed(ActionEvent event){
	    				try{
	    			    	java.awt.Desktop.getDesktop().browse(java.net.URI.create(personalized_select_url.getText().toString()));
	    			    }
	    			    catch(Exception e){
	    			    	
	    			    }
	    			}
	    		}
	    		
	    		);
	    
	    getContentPane().add(personalized_button);
	    
	    personalized_button.setBounds(900,670,200,30);
	    
	    
	    
	    StartAction start_action = new StartAction();
	    begin.addActionListener(start_action);
	    
	  /*  backgroundThread = new Thread(this);
	    backgroundThread.start();*/
	    
	   /* for (int i = 0; i < selection_list.getModel().getSize(); i++) {
	        Object item = selection_list.getModel().getElementAt(i);
	        String s=item.toString();
	        System.out.println("Selection value is"+ s);
	    }*/
	    
	  }
	  
	//Internal class used to dispatch events
   class StartAction implements java.awt.event.ActionListener {
		    public void actionPerformed(java.awt.event.ActionEvent event)
		    {
		      Object object = event.getSource();
		      if ( object == begin )
		        start_actionPerformed(event);
		    }
	 }

	//Called when the begin or cancel buttons are clicked

    void start_actionPerformed(java.awt.event.ActionEvent event)
	{
		    if ( backgroundThread==null ) {
		      begin.setLabel("Cancel");
		      //begin.setLabel("begin");
		      backgroundThread = new Thread(this);
		      backgroundThread.start();
		     
		    } else {
		    	cancel();
		    }

	  }
	  
	  
     public void cancel()
	{
		    cancel = true;
    }
		  
	//This method starts the background thread.  
	 public void run()
	 {
	/*	String d;
	    d= shipping.getText();	    
	    
	    int f;
	    try
	    {
	    f= Integer.parseInt(d);
	    }
	    catch (NumberFormatException nfe)
	    {
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	    }
	    
	   // String s;
	   
	   
	   System.out.println("Selection value is"+ d);
		   
	   
	   SwingUtilities.invokeLater(new Runnable() {
   	       public void run() {
   	
   	System.out.println("Shipping Time"+shipping.getText().toString());
   	       }});
		    */
		 
		 Runnable doLater = new Runnable()
	      {
	        public void run()
	        {
	          begin.setText("Begin Search");
	          
	          HashMap<String, Integer> website_reliability = new HashMap<String, Integer>();   
	          
	          shipping_value= Integer.parseInt(shipping.getText().toString());
	          product_cost_value= Integer.parseInt(cost_product.getText().toString());
	          portal_value= Integer.parseInt(portal.getText().toString());
	          product_state_value= Integer.parseInt(state_product.getText().toString());
	          
              shipping_percentage = ((double)(shipping_value))/(double)(shipping_value+product_cost_value+portal_value+product_state_value);
              
              product_cost_percentage = (double)(product_cost_value)/(double)(shipping_value+product_cost_value+portal_value+product_state_value);
	          
              portal_percentage = (double)(portal_value)/(double)(shipping_value+product_cost_value+portal_value+product_state_value);
              
              product_state_percentage = (double)(product_state_value)/(double)(shipping_value+product_cost_value+portal_value+product_state_value);
              
              
             // System.out.printf("%d",shipping_value);
              System.out.println();
  	          System.out.printf("Shipping: %.3f Product-Cost:%.3f Portal:%.3f Product-State:%.3f",shipping_percentage,product_cost_percentage,portal_percentage,product_state_percentage);
              
	          
	          amazon_value= Integer.parseInt(amazon.getText().toString());
	          ebay_value= Integer.parseInt(ebay.getText().toString());
	          groupon_value= Integer.parseInt(groupon.getText().toString());
	          buy_value= Integer.parseInt(buy.getText().toString());
	          
	          amazon_percentage= (double)(amazon_value)/(double)(amazon_value+ebay_value+groupon_value+buy_value);
	          ebay_percentage= (double)(ebay_value)/(double)(amazon_value+ebay_value+groupon_value+buy_value);
	          groupon_percentage= (double)(groupon_value)/(double)(amazon_value+ebay_value+groupon_value+buy_value);
	          buy_percentage= (double)(buy_value)/(double)(amazon_value+ebay_value+groupon_value+buy_value);
	          
	          System.out.printf("Amazon: %.3f ebay:%.3f groupon:%.3f buy:%.3f",amazon_percentage,ebay_percentage,groupon_percentage,buy_percentage);
	          website_reliability.put(amazon.getText().toString(), amazon_value);
	          website_reliability.put(ebay.getText().toString(), ebay_value);
	          website_reliability.put(groupon.getText().toString(), groupon_value);
	          website_reliability.put(buy.getText().toString(), buy_value);
	          
	          
	          
	          String dirName = "C:\\java_workspace\\Web_Crawler\\corpus\\";
	          String url2 ="http://www.ebay.com/sch/i.html?_odkw=lenovo+mouse&_osacat=0&_from=R40&_trksid=p2045573.m570.l1313.TR12.TRC2.A0.Xlenovo+laptop&_nkw= laptop lenovo wireless mouse n50 &_sacat=0";
	          
	          //String url2 =crawling_url.getText().toString();
	          
	          
	       // count2=0;
	          
	          Spider sp=new Spider(); 
	          Link lp2= new Link(url2);
			    sp.linksToVisit.add(lp2);
			  		
			    Spider.firstURL=lp2.getURL();
	          
	          
	          
	       if(crawling_api.getText().toString().equals("Google_API")){
	          
	         
	   	   Link lp;
	          HTMLPageRetriever ht= new HTMLPageRetriever();
	  		
	  		
	  		HTMLPage currentPage = null;
	  		
	  		//int count=0;
	  		
	  		for (int m = 0; m < 20; m = m + 4) 
	  		{
	  		String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&start="+m+"&q=";
	  		//String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
	  		//String query3 = "lenovo";
	  		
	  		//String query = input_query;
	  		String query = query2.getText();
	  		
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
	  		        currentPage = ht.getHTMLPage(lp);
	  		       
	  		      }
	  		      catch (PathDisallowedException e) {
	  		        System.out.println(e);
	  		        continue;
	  		      }
	  			
	  			 url_website = results.getResponseData().getResults().get(i).getUrl().toString().split("\\.")[1];
	  		        
	  		    url_map.put("P"+MoreString.padWithZeros(count2,2), results.getResponseData().getResults().get(i).getUrl().toString());
	  		      
	  		        
	  			
	  			sp.indexPage(currentPage,count2);
	  			count2++;
	  			
	  		
	  			
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
	  		
	  		catch (NullPointerException nullPointer)  
	  		{  
	  		 
	  		}
	  		
	  		
	  		
	  		}
	  		
	        }
	          
	       
	       else if(crawling_api.getText().toString().equals("Web_Crawler")){
	    	   
	    	
	  		
	  		sp.go();
	  		
	       }
	          
	       
	      //  System.out.println(shipping_value);
	        //System.out.format("%.3f%n", shipping_percentage);
	       
	      //  System.out.format("%.0f, %.0f,%.0f,%.0f",shipping_percentage,product_cost_percentage,portal_percentage,product_state_percentage);
	        
	    //    System.out.printf("%f",shipping_percentage);
	        
	      //  System.out.println("Amazon "+amazon_percentage +" Ebay%: "+ebay_percentage +" Groupon%:"+groupon_percentage+" Buy%: "+buy_percentage);
	        
	      
	       if(crawling_api.getText().toString().equals("Web_Crawler"))
	       {
	    	   url_map=(HashMap) sp.url_map_spider.clone();
	       }
	       
	       else if(crawling_api.getText().toString().equals("Google_API"))
	       {
	    	   sp.url_map_spider=(HashMap) url_map.clone();
	       }
	       
	       
	        Iterator<String> iterator6 = sp.url_map_spider.keySet().iterator();  
	        
	       while (iterator6.hasNext()) {  
	           String key = iterator6.next().toString();  
	           String value = sp.url_map_spider.get(key).toString();  
	           
	           System.out.println(key + " " + value);  
	        }  
	        
	       
	       
	        short docType = DocumentIterator.TYPE_TEXT;
	        boolean stem = false, feedback = true;
	        String flag = "-html";
	       InvertedIndex index = new InvertedIndex(new File(dirName), docType, stem, feedback);
	       // index.print();
	        // Interactively process queries to this index.
	       index.processQueries(query2.getText());
	       
	     //  String query4="lenovo";
	       // index.processQueries(query4);
	     //   index.processQueries();
	        
	       for(String s: index.url_name_list)
	    	   System.out.println(s);   
	       
	               
	        for(String s: index.url_name_list)
	        {
	        	String s2= s.substring(0, s.length()-5);
	        	Iterator<String> iterator = url_map.keySet().iterator();  
		        
	     	        while (iterator.hasNext()) 
	     	        {  
	     	           String key = iterator.next().toString();  
	     	          String value2 = url_map.get(key).toString();
	     	          
	     	           
	     	           if(s2.equalsIgnoreCase(key))
	     	           {
	     	            
	     	           
	     	           //System.out.println(key + " " + value2); 
	     	        	   
	     	           url_map_select.put(key, value2);	  
	     	           
	     	          	
	     	           }
	     	        }  
	        	
	        	
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
	     	            
	     	           
	     	           //System.out.println(key + " " + value2); 
	     	        	   
	     	           url_map_spider_select.put(key, value2);	  
	     	           
	     	          	
	     	           }
	     	        }  
	        	
	        	
	        }
	        
	        
	        
	        Iterator<String> iterator3 = url_map_select.keySet().iterator();  
	        
		       while (iterator3.hasNext()) {  
		           String key = iterator3.next().toString();  
		           String value = url_map_select.get(key).toString();  
		           String key2= value.split("\\.")[1];
		           
		           System.out.println(key + " " + value); 
		           
		           url_map_website.put(key2, value);
	        
		       }
	        
		       
		       Iterator<String> iterator7 = url_map_spider_select.keySet().iterator();  
		        
		       while (iterator7.hasNext()) {  
		           String key = iterator7.next().toString();  
		           String value = url_map_spider_select.get(key).toString();  
		           String key2= value.split("\\.")[1];
		           
		           System.out.println(key + " " + value); 
		           
		           url_map_spider_website.put(key2, value);
		           final_list.add(value);
	        
		       }
	        
		       
		       
		       Iterator<String> iterator4 = url_map_website.keySet().iterator();  
		        
		       while (iterator4.hasNext()) {  
		           String key = iterator4.next().toString();  
		           String value = url_map_website.get(key).toString();  
		           
		           System.out.println(key + " " + value); 
		           final_list.add(value);
	        
		       }
	        
		       Iterator<String> iterator8 = url_map_spider_website.keySet().iterator();  
		        
		       while (iterator8.hasNext()) {  
		           String key = iterator8.next().toString();  
		           String value = url_map_spider_website.get(key).toString();  
		           
		           System.out.println(key + " " + value); 
	        
		       }
		       
		       for(String s:final_list)
		    	   System.out.println(s);
	        
		       //url_website = results.getResponseData().getResults().get(i).getUrl().toString().split("\\.")[1];
	        
	          
		       DefaultListModel model = new DefaultListModel();
		       
		       for (int i = 0; i < final_list.size(); i++) {
		            model.addElement(final_list.get(i)); // <-- Add item to model
		        }
	          
		       final_check_list= new JList(model);
		       
		       
		       
		       
			    
			    final_check_list.setVisibleRowCount(5);
			    final_check_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			    final_check_Scroll= new JScrollPane(final_check_list);
			  //  getContentPane().add(url_list);  
			    getContentPane().add(final_check_Scroll); 
			   // select_buttton= new JButton("Select");
			    //url_list.setBounds(500,36,90,90);
			    final_check_Scroll.setBounds(900,100,300,150);
			    
			    final_check_list.addListSelectionListener(
			    		new ListSelectionListener(){
			    			public void valueChanged(ListSelectionEvent event){
			    				//select_ebay.setListData(check_list6.getSelectedValues());
			    				final_select_url.setText(final_check_list.getSelectedValue().toString());
			    			}
			    		}
			    		
			    		);
			    
			   
			    
			    final_select_url= new JTextField(30);
			    getContentPane().add(final_select_url);
			    final_select_url.setBounds(900,320,300,30);
			    
			    
			    String result= final_select_url.getText().toString();
			    
			    //http://www.ebay.com/sch/i.html?_odkw=lenovo+mouse&_osacat=0&_from=R40&_trksid=p2045573.m570.l1313.TR12.TRC2.A0.Xlenovo+laptop&_nkw= OurQuery &_sacat=0
			    
			    //http://www.ebay.com/sch/i.html?_trksid=p2050601.m570.l1313.TR0.TRC0.Xlaptop+lenovo+wireless+mouse+n50&_nkw=laptop+lenovo+wireless+mouse+n50&_sacat=0&_from=R40
			    
			    
			    /**************************************/
			   /* EcoShopGuide myPersonalizedSearch = new EcoShopGuide(final_list, 
			    		shipping_percentage, 
			    		product_cost_percentage,
			    		portal_percentage, 
			    		product_state_percentage, 
			    		ebay_percentage, 
			    		buy_percentage, 
			    		amazon_percentage);
			    
			    try {
					myPersonalizedSearch.getValuableDocs();
				
			    
			    
			   // myPersonalizedSearch.ProductInfo.get(Value);
			  
			    
			    Iterator<String> myIteratorForPrinting = myPersonalizedSearch.SortedProducts.keySet().iterator();
				
				while(myIteratorForPrinting.hasNext()){
					String URL = (String) myIteratorForPrinting.next();
				    Double ProductRSV =  myPersonalizedSearch.SortedProducts.get(URL);
				    	
				    //JOptionPane.showMessageDialog(null, "URL: " + URL + "\n" + "Product RSV:" + ProductRSV);
				    System.out.println("\nURL: " + URL + "\n" + "Product RSV:" + ProductRSV);
				    personalized_list.add(URL);
				    
				 }
			
			    
			       
			       for(String s: personalized_list)
			    	   System.out.println(s);
			       
			       DefaultListModel model2 = new DefaultListModel();
			       
			       for (int i = 0; i < personalized_list.size(); i++) {
			            model2.addElement(personalized_list.get(i)); // <-- Add item to model
			        }
		          
			       personalized_check_list= new JList(model2);
			       
			       
			       
			       personalized_check_list.setVisibleRowCount(5);
			       personalized_check_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			       personalized_check_Scroll= new JScrollPane(personalized_check_list);
				  //  getContentPane().add(url_list);  
				    getContentPane().add(personalized_check_Scroll); 
				   // select_buttton= new JButton("Select");
				    //url_list.setBounds(500,36,90,90);
				    personalized_check_Scroll.setBounds(900,440,300,150);
				    
				    personalized_check_list.addListSelectionListener(
				    		new ListSelectionListener(){
				    			public void valueChanged(ListSelectionEvent event){
				    				//select_ebay.setListData(check_list6.getSelectedValues());
				    				personalized_select_url.setText(personalized_check_list.getSelectedValue().toString());
				    			}
				    		}
				    		
				    		);
				    
				   
				    
				    personalized_select_url= new JTextField(30);
				    getContentPane().add(personalized_select_url);
				    personalized_select_url.setBounds(900,630,300,30);
				    
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   */    
			    
			  /*  try{
			    	java.awt.Desktop.getDesktop().browse(java.net.URI.create(result));
			    }
			    catch(Exception e){
			    	
			    }*/
			    
			 //   Browser br= new Browser();
			   // Browser.display(result);
	        
	        }
	      };
	      SwingUtilities.invokeLater(doLater);
	      backgroundThread=null;
		    
		    
	 }
	  
	 
	 
	  public void assignment()
		 {
		  SwingUtilities.invokeLater(new Runnable() {
   	       public void run() {
   	
   	System.out.println("Shipping Time"+shipping.getText().toString());
   	       }});
		 }
	  
	  
    public static void main(String[] args)
    {
    	
    	//public String [] names2 ={"1","2","3", "4", "5","6","7","8", "9", "10"};	 
  	  //public JList check_list= new JList(names2);
    	
    	String value2;
    	
    	//SwingUtilities.invokeLater(new Runnable() {
       //public void run() {
    	EconoShoppingGuideHome g= new EconoShoppingGuideHome();
    	
    	g.Gui3();
    	
    	//g.assignment();
    	g.setVisible(true);
    	
         //   }
    	//});
    	
   //	g.assignment();
    	
    	
    	
    	 //System.out.println("value is"+Value);
    	 
    	 
    	 
    	/* check_list.addListSelectionListener(
 	    		new ListSelectionListener(){
 	    			public void valueChanged(ListSelectionEvent event){
 	    				//selection_list.setListData(check_list.getSelectedValues());
 	    				
 	    				//value2= (String) check_list.getSelectedValue();
 	    				
 	    				 
 	    			}
 	    		}
 	    		
 	    		);*/
    	 
    	 
    	 //Object selected = check_list.getSelectedValue();
 	    //Value= (String) selected.toString();
    	 
    	// System.out.println("Selection is "+value2);
 	    
    	 
    }
}
