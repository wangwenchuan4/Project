package warehouse;

/**
 * 
 * @author tedherman
 * 
 * The Floor object has methods so that
 * Visualizer can "learn" about how the 
 * floor is organized without having to 
 * code all the locations in two places,
 * Floor and Visualizer. If the methods 
 * currently provided in this interface
 * are insufficient, then by all means 
 * add more methods or change these.
 * 
 * NOTE: the (x,y) coordinates, as put
 * into Point objects, have the same 
 * "reverse" way of treating y that Java
 * Swing and browsers also do: y=0 at the 
 * top of a window (top of the floor layout)
 * and gets larger as we go further down
 * in the floor map. This is opposite to 
 * normal math, but conventional in GUI 
 * thinking about frames, canvases, windows.
 *
 */

import java.util.*;

public interface Floor {
  // methods used mainly by Visualizer 
  // there should be more methods, so Visualizer can
  // learn where are Belt and ShelfAreas
  int getWarehouseWidth();
  int getWarehouseDepth();
  Point getPicker(); 
  Point getPacker(); 
  Point getShippingDock(); 
  Point getReceivingDock(); 
  Point getCharger();
  List<Point> getBeltArea();
  List<Point> getPath(Point start,Point end);
  Cell getCell(int x, int y);
  Cell getCell(Point P);
  int getNumShelfAreas();
  ShelfArea getShelfArea(int which);
  // method used by Inventory to stock items on shelves
  Point randomInShelfArea(); 
  }


