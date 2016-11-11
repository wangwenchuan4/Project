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