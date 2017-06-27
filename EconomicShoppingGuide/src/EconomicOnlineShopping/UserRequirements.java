package EconomicOnlineShopping;
/*****************************************************************/
//Author: Romas James Hada, December 4, 2013
//Md Farhadur Rezaa
/*****************************************************************/
import java.util.HashMap;

public class UserRequirements {
	
	//String UserQuery;
	double UserShippingPriority; // High value means user wants shipping to as fast as possible
	double UserCostPriority; // High value means user wants low price 
	double UserQualityPriority; // High value means user demands brand new products
	double UserSellerPriority; // High value means user wants to get product from highly trustworthy sellers
	
	HashMap<String, Double> UserSelectedSellerPriority = new HashMap<String, Double>(); // Example: Key = Amazon, and Value = 10, User thinks Amazon is more trustworthy
	
	public UserRequirements(double _UserShippingPriority, double _UserCostPriority, double _UserQualityPriority, double _UserSellerPriority,  HashMap <String, Double> _UserSelectedSellerPriority){
		UserShippingPriority = _UserShippingPriority;
		UserCostPriority = _UserCostPriority;
		UserQualityPriority = _UserQualityPriority;
		UserSellerPriority = _UserSellerPriority;
		
		UserSelectedSellerPriority = _UserSelectedSellerPriority;
	}
	
	public UserRequirements(double _UserShippingPriority, double _UserCostPriority, double _UserQualityPriority, double _UserSellerPriority){
		UserShippingPriority = _UserShippingPriority;
		UserCostPriority = _UserCostPriority;
		UserQualityPriority = _UserQualityPriority;
		UserSellerPriority = _UserSellerPriority;
		
		
	}
	
	public void setUserShippingPriority( double _UserShippingPriority){
		
		UserShippingPriority = _UserShippingPriority;
	}
	
	public void setUserCostPriority(double _UserCostPriority){
		
		UserCostPriority = _UserCostPriority;
	}
	
	public void setUserQualityPriority(double _UserQualityPriority){
	
		UserQualityPriority = _UserQualityPriority;
	}
	
	public void setUserSellerPriority(double _UserSellerPriority){
	
		UserSellerPriority = _UserSellerPriority;
	}
	
	public void setSellerInfo(HashMap<String, Double> _UserSelectedSellerPriority){
		
		UserSelectedSellerPriority = _UserSelectedSellerPriority;
	}
	
	public double getUserShippingPriority(){
		
		return UserShippingPriority;
	}
	
	public double getUserCostPriority(){
		
		return UserCostPriority;
	}

	public double getUserQualityPriority(){
	
		return UserQualityPriority;
	}
	
	public double getUserSellerPriority(){
	
		return UserSellerPriority;
	}

	public HashMap<String, Double> getUserSelectedSellerPriority(){
	
		return UserSelectedSellerPriority;
	}
	
}