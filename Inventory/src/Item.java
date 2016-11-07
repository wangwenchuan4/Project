
public class Item {
	
	String itemName;
	int serialNumber;
	int numberInStock;

	public Item(String itemName, int serialNumber, int numberInStock) {
		this.itemName = itemName;
		this.serialNumber = serialNumber;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public int getNumberInStock() {
		return numberInStock;
	}
	
	public void stockItem(int quantity) {
		numberInStock += quantity;
	}
	
	public void removeItem(int quantity) {
		numberInStock -= quantity;
	}
}
