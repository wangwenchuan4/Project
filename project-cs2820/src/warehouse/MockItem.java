
public class MockItem {
	
	/**
	 * @author Casey Kolodziejczyk
	 *
	 * We're not using this Item. But I already have it written here for testing purposes
	 */
	
	String status;
	String name;
	int number;
	String iLocation;
	
/**
 * @author Casey Kolodziejczyk
 * @param num
 * @param iName
 * Creates an Item object, everything below it are simple methods to get variables or change variables 
 */
	public MockItem(int num, String iName) {
		name = iName;
		number = num;
	}
	
	public void updateStatus(String update) {
		status = update; 
	}
	
	public void updateLocation(String update) {
		iLocation = update;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return iLocation;
	}
	
	// for Testing
	 @Override
		public String toString() {
		      	return ("" + name + "");
		   }
}
