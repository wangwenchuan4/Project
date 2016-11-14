
package warehouse;

import java.util.*;
/**
 *  @author wenchuan wang
 * master class is the main program to run the simulation  
 */

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
    /**
     * @author wenchuan wang
     * EventComparator compares the events by its time in the priority queue
     * 
     */
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
    /**
     * @author wenchuan wang
     * @param limit 
     * it runs the simulation in given time and remove events that happened from the queue
     */
	
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
/**
 * @author wenchuan wang
 * master constructors create an instance of all component and the priority queue to store the events
 * 
 */
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
        
        /**
         * @author wenchuan wang
         * it creates the initial events for all the project and put them into
         * into a queue
         */

	 //initializing the queue with some initial events
	public void createEvents(){
		rob.enqueue("Initial robot event: ");
		flo.enqueue("Initial floor event: ");
		bel.enqueue("Initial belts event: ");
		inv.enqueue("Initial inventory event: ");
		ord.enqueue("Initial orders event: ");
		vis.enqueue("Initial visualizer event: ");
	}
	/**
         * @author wenchuan wang
         * tick value of its component 
         */
	public void tickCount(){
		rob.tick(count);
		flo.tick(count);
		bel.tick(count);
		inv.tick(count);
		ord.tick(count);
		vis.tick(count);
	}
        /**
         * @author wenchuan wang
         * @return the current tick time
         */
	//count the time
	public int getCount(){
		return count;
	}
        /**
         * @author wenchuan wang
         * this function increase the time by 1
         * 
         */
	//increase the time
	public void increaseCount(){
		count++;
	}
        
        /**
         * @author wenchuan wang
         * @return event e
		 * return event e that is going to implement its functionality
         */
	//the head of this queue, or null if this queue is empty but does not remove
	public Event peek(){
		return eventQueue.peek();
	}
        
	/**
         * @author wenchuan wang
         * @param e
         * Once fire(arg) is running, it can invoke Master.enqueue(newEvent) to add another (future) event to the Master's queue
         */
	
	public void enqueue(Event e){
		eventQueue.add(e);
	}
	
	/**
         * @author wenchuan wang
         * @return event at the top of the queue
         */
	public Event dequeue(){
		return eventQueue.poll();
		//Retrieves and removes the head of this queue, or returns null if this queue is empty.
	}
	
	/**
	 * @author wenchuan wang
	 * 
	 * This is the event class used by components to create events that will
	 * do something in the future.
	 */
	
	public  class Event{
		
		private int count;
		private Task caller;
		private Object argument;
		
		/**
		 * @author wenchuan wang
		 * @param t, arg, who
		 * int t (time), Object arg (argument passed by component), Task who
		 * (the component that created the event)
		 * constructor of the event class
		 */
		public Event(int t, Object arg, Task who) {
			count = t;
			argument = arg;
			caller = who;
		}
		/**
		 * @author wenchuan wang
		 * 
		 * @return int time (time the event happened)
		 * 
		 * it returns when the event happened
		 */
		public int getTime(){
			return count;
		}
		
		
		public Object getArgument(){
			return argument;
		}
		
		public Task getwhoCalled(){
			return caller;
		}
	}
	
	
	/**
	 *
	 * @author wenchwang
	 * mock components
	 */
	//assume belts event takes 1 tick
	class Belts implements Tickable,Task{
			
			Master master;
			int currentTime;
			
			public Belts(Master m){
				master = m;
			}
			
			public void tick(int count){
				currentTime = count;
				
			}
			
			public void fire(Object arg){
				System.out.print(arg);
				System.out.println(currentTime);
				enqueue("Belt event happened at: ");
			}
			
			public void enqueue(Object arg){
				Event e = new Event(currentTime+1,arg,this);
				master.enqueue(e);
			}
			
			
		}
public class Floor implements Tickable,Task{
		
		Master master;
		int currentTime;
		
		public Floor(Master m){
			master = m;
		}
		
		public void tick(int count){
			currentTime = count;
			
		}
		
		public void fire(Object arg){
			System.out.print(arg);
			System.out.println(currentTime);
			enqueue("Floor event happened at: ");
		}
		
		public void enqueue(Object arg){
			Event e = new Event(currentTime+4,arg,this);
			master.enqueue(e);
		}
		
		
	}
public class Inventory implements Tickable,Task{
	
	Master master;
	int currentTime;

	public Inventory(Master m){
		master = m;
	}
	
	public void tick(int count){
		currentTime = count;
		
	}
	
	public void fire(Object arg){
		System.out.print(arg);
		System.out.println(currentTime);
		enqueue("Inventory event happened at: ");
	}
	
	public void enqueue(Object arg){
		Event e = new Event(currentTime+6,arg,this);
		master.enqueue(e);
		
	}
	
	
}
public class Order implements Tickable,Task{
	
	Master master;
	int currentTime;

	public Order(Master m){
		master = m;
	}
	
	public void tick(int count){
		currentTime = count;
		
	}
	
	public void fire(Object arg){
		System.out.print(arg);
		System.out.println(currentTime);
		
		enqueue("Orders event happened at: ");
	}
	
	public void enqueue(Object arg){
		Event e = new Event(currentTime+5,arg,this);
		master.enqueue(e);
	}
	
	
}
/**
*
* @author wenchwang
*/
//assume robot event takes 5 tick
public class Robot implements Tickable,Task {
   	Master master;
       int currentTime;
		
   public Robot(Master m){
			master = m;
		}
   
   
   public void tick(int count){
			currentTime = count;
			
		}
		
		
   public void fire(Object arg){
			System.out.print(arg);
			System.out.println(currentTime);
                        
			enqueue("Robot event happened at: ");
		}
               
   
   public void enqueue(Object arg){
			Event e = new Event(currentTime+5,arg,this);
			// add another (future) event to the Master's queue
                       master.enqueue(e);
		}
		

         
               
}
/**
*
* @author wenchwang
*/
//assume Visualizer event takes 3 tick
public class Visualizer implements Tickable,Task{
		
		Master master;
		int currentTime;

		public Visualizer(Master m){
			master = m;
		}
		
		public void tick(int count){
			currentTime = count;
			
		}
		
		public void fire(Object arg){
			System.out.print(arg);
			System.out.println(currentTime);
			enqueue("Visualizer event happened at: ");
		}
		
		public void enqueue(Object arg){
			Event e = new Event(currentTime+3,arg,this);
			master.enqueue(e);
		}
		
		
	}
	
}
