
public class Robot {
public int id;
public String destination;
public String location;
public boolean mission;
public String shelfId;

	public Robot(int name){
		this.id = name;
		this.destination = "none";
		this.location = "starting location";
		this.mission = false;
		this.shelfId = "none";
		
	}
	public int getid(){
		return id;
		
	}
	public String getDestination(){
		return destination;
		
	}
	public String getLocation(){
		return location;
		
	}
	public boolean onMission(){
		return mission;
			
	}
	public String hasShelf(){
		return shelfId;
	}
	public void changeDest(String newDest){
		destination = newDest;
		
	}
	public void changeLoc(String newLoc){
		location = newLoc;
		
	}
	public void newMissionStatus(boolean onMis){
		mission = onMis;
		if(mission == false && shelfId == "none"){ //
			changeDest("shelf origin");
			} //where the robot got the shelf.
		else if(mission == false){
			changeDest("Starting Location"); //the charging station
			}
	}
	
	
	
	
}
	



