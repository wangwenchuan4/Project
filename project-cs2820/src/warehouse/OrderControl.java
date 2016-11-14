import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

	/**
	 * @author Casey Kolodziejczyk
	 * This is the OrderControl class where all orders will be stored
	 * methods will allow for order to be added, removed, and completed 
	 * Might need to change allOrders from a hashmap, but not at the moment
	 */
public class OrderControl {
	HashMap<Integer, Order> allOrders;   // order # , List of Items  
	String status;
	
	
	/**
	 * @author Casey Kolodziejczyk
	 * Creates OrderControl Object
	 * But at this moment, Simply creates two orders of items
	 */
	public OrderControl(){
		allOrders = new HashMap<Integer, Order>();
		
		Item testItem1 = new Item(1, "Baseball");
		Item testItem2 = new Item(2, "Glove");
		Item testItem3 = new Item(3, "Bat");
		
		Item testItem4 = new Item(4, "Hockey Stick");
		Item testItem5 = new Item(5, "Puck");
		
		List<Item> testItems1 = new ArrayList<Item>();
		
		testItems1.add(testItem1);
		testItems1.add(testItem2);
		testItems1.add(testItem3);
		
		List<Item> testItems2 = new ArrayList<Item>();
		
		testItems2.add(testItem4);
		testItems2.add(testItem5);
		
		Order TestOrder1 = new Order(testItems1, "Maclean Hall", 1);
				
		Order TestOrder2 = new Order(testItems2, "Herman's House", 2);
		
		allOrders.put(TestOrder1.orderNumber, TestOrder1);
		allOrders.put(TestOrder2.orderNumber, TestOrder2);
		
	}
	/**
	 * @author Casey Kolodziejczyk
	 * @param orderNum
	 * @param newest
	 * Adds an order to the Hash of Orders
	 */
	public void addOrder(int orderNum, Order newest) {
		allOrders.put(orderNum, newest);
	}
	
	/**
	 * @author Casey Kolodziejczyk
	 * @param ordernum
	 * Removes an order from the Hash of Orders
	 */
	public void removeOrder(int ordernum) {
		allOrders.remove(ordernum);
	}
	/**
	 * @author Casey Kolodziejczyk
	 * @param updated
	 * @param statusUpdate
	 * Updates the status of an individual order
	 * (Might just need to change it to updated.Isfilled())
	 */ 
	public void updateOrder(Order updated, String statusUpdate) {
		updated.status = statusUpdate;
	}
	/**
	 * @author Casey Kolodziejczyk
	 * @param orderChecked (Order Object)
	 * @return the status of an individual order
	 */
	public String orderStatus(Order orderChecked) {
		return orderChecked.status;
	}
	/**
	 * @author Casey Kolodziejczyk
	 * @param canceled (Order to be canceled)
	 * Changes the status of an order to "canceled"
	 */
	public void cancelOrder(Order canceled) {
		canceled.updateStatus("Canceled");
		allOrders.remove(canceled);
	}
	
	/**
	 * @author Casey Kolodziejczyk
	 * @return Current status of OrderControl
	 * Might not be needed 
	 */
	public String getSystemStatus() {
		return status;
	}
	/**
	 * @author Casey Kolodziejczyk
	 * @param update (status of OrderControl)
	 * Changes the value of status
	 * Might not be needed
	 */ 
	public void updateSystemStatus(String update){
		status = update;
	}
	
	/**
	 * @author Casey Kolodziejczyk
	 * Currently solves all orders within the Hashmap
	 * Used for tesing purposes
	 */
	public void completeNextOrder(){
		Order currentOrder = allOrders.entrySet().iterator().next().getValue();
		while (currentOrder.orderFulfilled() != true) {
			for (int i = 0; i < currentOrder.order.size(); i++) {
				currentOrder.addItem(currentOrder.getItemNeeded(currentOrder.order.get(i)));
			}
		}
		
	}
}
