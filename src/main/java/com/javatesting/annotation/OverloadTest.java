package com.javatesting.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Retention(value = RetentionPolicy.RUNTIME)
@interface FirstAnno {
	String value() default "default";
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface SecondAnno {
	String someString();

	int someInt();
}

@Retention(value = RetentionPolicy.CLASS)
@interface ThirdAnno {
}
/* this annotation will not show up at runtime */

@FirstAnno
@ThirdAnno
public class OverloadTest {
	@FirstAnno("not the default")
	public String whatever;

	@FirstAnno("yadda yadda")
	@SecondAnno(someString = "yadda yadda", someInt = 42)
	public void someMethod() {
	}

	public static void main(String argv[]) throws Exception {
		OverloadTest at = new OverloadTest();
		Class atClass = at.getClass();

		Annotation[] annotations = atClass.getAnnotations();
		for (Annotation anno : annotations)
			System.out.println("class : " + ((FirstAnno) anno).value());

		Field fld = atClass.getField("whatever");
		annotations = fld.getAnnotations();
		for (Annotation anno : annotations)
			System.out.println("method : " + ((FirstAnno) anno).value());

		Method mth = atClass.getMethod("someMethod");
		annotations = mth.getAnnotations();
		for (Annotation anno : annotations) {
			if (anno instanceof FirstAnno)
				System.out.println("field : " + ((FirstAnno) anno).value());
			else
				System.out
						.println("field : " + ((SecondAnno) anno).someString() + "---" + ((SecondAnno) anno).someInt());
		}
	}
}