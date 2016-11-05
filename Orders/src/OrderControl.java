import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderControl {
	HashMap<Integer, Order> allOrders;   // order # , List of Items  
	String status;
	
	
	// This Simple creates my test case of two orders currently
	public OrderControl(){
		allOrders = new HashMap<Integer, Order>();
		
		Item testItem1 = new Item("Baseball", "Row 1 Second Shelf");
		Item testItem2 = new Item("Glove", "Row 1 Bottom Shelf");
		Item testItem3 = new Item("Bat", "Row 1 Top Shelf");
		
		Item testItem4 = new Item("Hockey Stick", "Row 2 Bottom Shelf");
		Item testItem5 = new Item("Puck", "Row 2 Top Shelf");
		
		List<Item> testItems1 = new ArrayList<Item>();
		
		testItems1.add(testItem1);
		testItems1.add(testItem2);
		testItems1.add(testItem3);
		
		List<Item> testItems2 = new ArrayList<Item>();
		
		testItems2.add(testItem4);
		testItems2.add(testItem5);
		
		Order TestOrder1 = new Order(testItems1, "Jimbo", 1);
				
		Order TestOrder2 = new Order(testItems2, "Ted", 2);
		
		allOrders.put(TestOrder1.orderNumber, TestOrder1);
		allOrders.put(TestOrder2.orderNumber, TestOrder2);
		
	}
	
	public void addOrder(int orderNum, Order newest) {
		allOrders.put(orderNum, newest);
	}
	
	public void removeOrder(int ordernum) {
		allOrders.remove(ordernum);
	}

	public void updateOrder(Order updated, String statusUpdate) {
		updated.status = statusUpdate;
	}
	
	public String orderStatus(Order orderChecked) {
		return orderChecked.status;
	}
	
	public void cancelOrder(Order canceled) {
		canceled.updateStatus("Canceled");
		allOrders.remove(canceled);
	}
	
	public String getSystemStatus() {
		return status;
	}
	
	public void updateSystemStatus(String update){
		status = update;
	}
	
	// Currently solves the next order in the HashMap. This is for testing purposes 
	public void completeNextOrder(){
		Order currentOrder = allOrders.entrySet().iterator().next().getValue();
		while (currentOrder.orderFulfilled() != true) {
			for (int i = 0; i < currentOrder.order.size(); i++) {
				currentOrder.getItemNeeded(currentOrder.order.get(i));
			}
		}
		
	}
}
