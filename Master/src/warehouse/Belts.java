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