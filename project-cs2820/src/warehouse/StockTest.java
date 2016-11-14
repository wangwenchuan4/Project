package warehouse;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class StockTest {
	
	@Test
	public void addItemTest() {
		Stock items = new Stock();
		Item i = new Item("Hat", 234, 5);
		items.addItem(i);
		assertEquals(i,items.getItemAtIndex(0));
	}
	
	@Test
	public void itemNameNumberInStockTest() {
		Stock items = new Stock();
		Item i = new Item("Hat", 234, 5);
		Item j = new Item("Dog", 42, 2);
		Item h = new Item("Hat", 234, 5);
		items.addItem(i);
		items.addItem(j);
		items.addItem(h);
		assertEquals(2,items.numberInStock("Hat"));
	}
	
	@Test
	public void serialNumberNumberInStockTest() {
		Stock items = new Stock();
		Item i = new Item("Hat", 234, 5);
		Item j = new Item("Dog", 42, 2);
		Item h = new Item("Hat", 234, 5);
		items.addItem(i);
		items.addItem(j);
		items.addItem(h);
		assertEquals(2,items.numberInStock(234));
	}

}