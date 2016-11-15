package warehouse;


public class Bin {
	
	/**
	 * Borrowed from Prof. Herman -- May chanage implementation as needed.
	 * More of a placeholder for the moment.
	 */
	  Order order;  // ready to go on the Belt
	  boolean finished;  // initially false, becomes true when ready to go
	  public Bin() {
		  order = null;
		  finished = false;
	  }
	  
	  public boolean isFinished() { return finished; }
	  
	  public void setFinished() { finished = true; }
	  
	  public Order getOrder() { return order; }
	  
	  public void setOrder(Order o) { order = o; }
	  
	}
