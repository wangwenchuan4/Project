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
public  class Event{
		
		private int time;
		private Task whoCalled;
		private Object argument;
		
		public Event(int t, Object arg, Task who) {
			time = t;
			argument = arg;
			whoCalled = who;
		}
		
		public int getTime(){
			return time;
		}
		
		public Object getArgument(){
			return argument;
		}
		
		public Task getwhoCalled(){
			return whoCalled;
		}
	}
