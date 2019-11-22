package ru.operations;

import java.util.*;

class Stack{
	private int [] massive;
	private int size;
	private int index;	
	Stack(int size){
		index = -1;
		this.size = size;
		massive = new int[size];
	}	
	void push(int number) {
		if(index == massive.length - 1) {
			int [] newMassive = new int[massive.length * 2];
			for(int i = 0; i <massive.length; i++) {
				newMassive[i] = massive[i];
			}
			massive = newMassive;			
		}	
		massive[++index] = number;
		
		do_log("Element " + number + " entries by the " + index + " index.");
	}	
	void pop() {
		if(index >= 0) {
			do_log("Element " + massive[index--] + " by the " + (index+1) + " index");
		}
		else
			do_err("The massive is empty");
	}	
	private void do_log(String msg) {
		System.out.println(msg);
	}
	private void do_err(String msg) {
		System.err.println(msg);
	}
}

/*
class A{

	synchronized void foo(B b) {
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " entires in method A.foo()" );
		
		/*try {
			Thread.sleep(1000);
		}catch(InterruptedException ex) {
			System.out.println();
		}
		System.out.println(name + " tries to invoke B.last() method");
		b.last();
	}
	synchronized void last() {
		System.out.println("B in method A.last()");
	}
}

class B{
	synchronized void bar(A a) {
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " entires in method B.bar()" );
		
		/*try {
			Thread.sleep(1000);
		}catch(InterruptedException ex) {
			System.out.println();
		}
		System.out.println(name + " tries to invoke A.last() method");
		a.last();
	}
	synchronized void last() {
		System.out.println("A in method B.last()");
	}
}
*/
class Deadlock {
	/*A a = new A();
	B b = new B();
	
	Deadlock(){
		Thread.currentThread().setName("Main thread");
		Thread t = new Thread(this,"Secondary thread");
		t.start();
		
		a.foo(b);
		
		System.out.println("Get back to the main thread");
	}
	public void run() {
		b.bar(a);
		
		System.out.println("Get back to the main thread");
	}
	*/
	
	public static void main(String[] args) {
		
		Stack stack = new Stack(5);
		
		for(int i = 0; i < 12; i++) {
			stack.push(i);
		}
		
		for(int i = 0; i < 12; i++) {
			stack.pop();
		}
		
		new Deadlock();

	}

}
