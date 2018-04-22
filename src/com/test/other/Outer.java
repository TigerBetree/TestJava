package com.test.other;

public class Outer {
	
	private String outerName = "outer";
	
	public class Inner {
		private String innerName = "inner";
		
		public void printName(){
			System.out.println(this.innerName);
			System.out.println("outer.name : " + outerName);
		}
	}
	
	public void printName(){
		System.out.println(this.outerName);
		
		Inner inner = new Inner();
		inner.printName();
	}
}
