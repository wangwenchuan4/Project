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
	
	public String getItemName() {
		return itemName;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public Shelf getShelf() {
		return shelf;
	}
	
	/**
	 * In case it's needed, updates the items shelf number.
	 * @param newShelfNumber the new shelf number.
	 */
	public void changeShelf(Shelf newShelf) {
		shelf = newShelf;
	}
}