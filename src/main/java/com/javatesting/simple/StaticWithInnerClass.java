/**
 * 
 */
package com.javatesting.simple;

/**
 * @author vijpande
 *
 */
public class StaticWithInnerClass {

	private static int outerStaticdata = 30;
	 private  int outerData = 10;

	 public StaticWithInnerClass() {
		 System.out.println("StaticWithInnerClass Constructer is calling !!!!");
	}
	 
	static class StaticInner {
		public static int innerStaticdata = 30;
		int innerStaticClassData = 30;

		public StaticInner() { System.out.println("StaticWithInnerClass Constructer is calling !!!!");}
		
		void msg() {
			System.out.println("#StaticInner is " + outerStaticdata +" " /* + outerData*/);
		}
	}

	class Inner {
		private int innerClassStaticdata = 30;
		int innerClassData = 30;

		void msg() {System.out.println("#Inner data is " + outerStaticdata +"  " +outerData);	}
	}

	public static void main(String[] args) {
		StaticWithInnerClass mainClassObject = new StaticWithInnerClass();

		StaticWithInnerClass.StaticInner obj = new StaticWithInnerClass.StaticInner();
		obj.msg();

		StaticWithInnerClass.Inner inner = mainClassObject.new Inner();
		inner.msg();

	}

}
