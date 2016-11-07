import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class ItemListTest {
	
	@Test
	public void addItemTest() {
		ItemList items = new ItemList();
		Item i = new Item("Hat", 234, 5);
		items.addItem(i);
		assertEquals(i,items.getItemAtIndex(0));
	}
	
	@Test
	public void itemNameNumberInStockTest() {
		ItemList items = new ItemList();
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
		ItemList items = new ItemList();
		Item i = new Item("Hat", 234, 5);
		Item j = new Item("Dog", 42, 2);
		Item h = new Item("Hat", 234, 5);
		items.addItem(i);
		items.addItem(j);
		items.addItem(h);
		assertEquals(2,items.numberInStock(234));
	}

}
