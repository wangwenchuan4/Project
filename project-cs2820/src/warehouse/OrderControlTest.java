import static org.junit.Assert.*;

import org.junit.Test;

public class OrderControlTest {
	/**
	 * @author Casey Kolodziejczyk
	 *  Simple test to see if an Order can be fulfilled and the Status of the order changing
	 *
	 * 		This consists of adding items to a bin, and then checking to see if the bin has 
	 * 		the same items as the order.
	 *  	The print Statements are just to see what's going on.
	 * 
	 */
	@Test
	public void testCompleteNextOrder() {
		OrderControl controlTest = new OrderControl();
		
		Order nextOrder = controlTest.allOrders.entrySet().iterator().next().getValue();
		System.out.println(nextOrder.filled());
		System.out.println(nextOrder.toString());
		System.out.println(nextOrder.order.get(0));
		System.out.println(nextOrder.order.size());

		nextOrder.completeOrder();
		System.out.println("bin " + nextOrder.bin.toString());
		System.out.println(nextOrder.filled());
		assertTrue(nextOrder.orderFulfilled() && nextOrder.filled() == true);
		controlTest.removeOrder(nextOrder.orderNumber);
		
		System.out.println("\n Moving to Order two");
		nextOrder = controlTest.allOrders.entrySet().iterator().next().getValue();
		System.out.println(nextOrder.filled());
		nextOrder.completeOrder();
		System.out.println(nextOrder.toString());
		System.out.println(nextOrder.order.get(0));
		System.out.println(nextOrder.order.size());
		System.out.println(nextOrder.orderFulfilled());
		nextOrder.completeOrder();
		System.out.println("bin " + nextOrder.bin.toString());
		assertTrue(nextOrder.orderFulfilled() && nextOrder.filled() == true);
	}

}
