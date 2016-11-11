import java.util.ArrayList;
import java.util.List;

public class Order implements Trackable {
	List<Item> order;  // current order to fulfill
	List<Item> bin = new ArrayList<Item>();	   // bin being filled (New object?)
	int orderNumber;
	String orderLocation;
	String status; 
	String requester;
	
	// Creates Order Object
	public Order(List<Item> items, String customer, int number) {
		status = "Incomplete";
		orderNumber = number;
		order = items;
		requester = customer;
	}
	
	public void updateStatus(String update) {
		status = update;
	}
	
	public String getStatus() {
		return status;
	}
	
	// adds the needed item to the bin currently  
	public void getItemNeeded(Item product) {
		bin.add(product);
	}
	
	public List<Item> getItems() {
		return bin;
	}
	
	public void addItem(Item added) {
		added.updateStatus("In the bin");
		added.updateLocation("orderLocation");
		bin.add(added);
	}
	
	public void removeItem(Item removed) {
		removed.updateStatus("Not in the bin");
		removed.updateLocation(orderLocation);
		bin.remove(removed);
	}
	
	// Checks status of Order
	public boolean orderFulfilled() {    
		if (bin.equals(order)) {
			updateStatus("Order Finished");
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getLocation() {
		return orderLocation; 
	}
	
	public void updateLocation(String update){
		orderLocation = update;
	}
	
	// Adds all needed items to the Order
	public void completeOrder() {
		while (orderFulfilled() != true) {
			for (int i = 0; i < order.size(); i++) {
				getItemNeeded(order.get(i));
			}
		}
	}
	
	// For testing
	 @Override
	public String toString() {
	      	return ("" + order + "");
	   }
}