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
class Belts implements Tickable,Task{
		
		Master master;
		int currentTime;
		
		public Belts(Master m){
			master = m;
		}
		
		public void tick(int count){
			currentTime = count;
			//moveBelt(count);
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
		
		/*public void moveBelt(int count){
			System.out.println("Belt moved at time: " + count);
		}*/
	}