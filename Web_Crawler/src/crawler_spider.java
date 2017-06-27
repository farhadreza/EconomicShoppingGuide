import java.io.File;
import java.util.LinkedList;

/*import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ir.vsr.DocumentIterator;
import ir.vsr.InvertedIndex;
import ir.webutils.*;
import ir.*;*/



public class crawler_spider {

    public static void main(String[] args) throws Exception {
        //String url = "http://stackoverflow.com/questions/2835505";
    String url = "http://www.amazon.com/Apple-MacBook-MD101LL-13-3-Inch-VERSION/dp/B0074703CM";
   // Document document = Jsoup.connect(url).get();
    
    String s[]={"-safe"};
    Link lp= new Link(url);
    LinkedList<Link> lt= new LinkedList<Link>();
    lt.add(lp);
   // short docType = DocumentIterator.TYPE_TEXT;
    //boolean stem = false, feedback = false;
    String z;
   // InvertedIndex id= new InvertedIndex(new File("C:\\java_workspace\\561_Assignment1_mxr7945\\src\\stemmed_doc\\Doc_Vector_doc_01.txt"), docType, stem, feedback);
   // z=lp.getURL();
   // System.out.println(z);
    
    
    for(int i=0;i<lt.size();i++)
    	System.out.println(lt.get(i));
    Spider sp= new Spider();
    //System.out.println(lp.getURL());
    
   // sp.main(args);
    //sp.processArgs(args);
   // for(int i=0;i<lt.size();i++)
    //sp.linksToVisit=lt.;
    sp.go();
  // sp.doCrawl();
   // id.print();
    //sp.processArgs(s);
  
    
    
        //String question = document.select("#question .post-text").text();
        //System.out.println("Question: " + question);
   /* Element e = document.getElementById("title");
    String title = e.text();
    System.out.println("title: " + title);
       
        Element e1 = document.getElementById("price");
    String price = e1.text();
    System.out.println("price: " + price);*/
         
     
//        Elements answerers = document.select("#answers .user-details a");
//        for (Element answerer : answerers) {
//            System.out.println("Answerer: " + answerer.text());
//        }
        
    }
}
