import java.util.ArrayList;

public class Belt {
	
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

	public void pauseBelt() {
		// pause belt
	}
	
	public void resumeBelt() {
		//resume
	}
	
	public ArrayList<Bin> getCurrentBins() {
		return currentBins;
	}
	
	public void addBin(Bin binId) {
		//add bin
	}
	
	public void remove(Bin binId) {
		//remove bin
	}

}
