package com.example.spring.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //app-context.xml을 코드 방식으로 구현할 때 적용.
public class MyBeanConfig {

	@Bean //app-context.xml에서 <bean...>과 같은 역활. method 이름이 id.
	public ServiceConsumer serviceConsumer() {
		MyServiceConsumer bean = new MyServiceConsumer();
		bean.setMessageService(messageService()); // <bean ... ref="messageService">와 같은 효과
		bean.setTimeService(timeService());
		return bean;
	}
	
	@Bean
	public MessageService messageService() {
		MyMessageService bean = new MyMessageService();
		return bean;
	}
	
	@Bean
	public TimeService timeService() {
		MyTimeService bean = new MyTimeService();
		return bean;
	}
	
}
