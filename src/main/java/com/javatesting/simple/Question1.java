package com.javatesting.simple;

class A {
	//A a = new A();
	

	static void staticMethod() {		System.out.println("Static Method");	}

	static int i = 1111;

	static {		i = i-- - --i;	}

	{		i = i++ + ++i;	}
}

class B extends A {

	
	static {		i = --i - i--;	}

	{		i = ++i + i++;	}
	
	int methodOfA()    {        return (true ? null : 0);    }
}

public class Question1 {

	public static void main(String[] args) {

		// 2
		/*
		 * A a = null; a.staticMethod();
		 */

		// 3
		/*
		 * B b = new B(); System.out.println(b.i);
		 */

		//4
		/*
		 * B b = new B(); b.methodOfA();
		 */
	
		//5
		/*
		 * Integer i1 = 127; Integer i2 = 127; System.out.println(i1 == i2); Integer i3
		 * = 158; Integer i4 = 158; System.out.println(i3 == i4);
		 */
		
        
		//6
		
		
		
		
		
		
		
	}

}
