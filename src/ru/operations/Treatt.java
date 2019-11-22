package ru.operations;

import java.util.*;
import java.io.*;

public class Treatt extends Thread implements Runnable {

	public static void main(String[] args) {
		NewThread first = new NewThread("First");
		NewThread second = new NewThread("Second");
		NewThread third = new NewThread("Third");

		System.out.println("First thread started: " + first.t.isAlive());
		System.out.println("First thread started: " + first.t.isAlive());
		System.out.println("First thread started: " + first.t.isAlive());

		try {
			System.out.println("Waiting for the ending of threads");

			first.t.join();
			second.t.join();
			third.t.join();

		} catch (InterruptedException e) {
			System.out.println("Основной поток прерван!");
		}

		System.out.println("First thread started: " + first.t.isAlive());
		System.out.println("First thread started: " + first.t.isAlive());
		System.out.println("First thread started: " + first.t.isAlive());

		System.out.println("Main thread ended!");
	}

}

class NewThread implements Runnable {
	Thread t;
	String threadName;

	NewThread(String threadName) {
		this.threadName = threadName;
		t = new Thread(this, threadName);
		System.out.println(threadName + " started!");
		t.start();
	}

	@Override
	public void run() {
		try {
			doIt();
			for (int i = 0; i < 5; i++) {
				System.out.println(t.getName() + " поток: " + i);
				Thread.sleep(500);
			}
			
		} catch (InterruptedException e) {
			System.out.println(t.getName() + " поток прерван!");
		}
		System.out.println(t.getName() + " поток завершён!");
	}

	public synchronized void doIt() {
		try {
			for (int i = 10; i > 0; i--) {
				System.out.println(t.getName()+" "+i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread was corrupted!");
		}

	}
}
