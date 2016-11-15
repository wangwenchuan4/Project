
package warehouse;

import java.util.ArrayList;
/**
 * TODO - Need Packer method.
 * @author Peter Nelson
 */


public class Belt implements Tickable {
	
	//double speed;
	double beltWidth;
	int beltCapacity;  //determined by belt length -- does floor determine this?
	ArrayList<Bin> currentBins = new ArrayList<Bin>();
	
	String beltID;
	
	
	public Belt(String beltID, int beltCapacity, double beltWidth) {
		this.beltID = beltID;
		this.beltCapacity = beltCapacity;
		this.beltWidth = beltWidth;
	}

	/**
	 * pauseBelt freezes the movement of the belt.  Ticker still ticks but belt is stationary.
	 */
	public void pauseBelt() {
		// pause belt
	}
	
	
	/**
	 * Resumes movement of Belt
	 */
	public void resumeBelt() {
		//resume
	}
	
	
	/**
	 * Returns an ArrayList of Bin objects currently on the Belt
	 * @return
	 */
	public ArrayList<Bin> getCurrentBins() {
		return currentBins;
	}
	
	public int getNumberOfBins() {
		return currentBins.size();
	}
	
	/**
	 * Adds bin to Belt - referenced by beltID
	 * @param binId
	 */
	public void addBin(Bin binId) {
		//add bin
		currentBins.add(binId);
	}
	/**
	 * Removes bin from Belt.
	 * @param binId
	 */
	//May need to replace with some Packer method
	public void remove(Bin binId) {
		//remove bin
	}

	@Override
	public void tick(int count) {
		// TODO Auto-generated method stub
		
	}

}
