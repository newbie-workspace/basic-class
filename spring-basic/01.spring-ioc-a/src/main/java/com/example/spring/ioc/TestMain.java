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
		
		consumer = appContext.getBean("serviceConsumer", ServiceConsumer.class);
		consumer.doSomething(); //기본 설정 scope="singleton" -> 같은 data
		
		System.out.println("-------------------------");
		
		ServiceConsumer consumer2 = appContext.getBean("serviceConsumer2", ServiceConsumer.class);
		consumer2.doSomething();
		
		consumer2 = appContext.getBean("serviceConsumer2", ServiceConsumer.class);
		consumer2.doSomething(); //xml 설정 scope="singleton" -> 같은 data
		
		System.out.println("-------------------------");
		
		ServiceConsumer consumer3 = appContext.getBean("serviceConsumer3", ServiceConsumer.class);
		consumer3.doSomething();
		
		consumer3 = appContext.getBean("serviceConsumer3", ServiceConsumer.class);
		consumer3.doSomething(); //xml 설정 scope="prototype"
	}
}
