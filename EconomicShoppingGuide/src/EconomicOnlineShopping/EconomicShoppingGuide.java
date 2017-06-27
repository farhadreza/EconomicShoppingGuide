package EconomicOnlineShopping;
/*************************************************************/
//Author:  Md Farhadur Reza, Romas James Hada, December 4, 2013
/*************************************************************/



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class EconomicShoppingGuide {
	protected ArrayList<String> myUrlList = new ArrayList<String>();
	
	public void GetFileNameList(String ShoppingPortal){
		
		// Retrieves File Name from the collection folder
		File dir = new File("src\\essg\\" + ShoppingPortal);
		for (File fn : dir.listFiles()){
			myUrlList.add(fn.getName());
			//JOptionPane.showMessageDialog(null, fn.getName());
		}
		
	}
	
	public void eBayDocs() throws IOException{
		myUrlList.clear(); // Delete all before re-use
		GetFileNameList("eBay"); // For eBay Folder
		for(int i = 0; i < myUrlList.size(); i++){
					
			File input = new File(myUrlList.get(i));
	    	Document eBayDocs = Jsoup.parse(input, "UTF-8");
	    	
	    	Element ItemTitleEbay = eBayDocs.getElementById("itemTitle");
	    	String title = ItemTitleEbay.text();
	    	System.out.println("Title: " + title);
	
	    	Element ItemCondtionEbay = eBayDocs.getElementById("vi-itm-cond");
	    	String ItemCondtion = ItemCondtionEbay.text();
	    	System.out.println("Item Condtion: " + ItemCondtion);
	    	
	    	
	    	Element ItemPrice = eBayDocs.getElementById("prcIsum");
	    	String ItemPrices = ItemPrice.text();
	    	System.out.println("Item Price: " + ItemPrices);
	    	
	    	Element ShippingCost = eBayDocs.getElementById("fshippingCost");
	    	String Shipping_Cost = ShippingCost.text();
	    	System.out.println("Item Price: " + Shipping_Cost);	
		}	
		
	}
	
		
    public static void main(String[] args) throws Exception {
        
    	
    	String url_eBay = "http://www.ebay.com/itm/NEW-2-4GHz-Wireless-Optical-Mouse-Mice-for-Computer-PC-Laptop-USB-2-0-Receiver-/160833284196?pt=Mice&hash=item2572692864";
    	Document eBayDocs = Jsoup.connect(url_eBay).get();
  	
    	Element ItemTitleEbay = eBayDocs.getElementById("itemTitle");
    	String title = ItemTitleEbay.text();
    	System.out.println("Title: " + title);

    	Element ItemCondtionEbay = eBayDocs.getElementById("vi-itm-cond");
    	String ItemCondtion = ItemCondtionEbay.text();
    	System.out.println("Item Condtion: " + ItemCondtion);
    	
    	
    	Element ItemPrice = eBayDocs.getElementById("prcIsum");
    	String ItemPrices = ItemPrice.text();
    	System.out.println("Item Price: " + ItemPrices);
    	
    	Element ShippingCost = eBayDocs.getElementById("fshippingCost");
    	String Shipping_Cost = ShippingCost.text();
    	System.out.println("Item Price: " + Shipping_Cost);	
    	//-----------------------------------------------------------
    	
        Document AmazonDocs = Jsoup.connect("http://www.amazon.com/dp/1589942140/?tag=stackoverfl08-20").userAgent("Mozilla").get();    	
        System.out.println("Meta Description: " + AmazonDocs.select("meta[name=description]").first().attr("content"));
        System.out.println("Meta Description: " + AmazonDocs.select("meta[name=title]").first().attr("content"));
        
        //Element AmazonTitle = AmazonDocs.getElementById("title");
    	//String AmazonTitles = AmazonTitle.val();
//    	System.out.println("Amazon Title: " + AmazonTitles);
//    	
    	//Element AmazonPrice = AmazonDocs.getElementById("price");
    	//String AmazonPrices = AmazonPrice.text();
    	//System.out.println("Amazon Price: " + AmazonPrices);
   
//    	
//    	Element AmazonShipping = AmazonDocs.getElementById("ourprice_shippingmessage");
//    	String AmazonShippings = AmazonShipping.text();
//    	System.out.println("Amazon Price With Shipping: " + AmazonShippings);
//    
//    	
//    	Elements AmazonCustomerRating = AmazonDocs.getElementsByClass("reviewCountTextLinkedHistogram");
//    	String AmazonCustomerRatings = AmazonCustomerRating.text();
//    	System.out.println("Amazon Customer Ratings: " + AmazonCustomerRatings);
//    
    	/*************Walmart*************************/
//    	String url_walmart = "http://www.walmart.com/ip/Dell-Black-Matte-15.6-Inspiron-i15RV-1333BLK-Laptop-PC-with-Intel-Core-i3-3227U-Processor-and-Windows-8-Operating-System/25582170";
//    	Document WalmartDocs = Jsoup.connect(url_walmart).get();
//    	
//    	Elements ItemTitleWalmart = WalmartDocs.getElementsByClass("productTitle");
//    	String ItemTitleWalmarts = ItemTitleWalmart.text();
//    	System.out.println("Walmart Title: " + ItemTitleWalmarts);
//    	
//    	
//    	Elements WalmartPrice = WalmartDocs.getElementsByClass("bigPriceText1");
//    	String WalmartPrices = WalmartPrice.text();
//    	System.out.println("Walmart Price: " + WalmartPrices);
////    	
    	/*************Best Buy*************************/
    	String url_bestbuy = "http://www.bestbuy.com/site/c720-11-6-chromebook-2gb-memory-16gb-solid-state-drive/2746011.p?id=1219077152618&skuId=2746011&st=categoryid$pcmcat244900050010&cp=1&lp=1";
    	Document BestBuyDocs = Jsoup.connect(url_bestbuy).get();
    	
    	Element ItemTitleBestBuy = BestBuyDocs.getElementById("sku-title");
    	String ItemTitleBestBuys = ItemTitleBestBuy.text();
    	System.out.println("BestBuy Title: " + ItemTitleBestBuys);
    	
    	
    	Elements BestBuyPrice = BestBuyDocs.getElementsByClass("item-price");
    	String BestBuyPrices = BestBuyPrice.text();
    	System.out.println("BestBuy Price: " + BestBuyPrices);
    	
    	
    	Elements BestBuyShippingCost = BestBuyDocs.getElementsByClass("free-shipping-message");
    	String BestBuyShippingCosts = BestBuyShippingCost.text();
    	System.out.println("BestBuy Shipping Price: " + BestBuyShippingCosts);
    	
    	Elements BestBuyShippingTime = BestBuyDocs.getElementsByClass("ship-time-message");
    	String BestBuyShippingTimes = BestBuyShippingTime.text();
    	System.out.println("BestBuy Shipping Time: " + BestBuyShippingTimes);
//    	
//    	//       Element e1 = document.getElementById("price");
////    	String price = e1.text();
////    	System.out.println("price: " + price);
////         
//     
////        Elements answerers = document.select("#answers .user-details a");
////        for (Element answerer : answerers) {
////            System.out.println("Answerer: " + answerer.text());
////        }
//        
//        
//      
    }

}
