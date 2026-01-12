package com.example.spring.ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		//직접 객체 생성 (new 사용)
		//ServiceConsumer consumer = new MyServiceConsumer();
		//consumer.doSomething();
		
		//IoC 컨테이너 사용해서 객체 생성
		GenericXmlApplicationContext appContext = new GenericXmlApplicationContext("app-context.xml");
		ServiceConsumer consumer = appContext.getBean("serviceConsumer", ServiceConsumer.class);
		consumer.doSomething();
	}
}
