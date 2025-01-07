package com.fmg.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fmg.example1.entity.Product;
import com.fmg.example1.entity.ProductRepo;

@SpringBootApplication
public class Example5Application implements CommandLineRunner {

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Example5Application.class, args);
	}

	@Autowired
	private ProductRepo productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		/*1.*****************Save*******************/
		//1. Method
		productRepository.save(new Product("P1001", "Yoga Mat", 25.50));
        productRepository.save(new Product("P1002", "Dumbbell Set", 50.00));
       	productRepository.save(new Product("P1003", "Treadmill", 999.99));
        productRepository.save(new Product("P1004", "Resistance Band", 15.00));
        productRepository.save(new Product("P1005", "Exercise Ball", 30.00));


		
		productRepository.findByProdIdOrProdCost(2,22.5).forEach(System.out::println);
		}


}
