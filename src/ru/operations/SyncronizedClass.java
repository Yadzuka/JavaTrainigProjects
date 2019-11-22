package ru.operations;

class NewThreads implements Runnable{
	String name;
	Thread t;
	boolean suspendFlag;
	
	NewThreads(String threadName){
		name = threadName;
		t = new Thread(this,name);
		suspendFlag = false;
		t.start();
	}	
	public void run() {
		try {
			for(int i = 15; i > 0; i--) {
				System.out.println(name + " : " + i);
				Thread.sleep(500);
				synchronized (this) {
					while(suspendFlag) {
						wait();
					}
				}
			}
		}catch(InterruptedException ex) {
			System.out.println(name + " :  прерван" );
		}
		System.out.println(name + " завершён");
	}
	
	synchronized void mySuspend() {
		suspendFlag = true;
	}
	
	synchronized void myResume() {
		suspendFlag = false;
		notify();
	}
}
class SyncronizedClass {
	public static void main(String [] args) {
		NewThreads th1 = new NewThreads("First");
		NewThreads th2 = new NewThreads("Second");
		
		try {
			
			th1.mySuspend();
			System.out.println("First thread stop");
			Thread.sleep(4000);
			th1.myResume();
			System.out.println("First thread resuming");
			th2.mySuspend();
			System.out.println("Second thread stop");
			Thread.sleep(4000);
			th2.myResume();
			System.out.println("Second thread resuming");	
		}catch(InterruptedException ex) {
			System.out.println("Main thread interrupted");
		}
		try {
			System.out.println("Oжидaниe завершения потоков.") ;
			th1.t.join();
			th2.t.join();
		}catch (InterruptedException е ) {
			System.out.println(" Глaвный поток прерван" ) ;
		}
		System.out.println("Глaвный поток завершен") ;
		
	}
}
