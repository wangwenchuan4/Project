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
//assume order event takes 5 tick
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
