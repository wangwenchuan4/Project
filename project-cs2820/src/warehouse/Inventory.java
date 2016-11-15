package warehouse;

import java.util.*;

/**
 * 
 * @author Grant Gertsen
 * To-Do : Change from ArrayList<Item> to HashTable<Item,count>
 */
public class Inventory {

	ArrayList<Item> stock;
	
	public Inventory() {
		stock = new ArrayList<Item>();
	}

	/**
	 * Add an item to the stock
	 * @author Grant Gertsen
	 * @param item
	 */
	public void addItem(Item item) {
		stock.add(item);
	}

	/**
	 * How many of an item is in stock
	 * @author Grant Gertsen
	 * @param itemName
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
	 * @param serialNumber
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
	 * @param itemNumber
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
}




/**
 * 
 * @author Ted Herman
 *
 *         A local class to be the catalog of available items that Inventory can
 *         use: CatItem.catalog is an array of CatItem objects, each with an id
 *         member (int) and description (String)
 *
 */
