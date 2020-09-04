package com.jingang.springinterfacetest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class SpringInterfaceTestApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringInterfaceTestApplication.class, args);
	}

}

