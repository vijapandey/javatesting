/**
 * 
 */
package com.javatesting.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author vijpande
 *
 */
public class CoreSpring {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AnnotationConfigApplicationContext contexts = new AnnotationConfigApplicationContext();
		contexts.scan("com.javatesting.spring");
		contexts.refresh();
		DemoManager obj = (DemoManager) context.getBean(DemoManager.class);
		//DemoManager obj = (DemoManager) context.getBean("demoService1");

		System.out.println(obj.getServiceName());	
		
		
		
		((AbstractApplicationContext) context).close();
		contexts.close();

	}

}
