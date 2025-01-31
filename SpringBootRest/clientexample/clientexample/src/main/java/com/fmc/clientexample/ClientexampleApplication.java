package com.fmc.clientexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientexampleApplication.class, args);
	}

}
