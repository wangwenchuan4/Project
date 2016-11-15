package warehouse;

import java.util.*;

public class Shelf {

	static final int maxItems = 5;
	
	Point homeLocation;
	Point currentLocation; // professor used "resting" as a boolean, that may be better?
	List<Item> shelfStock;
	
	/**
	 * Initialize shelf at a given point.
	 * @author Grant Gertsen
	 * @param home
	 */
	public Shelf(Point home){
		homeLocation = home;
		currentLocation = home;
		shelfStock = new ArrayList<Item>(maxItems);
	}
	
	// Waiting on the rest until can talk to Robot
	
	
}
