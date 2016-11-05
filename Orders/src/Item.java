
public class Item implements Trackable {
	String status;
	String name;
	String iLocation;
	
	// Creates Item Object
	public Item(String iName, String Location) {
		name = iName;
		iLocation = Location;
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
