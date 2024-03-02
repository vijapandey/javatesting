
package com.javatesting.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author vijpande
 *
 */
@Configuration
public class AppConfig {

	@Bean(name = "demoService1")
	@Primary
	public DemoManager helloWorld1() {
		return new DemoManagerImpl1();
	}
	
	@Bean(name = "demoService2")
	public DemoManager helloWorld2() {
		return new DemoManagerImpl2();
	}
}