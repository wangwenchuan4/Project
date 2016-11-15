package warehouse;

public class Item {
	
	String itemName;
	int serialNumber;
	Shelf shelf;

	/**
	 * Constructor, given a custom item name, number, and starting shelf
	 * @author Grant Gertsen
	 * @param itemName
	 * @param serialNumber
	 * @param shelf
	 */
	public Item(String itemName, int serialNumber, Shelf shelf) {
		this.itemName = itemName;
		this.serialNumber = serialNumber;
		this.shelf = shelf;
	}
	
	/**
	 * Constructor, given an item from the catalog and a starting shelf
	 * @author Grant Gertsen
	 * @param catItem
	 * @param shelf
	 */
	public Item(CatItem catItem, Shelf shelf) {
		this.itemName = catItem.description;
		this.serialNumber = catItem.id;
		this.shelf = shelf;
	}
	
	/**
	 * Constructor, given a custom item name and number, but not yet assigned a shelf.
	 * @author Grant Gertsen
	 * @param itemName
	 * @param serialNumber
	 */
	public Item(String itemName, int serialNumber) {
		this.itemName = itemName;
		this.serialNumber = serialNumber;
		this.shelf = null;
	}
	
	/**
	 * Constructor, given a catalog item, but not yet assigned a shelf.
	 * @author Grant Gertsen
	 * @param catItem
	 */
	public Item(CatItem catItem) {
		this.itemName = catItem.description;
		this.serialNumber = catItem.id;
		this.shelf = null;
	}
	
	/**
	 * Getter
	 * @author Grant Gertsen
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Getter
	 * @author Grant Gertsen
	 * @return the serial number
	 */
	public int getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * What shelf that item is on
	 * @author Grant Gertsen
	 * @return the shelf the item is on
	 */
	public Shelf getShelf() {
		return shelf;
	}
	
	/**
	 * Updates the items shelf number.
	 * @param newShelfNumber the new shelf number.
	 */
	public void changeShelf(Shelf newShelf) {
		shelf = newShelf;
	}
}