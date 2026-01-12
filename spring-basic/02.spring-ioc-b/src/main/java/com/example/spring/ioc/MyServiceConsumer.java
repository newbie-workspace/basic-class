package com.example.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component("serviceConsumer") // <bean id="serviceConsumer" ...></bean>과 같은 역활
public class MyServiceConsumer implements ServiceConsumer {
	
	
	private MessageService messageService;
	@Autowired // <property name="messageSerivce..." ]>
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@Setter
	private TimeService timeService;
//	public void setTimeService(TimeService timeService) {
//		this.timeService = timeService;
//	}

	public void doSomething() {
		String message = messageService.getMessage();
		System.out.println(message);
		message = timeService.getTimeString();
		System.out.println(message);
	}

}
