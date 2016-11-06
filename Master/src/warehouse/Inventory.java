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
public class Inventory implements Tickable,Task{
		
		Master master;
		int currentTime;

		public Inventory(Master m){
			master = m;
		}
		
		public void tick(int count){
			currentTime = count;
			//InventoryAtTime(count);
		}
		
		public void fire(Object arg){
			System.out.print(arg);
			System.out.println(currentTime);
			enqueue("Inventory event happened at: ");
		}
		
		public void enqueue(Object arg){
			Event e = new Event(currentTime+8,arg,this);
			master.enqueue(e);
			
		}
		
		/*public void InventoryAtTime(int count){
			System.out.println("Inventory at time: " + count);
		}*/
	}
