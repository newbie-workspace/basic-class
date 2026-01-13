package com.example.spring.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //app-context.xml을 코드 방식으로 구현할 때 적용.
@ComponentScan(basePackages = {"com.example.spring.ioc"})
public class MyBeanConfig {
	
}
