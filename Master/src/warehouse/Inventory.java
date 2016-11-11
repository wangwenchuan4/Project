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
//assume Inventory event takes 6 tick
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
