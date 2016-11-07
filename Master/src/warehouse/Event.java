/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;


public  class Event{
		
		private int count;
		private Task caller;
		private Object argument;
		
		public Event(int t, Object arg, Task who) {
			count = t;
			argument = arg;
			caller = who;
		}
		
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
