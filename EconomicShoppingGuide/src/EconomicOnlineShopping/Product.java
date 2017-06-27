package EconomicOnlineShopping;
/*****************************************************************/
// Authors: Romas James Hada, December 4, 2013
// Md Farhadur Reza
/*****************************************************************/
public class Product {
	
	// Properties of a product
	 String ProductTitle; // Title of a Product
	 String ProductURL; // Link of the Product, example: www.amazon.com/...
	 String ProductSeller; // Like Amazon, eBay, or Walmart ...
	 
	 int ProductQuality; // Quality of the product, (New = 10, Used = 5, Refurbished = 9)
	 double ShippingTime; // In days
	 
	 double TotalCost;
	 double ShippingCost;
	 double MarkedPrice; // Marked Price of the product
	 
	 double ProductRSV; // The user value of the product
	 double NormalizedTotalCost; // LowestCost in the list / Total Cost of the Product
	 double NormalizedShippingTime; // LowestShippingTime / ShippingTime of the Product
	
	 public Product(String _ProductURL, String _ProductSeller, String _ProductTitle, double _MarkedPrice, double _ShippingCost){
		 ProductURL = _ProductURL;
		 ProductSeller = _ProductSeller;
		 ProductTitle = _ProductTitle;
		 MarkedPrice = _MarkedPrice;
		 ShippingCost = _ShippingCost;
		 
		 ShippingTime = 9; // Standard Shipping time is 4-14 Days, if not provided
		 ProductQuality = 10; // Assuming Brand New Product
		 
		 TotalCost = MarkedPrice + ShippingCost;
	 }
	 
	 public Product(String _ProductURL, String _ProductSeller, String _ProductTitle, double _MarkedPrice, double _ShippingCost, int _ShippingTime, int _ProductQuality){
		 ProductURL = _ProductURL;
		 ProductSeller = _ProductSeller;
		 ProductTitle = _ProductTitle;
		 MarkedPrice = _MarkedPrice;
		 ShippingCost = _ShippingCost;
		 
		 ShippingTime = _ShippingTime;
		 ProductQuality = _ProductQuality;
		 
		 TotalCost = MarkedPrice + ShippingCost;
	 }
	 
	 // Set Data
	 public void setProductURL(String _ProductURL){
		 ProductURL = _ProductURL;
	 }
	 
	 public void setProductSeller(String _ProductSeller){
		 ProductSeller = _ProductSeller;
	 }
	 
	 public void setProductTitle(String _ProductTitle){
		 ProductTitle = _ProductTitle;
	 }
	 
	 public void setMarkedPrice(double _MarkedPrice){
		 MarkedPrice = _MarkedPrice;
	 }
	 
	 public void setShippingCost(double _ShippingCost){
		 ShippingCost = _ShippingCost;
	 }
	 
	 public void setShippingTime(double _ShippingTime){
		 ShippingTime = _ShippingTime;
	 }
	 
	 public void setProductQuality(int _ProductQuality){
		 ProductQuality = _ProductQuality;
	 }
	 
	 public void setTotalCost(int _TotalCost){
		 TotalCost = _TotalCost;
	 }
	 
	 public void setNormalizedTotalCost(double _NormalizedTotalCost){
		 NormalizedTotalCost = _NormalizedTotalCost;
	 }
	 
	 public void setNormalizedShippingTime(double _NormalizedShippingTime){
		 NormalizedShippingTime = _NormalizedShippingTime;
	 }
	 
	 public void setProductRSV(double _ProductRSV){
		 
		 ProductRSV = _ProductRSV;
	 }
	 
	 // Get Data
	 public String getProductURL(){
		 return ProductURL;
	 }
	 
	 public String getProductSeller(){
		 return ProductSeller;
	 }
	 
	 public String geProductTitlet(){
		 return ProductTitle;
	 }
	 
	 public double getMarkedPrice(){
		 return MarkedPrice ;
	 }
	
	 public double getShippingCost(){
		 return ShippingCost;
	 }
	 
	 public double getShippingTime(){
		 return ShippingTime;
	 }
	
	 public int getProductQuality(){
		 return ProductQuality;
	 }
	 
	 public double getTotalCost(){
		 return TotalCost;
	 }
	 
	 public double getNormalizedTotalCost(){
		 return NormalizedTotalCost;
	 }
	 
	 public double getNormalizedShippingTime(){
		 return NormalizedShippingTime;
	 }
	 
	 public double getProductRSV(){
		 return ProductRSV;
	 }
}
