package ru.opredelClass;

public class OverLoad{
	int _integ;
	public void viParam(int ... v) {
		System.out.println("(int ... v) :"+v.length);
		
		for(int k : v) 
			System.out.print(k+" ");
				
		System.out.println();
	}
	public void viParam(boolean ... v) {
		System.out.println("(boolean ... v) :"+v.length);
		
		for(boolean k : v) 
			System.out.print(k+" ");
				
		System.out.println();
	}
	public void viParam(String ... v) {
		System.out.println("(int ... v) :"+v.length);
		
		for(String k : v) 
			System.out.print(k+" ");
				
		System.out.println();
	}
	public void viParam(String s,int ... v) {
		System.out.println("(int ... v) :"+v.length+"\n"+s);
		
		for(int k : v) 
			System.out.print(k+" ");
		
		System.out.println();
	}
	
}