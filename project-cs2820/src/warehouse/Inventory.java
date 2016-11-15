package warehouse;

import java.util.*;

/**
 * 
 * @author Grant Gertsen
 */
public class Inventory implements Tickable{

	ArrayList<Item> stock;
	
	/**
	 * Create a list with all stocked items in it.
	 * @author Grant Gertsen
	 */
	public Inventory() {
		stock = new ArrayList<Item>();
	}

	/**
	 * Add an item to the stock
	 * @author Grant Gertsen
	 * @param item the item to add
	 */
	public void addItem(Item item) {
		stock.add(item);
	}

	/**
	 * How many of an item is in stock
	 * @author Grant Gertsen
	 * @param itemName the item you want to check
	 * @return how many of an item is in stock
	 */
	public int numberInStock(String itemName) {
		int count = 0;
		for (Item item : stock) {
			if (item.getItemName().equals(itemName)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Polymorphism of above method
	 * @author Grant Gertsen
	 * @param serialNumber the number you want to check
	 * @return the number of items of a given serial number in stock
	 */
	public int numberInStock(int serialNumber) {
		int count = 0;
		for (Item item : stock) {
			//System.out.println("Serial number is " + item.getItemName());
			if (item.getSerialNumber() == serialNumber) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Test method
	 * @author Grant Gertsen
	 * @param index the index which your item is located
	 * @return the item requested
	 */
	public Item getItemAtIndex(int index) {
		Item item = stock.get(index);
		return item;
	}
	
	/**
	 * Finds a shelf that has a given item on it (to be called by Orders I believe)
	 * @author Grant Gertsen
	 * @param itemName the name of the item you're looking for.
	 * @return a shelf where the item is.
	 */
	public Shelf findItem(String itemName){
		for(Item item : stock) {
			if(item.getItemName().equals(itemName)) {
				return item.getShelf();
			}
		}
		return null; // item not found.
	}
	
	/**
	 * Finds what shelf a given item is on based off of its serial number.
	 * @author Grant Gertsen
	 * @param itemNumber the item number you're looking for
	 * @return a shelf with the given item on it.
	 */
	public Shelf findItem(int itemNumber){
		for(Item item : stock) {
			if(item.getSerialNumber() == itemNumber) {
				return item.getShelf();
			}
		}
		return null; // item not found.
	}

	@Override
	public void tick(int count) {
		// In progress
		
	}
}
