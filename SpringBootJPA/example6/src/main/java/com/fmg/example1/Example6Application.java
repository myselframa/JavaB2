package com.fmg.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fmg.example1.entity.Product;
import com.fmg.example1.entity.ProductRepo;

@SpringBootApplication
public class Example6Application implements CommandLineRunner {

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Example6Application.class, args);
	}

	@Autowired
	private ProductRepo productRepository;

	@Override
	public void run(String... args) throws Exception {
		
        // Add sample data using constructor without prodId
        productRepository.save(new Product("V1001", "Yoga Mat", 25.50));
        productRepository.save(new Product("V1002", "Dumbbell Set", 50.00));
        productRepository.save(new Product("V1003", "Treadmill", 999.99));
        productRepository.save(new Product("V1004", "Resistance Band", 15.00));
        productRepository.save(new Product("V1005", "Exercise Ball", 30.00));

        System.out.println("Sample product data loaded into the database.");
        
        productRepository.getAllProducts("V1001",25.0).forEach(System.out::println);;;
		}


}
