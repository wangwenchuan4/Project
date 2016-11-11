import java.util.*;

public class ItemList {

	ArrayList<Item> itemList;
	
	public ItemList() {
		itemList = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		itemList.add(item);
	}
	
	public int numberInStock(String itemName) {
		int stock = 0;
		for(Item item : itemList) {
			if(item.getItemName().equals(itemName)) {
				stock++;
			}
		}
		return stock;
	}
	
	public int numberInStock(int serialNumber) {
		int stock = 0;
		for(Item item : itemList) {
			System.out.println("Serial number is " + item.getItemName());
			if(item.getSerialNumber() == serialNumber) {
				stock++;
			}
		}
		return stock;
	}
	
	public Item getItemAtIndex(int index) {
		Item item = itemList.get(index);
		return item;
	}
	
}
