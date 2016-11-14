package warehouse;

/**
 * 
 * @author Ted Herman
 *
 */
public class Point {
  int x;
  int y;
  Point(int x, int y) {
	this.x = x; this.y = y;
	}
  /**
   * Display Point as a string
   */
  public String toString() {
    String result = "Point x=" + x + " y=" + y;
    return result;
    }
  /**
   * @return the point just "above" this point (= north)
   * or return null if there is no "above"
   * @author Ted Herman 
   */
  Point above() {
    int newx = x-1;
    if (newx < 0) return null;
    return new Point(newx,y);
    }
  /** 
   * @return the point just "below" this point (= South)
   * or return null if there is no "below"
   */
  Point below() {
    int newx = x + 1;
    if (newx >= MockFloor.warehousedepth) return null;
    return new Point(newx,y);
    }
  /** 
   * @return the point just "right" of this point (= East)
   * or return null if there is no "right"
   */
  Point right() {
    int newy = y + 1;
    if (newy >= MockFloor.warehousewidth) return null;
    return new Point(x,newy);
    }
  /** 
   * @return the point just "left" of this point (= West)
   * or return null if there is no "left"
   */
  Point left() {
    int newy = y - 1;
    if (newy < 0) return null;
    return new Point(x,newy);
    }
  /**
   * @return true if two points are the same place
   */
  boolean equals(Point other) {
    return (other.x==x && other.y==y);
    }
  }
