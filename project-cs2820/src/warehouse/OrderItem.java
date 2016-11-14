//package warehouse;

/**
 * 
 * @author Ted Herman
 * This is just like Item, but we have extra members
 * to keep track of the progress of this in an order
 *
 */
public class OrderItem extends Item {
  boolean inBin = false;
  
  /**
   * @author Ted Herman
   * @param Num exactly as used in Item constructor
   * @param Title as in Item constructor
   * creates a subtype of Item with "in bin" boolean
   * to express whether or not this item has been put
   * in the bin at the picker station
   */
  public OrderItem(int Num, String Title) {
	super(Num,Title);
	inBin = false;
    }
  
  /**
   * @author Ted Herman
   * @param N as an Item type
   * Creates a subtype of Item with "in bin" boolean
   * to express whether or not this item has been put
   * in the bin at the picker station 
   */
  public OrderItem(Item N) {
	this(N.number,N.name);
    }
  
  /**
   * @author Ted Herman
   * Returns the value of inBin. Which is either true or false
   * depending if the OrderItem is in a bin
   */
  public boolean filled() { return inBin; }
  
  /**
   * @author Ted Herman
   * Sets the value of inBin to true
   */
  public void setFilled() { inBin = true; }
  

// for Testing
@Override
	public String toString() {
	      	return ("" + name + "");
	   }
}