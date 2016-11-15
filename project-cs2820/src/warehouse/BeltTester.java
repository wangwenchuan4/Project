package warehouse;

import static org.junit.Assert.*;
import org.junit.Test;


public class BeltTester {
	
	/* Class for testing functionality of Belt and Bin classes 
	 * 
	 * */
	
	@Test
	public void testBeltCapacity() {
		Order order = null;
		Belt beltTester = new Belt("belt1", 2, 2);
		Bin bin = new Bin();
		bin.setOrder(order);
		beltTester.addBin(bin);
		assertEquals(1, beltTester.getNumberOfBins());
		
	}
	
	
	

	

}
