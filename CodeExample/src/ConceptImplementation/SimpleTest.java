package ConceptImplementation;

import java.util.*;

public class SimpleTest {
	
	public class Address{
	
}

	public enum Warehouse {
	    EDMONTON, MONTREAL, TORONTO, VANCOUVER
	}
	
	public List<Warehouse> getNearestWarehouses(Address addressOfCustomer){
		return new LinkedList<Warehouse>();
	}

	public Map<Warehouse, Integer> getInventory(String product){
		return new HashMap<Warehouse, Integer>();
	}
	
	public Map<Warehouse, Map<String, Integer>>  getInventoryAllocation(Map<String, Integer> shoppingCart, Address addressOfCustomer) throws Exception {
		 
		Map<Warehouse, Map<String, Integer>>  result= new HashMap<Warehouse, Map<String, Integer>> ();
		 for(Map.Entry<String,Integer> entry: shoppingCart.entrySet())
		 {
			 String product=entry.getKey();
			 Map<Warehouse, Integer>  map= getInventory( product);
			 if(map == null)
			 {
				 throw new  Exception("Not inventory found");
			 }else
			 {
				 Map<String, Integer> mapTemp=new  HashMap<String, Integer>();
				 mapTemp.put(entry.getKey(), entry.getValue());
				 
				 List<Warehouse> listWareHouse=getNearestWarehouses( addressOfCustomer);
				 for(Warehouse warehouse:listWareHouse)
				 {
					 if(map.get(warehouse) !=null)
					 {
						 Map<String, Integer> mapTemp2=result.get(warehouse);
						 mapTemp2.put(entry.getKey(), entry.getValue());
						 break;
					 }else
					 {
						 result.put(warehouse,mapTemp );
						 break;
					 }
				 }
				 
				 
				// result.put(key, mapTemp);
			 }
			 
		 }
		 
		 return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
