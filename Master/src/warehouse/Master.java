
package warehouse;

import java.util.*;

public class Master {
    
    private PriorityQueue<Event> eventQueue;
	private int count;
	
	private Robot rob;
	private Floor flo;
	private Order ord;
	private Inventory inv;
    private Belts bel;
    private Visualizer vis;
    Comparator<Event> comparator;
    
    public class EventComparator implements Comparator<Event>{
	    
	    public int compare(Event e1, Event e2){
	    	if (e1.getTime() < e2.getTime()){
	    		return -1;
	    	}
	    	else if (e1.getTime() > e2.getTime()){
	    		return 1;
	    	}
	    	else {
	    	return 0;
	    	}
	    }
	}
    
	
	//loop to run the simulation	
public void Run(int limit) {
	  
    Master m = new Master( );
    
    m.tickCount();
    m.createEvents();
		
		while (true){
                    
			m.increaseCount();
			m.tickCount();
			//break leaves a loop.
			if (m.getCount() > limit){
				break;
			}
			// continue jumps to the next iteration.
			if (m.peek() == null){
				continue;
			}
			
			while (m.peek().getTime() == m.getCount()){
				Event e = m.dequeue();
				Task t = e.getwhoCalled();
                                
				t.fire(e.getArgument());
				
				if (m.peek() == null){
					break;
				}
			}
		}//end of while loop
    
}
	
	/*public Master(Visualizer visualizer,Floor floor,Belts belts,Inventory inventory,Order order, Robot robot){
		 //know about a Master object (perhaps as a parameter in their constructors). 
		comparator = new EventComparator();
		eventQueue = new PriorityQueue<Event>(100,comparator);
		count = 0;
		vis = visualizer;
		flo = floor;
		bel = belts;
		inv = inventory;
		ord = order;
		rob = robot;
	}*/

public Master(){
		
		
		count = 0;
        //all the other components probably need to know about a Master object
		//(perhaps as a parameter in their constructors).
		
		rob = new Robot(this);
		flo = new Floor(this);
		bel = new Belts(this);
		inv = new  Inventory(this);
		ord = new Order(this);
		vis = new Visualizer(this);
		comparator = new EventComparator();
		eventQueue = new PriorityQueue<Event>(50,comparator);
	}
        
        
        

	
	 //initializing the queue with some initial events
	public void createEvents(){
		rob.enqueue("Initial robot event: ");
		flo.enqueue("Initial floor event: ");
		bel.enqueue("Initial belts event: ");
		inv.enqueue("Initial inventory event: ");
		ord.enqueue("Initial orders event: ");
		vis.enqueue("Initial visualizer event: ");
	}
	
	public void tickCount(){
		rob.tick(count);
		flo.tick(count);
		bel.tick(count);
		inv.tick(count);
		ord.tick(count);
		vis.tick(count);
	}
	//count the time
	public int getCount(){
		return count;
	}
	//increase the time
	public void increaseCount(){
		count++;
	}
	//the head of this queue, or null if this queue is empty but does not remove
	public Event peek(){
		return eventQueue.peek();
	}
	// Once fire(arg) is running, it can invoke Master.enqueue(newEvent) to add another (future) event to the Master's queue
	public void enqueue(Event e){
		eventQueue.add(e);
	}
	
	public Event dequeue(){
		return eventQueue.poll();
		//Retrieves and removes the head of this queue, or returns null if this queue is empty.
	}
	
	
	
}
