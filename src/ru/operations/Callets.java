package ru.operations;

import java.util.*;
import java.io.*;

public class Callets {

	public static void main(String[] args) {
		Call callMe = new Call();
		Call callme2 = new Call();
		
		Threattd thr1 = new Threattd("This",callMe);
		Threattd thr2 = new Threattd("is",callMe);
		Threattd thr3 = new Threattd("mail",callMe);
		
		try {
			thr1.thread.join();
			thr2.thread.join();
			thr3.thread.join();
		}catch(InterruptedException e) {
			System.out.println("Threat was corrupted");
		}
		
		System.out.println("Main thread ends");
		
	}

}

class Call{
	
	synchronized public void getCall(String msg) {
		
		System.out.print("["+msg);
		/*try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			System.out.println("Catched!");
		}*/
		System.out.println("]");
	}
}
class Threattd implements Runnable{
	String msg;
	Thread thread;
	Call caller;
	
	Threattd(String msg,Call target){
		int i=0;
		thread = new Thread(this);
		this.msg = msg;
		caller = target;
		thread.start();
	}
	public void run() {
		caller.getCall(msg);
	}
}
