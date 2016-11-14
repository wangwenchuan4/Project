package warehouse;

import java.util.*;

/**
 * 
 * @author Ted Herman
 *
 */
public class MockFloor implements Floor {
  /**
   * A fake Floor component for testing purposes only
   */
  static final int warehousewidth = 160;
  static final int warehousedepth = 200;

  final Point picker = new Point(0,190);
  final Point packer = new Point(0,50);
  final Point shippingdock = new Point(0,0);
  final Point receivingdock = new Point(80,0);
  final Point charger = new Point(20,20);

  List<ShelfArea> shelfareas;
  Map<String,Cell> allpoints;
  SimRandom randogen;

  /**
   * Constructor of Mock Floor
   * @param rand is a SimRandom for predictable randomness
   */
  public MockFloor(SimRandom rand) {
    randogen = rand;
    shelfareas = new ArrayList<ShelfArea>();
    shelfareas.add(new ShelfArea(new Point(20,100),140, randogen));
    shelfareas.add(new ShelfArea(new Point(20,140),140, randogen));
    shelfareas.add(new ShelfArea(new Point(20,160),140, randogen));
    allpoints = new HashMap<String,Cell>();
    // make a map of all cells that the warehouse has, where
    // each cell is one "square" on the floor
    for (int i=0; i<warehousewidth; i++)
      for (int j=0; j<warehousedepth; j++) {
        Point P = new Point(i,j);  // (i,j) is the (x,y)
        // check if this point already has a cell in a shelf area
        // and if so, just use the existing cell
        Cell N = new Cell(i,j);  // will be the new cell
        for (ShelfArea s: shelfareas) {
          if (s.hasWithin(P)) {  
        	N = s.getCell(P);
        	assert N != null;
            }
          }
        allpoints.put(P.toString(),N);
        }
    }
  /**
   * @author Ted Herman
   * return Cell at specified place
   */
  public Cell getCell(Point P) {
	return allpoints.get(P.toString());  
    }
  public Cell getCell(int x, int y) {
	return getCell(new Point(x,y));
    }
  /**
   * @author Ted Herman
   * methods to return known locations in warehouse
   */ 
  public int getWarehouseWidth() { return warehousewidth; }
  public int getWarehouseDepth() { return warehousedepth; }
  public Point getPicker() { return picker; }
  public Point getPacker() { return packer; }
  public Point getShippingDock() { return shippingdock; }
  public Point getReceivingDock() { return receivingdock; }
  public Point getCharger() { return charger; }
  public List<Point> getBeltArea() {
	ArrayList<Point> beltarea = new ArrayList<Point>();
	for (int i=picker.y; i>=0; i--) {
	  beltarea.add(new Point(0,i));	
	  }
	return beltarea;
    }
  /**
   * A very stupid getPath(s,t) that just makes
   * and returns a list of only two Points, s and t
   */
  public List<Point> getPath(Point s,Point t) {
	LinkedList<Point> L = new LinkedList<Point>();
	L.addFirst(s); L.addLast(t);
	return L;
    }
  public int getNumShelfAreas() { 
	return shelfareas.size();
    }
  public ShelfArea getShelfArea(int which) {
	return shelfareas.get(which);
    }
  
  /**
   * @return some random Point within a randomly 
   * chosen shelfarea - might be useful for product
   * distribution on shelves, returning a shelf to
   * the shelfarea, etc.
   */
  public Point randomInShelfArea() {
    int s = randogen.nextInt(shelfareas.size());
    return (shelfareas.get(s)).randomPoint();
    }
}
