/**
 * 
 */
package com.javatesting.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javatesting.simple.ModelClass;

/**
 * @author vijpande
 *
 */
@Component
public class DemoManagerImpl1 implements DemoManager {

	@Autowired(required=false)
	ProductService productService;
	
	@Override
	public String getServiceName() {
	//productService.createProduct(new ModelClass(1, "Vijay", 30));
		return "My first service with Spring 3 using DemoManagerImpl1";
	}

}
