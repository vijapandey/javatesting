/**
 * 
 */
package com.javatesting.spring;

import org.springframework.stereotype.Component;

/**
 * @author vijpande
 *
 */
@Component
public class DemoManagerImpl2 implements DemoManager {

	@Override
	public String getServiceName() {
		return "My first service with Spring 3 with DemoManagerImpl2";
	}

}
