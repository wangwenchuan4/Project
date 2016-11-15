package warehouse;
import java.util.List;
/**
 *
 * @author Andrew Marburg
 *  changed my Robot class constructors to be based heavily on @author tedherman's example
 * most of it will not be testable since we don't have a floor/shelf/picker class yet
 */



public class Robot implements Tickable {
    
  public static final int idle = 0;
  public static final int pickershelfbound = 1;
  public static final int pickerbound = 2;
  public static final int atpicker = 3;
  public static final int afterpickershelfbound = 4;
  public static final int dockshelfbound = 5;
  public static final int dockbound = 6;
  public static final int atdock = 7;
  public static final int afterdockshelfbound = 8;
  public static final int chargerbound = 9;
  
        public List<Point> destination;
        public Point location;
        public Shelf holdingShelf;
        public Point shelfLocation;
        public int state;
        public Picker picker;
        public Dock dock;

		public Robot(Point startingLocation){
			destination = null;
			location = startingLocation;
			holdingShelf = null;
            state = idle;
            shelfLocation = null;
            picker = null;
            dock = null;
                        
                        
			
		}
		/**
                 * 
                 * @author Andrew Marburg
                 * method for getting the robot's current destination
                 */
		public List<Point> getDestination(){
			return destination;
			
		}
                /**
                 * 
                 * @author Andrew Marburg
                 * method for getting robot's current location
                 */
		public Point getLocation(){
			return location;
			
		}
                /**
                 * 
                 * @author Andrew Marburg
                 * method for finding out if the robot has a mission
                 */
		public int status(){
			return state;
				
		}
                /**
                 * 
                 * @author Andrew Marburg
                 * method to see which shelf the robot is currently holding
                 */
		public Shelf hasShelf(){
			return holdingShelf;
		}
                /**
                 * 
                 * @author Andrew Marburg 
                 * method to change the robot's current destination
                 */
		public void goTo(List<Point> newDest){
			destination = newDest;
            moveByOne();            
                        
			
		}
                /**
                 * @author Andrew Marburg
                 * method that will be used by the RobotSheduler every tick
                 * to move the Robot by one point
                 */
		public void moveByOne(){
                   if(destination != null){
                	   location = destination.get(0);
                	   destination.remove(0);
                	   
                   }
                    
                    
                    
                    
                }
		public void tick(int count){
			
		}
		
		
		
		
	}


