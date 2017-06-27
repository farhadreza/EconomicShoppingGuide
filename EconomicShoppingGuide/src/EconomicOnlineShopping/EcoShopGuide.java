package EconomicOnlineShopping;
/*****************************************************************/
//Author: Romas James Hada, December 4, 2013
//Md Farhadur Reza
/*****************************************************************/
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class EcoShopGuide {
	protected ArrayList<String> SellerUrlList = new ArrayList<String>();
	protected HashMap<String, Product> ProductInfo =  new HashMap<String, Product>(); // Key URL, and Value = an instance of Product Class
	protected UserRequirements myRequirements;
	//protected HashMap<String, Product> OrderedProducts = new HashMap <String, Product>();
	
	public EcoShopGuide(){
		
		myRequirements = new UserRequirements(0.1, 0.9, 0.0, 0.0);
		myRequirements.UserSelectedSellerPriority.put("eBay", 0.9);
		
		insertURL("http://www.ebay.com/itm/New-lenovo-N50-Wireless-optical-mouse-free-shipping-/171183003987?pt=Mice&hash=item27db4d5953");
		insertURL("http://www.ebay.com/itm/Wireless-Mouse-LENOVO-N50-Black-/251381540157?pt=Mice&hash=item3a8781e53d");
	}
	
	public void insertURL(String URL){

		SellerUrlList.add(URL);
		
	}
	
	public void eBay(String URL_eBay) throws IOException{
	

    	//String url_eBay = "http://www.ebay.com/itm/NEW-2-4GHz-Wireless-Optical-Mouse-Mice-for-Computer-PC-Laptop-USB-2-0-Receiver-/160833284196?pt=Mice&hash=item2572692864";
    	Document eBayDocs = Jsoup.connect(URL_eBay).get();
  	
    	Element ItemTitleEbay = eBayDocs.getElementById("itemTitle");
    	String title = ItemTitleEbay.text();
    	
    	System.out.println("Title: " + title);

    	Element ItemPrice = eBayDocs.getElementById("prcIsum");
    	String ItemPrices = ItemPrice.text();
    	System.out.println("Item Price: " + ItemPrices);
    	

    	Element ShippingCost = eBayDocs.getElementById("fshippingCost");
    	String Shipping_Cost = ShippingCost.text();
    	System.out.println("Item Price: " + Shipping_Cost);	
    	
    	
    	Element ItemCondtionEbay = eBayDocs.getElementById("vi-itm-cond");
    	String ItemCondtion = ItemCondtionEbay.text();
    	System.out.println("Item Condtion: " + ItemCondtion);
    	
    	
    	// Create Product Instance
    	if(!ProductInfo.containsKey(URL_eBay)){
    		ProductInfo.put(URL_eBay, new Product(URL_eBay, "eBay", title, ExtractNumberFromString(ItemPrices), ExtractNumberFromString(Shipping_Cost)));
    		
    	}
    }	
		
	public String getLowestPriceAndShippingTime(){
		double LowestPrice = 0.0;
		double LowestShippingTime = 0.0;
		Product myProduct;
		String URL;
		
		Iterator<String> myIterator = ProductInfo.keySet().iterator();
		URL = myIterator.next();
		LowestPrice =  ProductInfo.get(URL).getTotalCost();
		LowestShippingTime = ProductInfo.get(URL).getShippingCost();
		
		while(myIterator.hasNext()){
			URL = (String) myIterator.next();
		    myProduct =  ProductInfo.get(URL);
		    
		    if(LowestPrice >  myProduct.getTotalCost()){
		    	LowestPrice = myProduct.getTotalCost();
		    }
		    
		    if(LowestShippingTime >  myProduct.getTotalCost()){
		    	LowestShippingTime = myProduct.getTotalCost();
		    }
		    
		    
		}
		
		return Double.toString(LowestPrice) + "@" +  Double.toString(LowestShippingTime);
	}
	
	public void calculateProductRSV(){
		double ProdRSV;
		
		String Data[] = getLowestPriceAndShippingTime().split("@");
		double LowestPrice = Double.parseDouble(Data[0]);
		double LowestShippingTime =  Double.parseDouble(Data[1]);
		
		
		Iterator<String> myIterator = ProductInfo.keySet().iterator();
		while(myIterator.hasNext()){
			String URL = (String) myIterator.next();
		    Product myProduct =  ProductInfo.get(URL);
		    
		    myProduct.setNormalizedTotalCost(LowestPrice/myProduct.getTotalCost());
		    myProduct.setNormalizedShippingTime(LowestShippingTime/myProduct.getShippingTime());
		    
		    ProdRSV = myRequirements.getUserCostPriority() * myProduct.getNormalizedTotalCost() 
		    		+ myRequirements.getUserQualityPriority() * myProduct.getProductQuality() 
		    		+ myRequirements.getUserShippingPriority() * myProduct.getNormalizedShippingTime()
		    		+ myRequirements.getUserSellerPriority() * myRequirements.getUserSelectedSellerPriority().get(myProduct.getProductSeller());
		    
		    myProduct.setProductRSV(ProdRSV);
		    
		}
	}
	
	public double ExtractNumberFromString(String myString){
		double myNumber = 0.0;
		
		 if(myString.contains("free") || myString.contains("FREE") || myString.contains("Free")){
		   	    
			return 0.0;
		}
		else{
			
			Pattern myPricePattern = Pattern.compile("-?[\\d\\.]+");
			Matcher MyMatcher = myPricePattern.matcher(myString);
			while (MyMatcher.find()) {
				myNumber = Math.abs(Double.parseDouble(MyMatcher.group())); // 3-4 Days will give 3.0 and 4.0
			}
		}
		return myNumber;
	}
	
	public static void main(String[] args) throws IOException {
		
		EcoShopGuide myGuide = new EcoShopGuide();
		
		for(int i = 0; i < myGuide.SellerUrlList.size(); i++){
			myGuide.eBay(myGuide.SellerUrlList.get(i));
			myGuide.calculateProductRSV();
			System.out.println("\nProduct RSV: " + myGuide.ProductInfo.get(myGuide.SellerUrlList.get(i)).getProductRSV() + "\n"
					+ myGuide.ProductInfo.get(myGuide.SellerUrlList.get(i)).getProductURL() + "\n" 
					+ myGuide.ProductInfo.get(myGuide.SellerUrlList.get(i)).getTotalCost());
			}
	}

}
