/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;





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
