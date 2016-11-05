import java.util.List;
// Probably need to make an independent object for each bin. Just haven't done it yet
public class Bin {
	//List<Item> bin = new ArrayList<Item>();	   // bin being filled (New object?)
	int binNumber;
	String binLocation;
	String size; 
	String status;
	
	public Bin(List<Item> items, String binSize) {
		status = "Incomplete";
		size = binSize;
	}
}
