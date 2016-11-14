package warehouse;

public class Item {
	
	String itemName;
	int serialNumber;
	int shelfNumber;

	public Item(String itemName, int serialNumber, int shelfNumber) {
		this.itemName = itemName;
		this.serialNumber = serialNumber;
		this.shelfNumber = shelfNumber;
	}
	
	/**
	 * Gets the item name
	 * @author Grant Gertsen
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Gets the item serial number
	 * @author Grant Gertsen
	 * @return the serial number
	 */
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public int getShelfNumber() {
		return shelfNumber;
	}
	
	/**
	 * In case it's needed, updates the items shelf number.
	 * @param newShelfNumber the new shelf number.
	 */
	public void changeShelf(int newShelfNumber) {
		shelfNumber = newShelfNumber;
	}
}