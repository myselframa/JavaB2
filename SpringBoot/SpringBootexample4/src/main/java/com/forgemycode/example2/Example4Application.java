package com.forgemycode.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Example4Application implements CommandLineRunner{

	@Autowired
	private Environment env;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(env.getProperty("my.prod.ID"));
		System.out.println(env.getProperty("my.prod.code"));
		System.out.println(env.getProperty("my.prod.Ty_pe"));
		System.out.println(env.getProperty("my.prod.MOD-E_L"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Example4Application.class, args);
	}

}
