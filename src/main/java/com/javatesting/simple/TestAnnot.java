/**
 * 
 */
package com.javatesting.simple;

/**
 * @author vijpande
 *
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //can use in method only.
public @interface TestAnnot {

	//should ignore this test?
	public boolean enabled() default true;

}