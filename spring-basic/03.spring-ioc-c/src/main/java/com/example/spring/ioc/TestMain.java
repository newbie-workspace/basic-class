package com.example.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		
		ServiceConsumer consumer = appContext.getBean("serviceConsumer", ServiceConsumer.class);
		consumer.doSomething();
		
	}
}
