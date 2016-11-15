package warehouse;

/**
 * 
 * @author Ted Herman
 * 
 * This is the interface for making requests and
 * getting responses from Robots.  
 *
 */
public interface RobotScheduler {
  /**
   * @param s is a Shelf to bring to the picker location
   * @param p is a Picker interface to invoke when the shelf
   * has been delivered to the picker location
   */
  void requestShelfPicker(Shelf s, Picker p);
  /**
   * @param s is a Shelf to bring to the receiving dock
   * @param d is a Dock interface to invoke when the shelf 
   * has been delivered to the dock location
   */
  void requestShelfDock(Shelf s, Dock d);
  /**
   * the returnShelf() tells a Robot carrying a Shelf to 
   * put that Shelf back into a ShelfArea on the Floor
   */
  void returnShelf(Robot r);
  }