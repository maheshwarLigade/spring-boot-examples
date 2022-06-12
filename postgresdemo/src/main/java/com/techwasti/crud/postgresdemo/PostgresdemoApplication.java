package com.techwasti.crud.postgresdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgresdemoApplication {

	private static final Logger log = LoggerFactory.getLogger(PostgresdemoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(PostgresdemoApplication.class, args);
	}



}
