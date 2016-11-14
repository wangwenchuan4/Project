package warehouse;

/**
 * 
 * @author Ted Herman
 * Cell is an extension (subclass) of Point which also has 
 * possible content (a Robot or Shelf). Floor should be "in charge"
 * of having all the Cell objects, and Robot, Orders, Inventory, 
 * maybe even Belt should update Cell objects using methods of Floor
 *
 */
public class Cell extends Point {
  private Object contents;  // Robot or Shelf
//  private Robot  shadow;    // could be Robot at same place as Shelf
  Cell(int x, int y) {
	super(x,y); contents = null; //shadow = null;
	}
  Object getContents() {
	return contents;
    }
/*  Robot getShadow() {
	return shadow;
    }
  void setShadow(Robot R) {
	shadow = R;
    }*/
  void setContents(Object O) {
	contents = O;  
    }
  /**
   * Display Cell as a string
   */
  public String toString() {
    String result = super.toString();
//    if (contents instanceof Robot) result += " contains Robot";
    if (contents instanceof Shelf) result += " contains Shelf";
    return result;
    }
  /**
   * Provide a clone() method for Visualizer; this code has a 
   * BUG - the clone is not a deep copy (to make it a deep copy,
   * things like Robot, Shelf, etc, would all need to implement
   * clone as well).
   */
  public Object clone() {
	Cell n = new Cell(this.x,this.y);
	n.contents = this.contents;
//	n.shadow = this.shadow;
	return n;
    }
  }
