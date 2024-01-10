package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.common.tcp.SocketServer;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =SpringApplication.run(DemoApplication.class, args);
		applicationContext.getBean(SocketServer.class).start(8533);
	}

}
