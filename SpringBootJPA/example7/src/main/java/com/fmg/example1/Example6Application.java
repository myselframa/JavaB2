package com.fmg.example1;



import java.util.List;

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
	
    @Autowired
    private ProductService productService;



	@Override
	public void run(String... args) throws Exception {
		
        // Add sample data using constructor without prodId
		// Insert sample data
        Product p1 = new Product();
        p1.setProdId(1);
        p1.setVendorCode("V1001");
        p1.setProdCost(150.0);
        productRepository.save(p1);

        Product p2 = new Product();
        p2.setProdId(2);
        p2.setVendorCode("V1002");
        p2.setProdCost(200.0);
        productRepository.save(p2);

        Product p3 = new Product();
        p3.setProdId(3);
        p3.setVendorCode("V1001");
        p3.setProdCost(300.0);
        productRepository.save(p3);

        // Fetch data using MyView projection
        System.out.println("Fetching VendorCode and ProdCost:");
        List<ProductRepo.MyView> myViewList = productService.getVendorCodeAndCost("V1001");
        myViewList.forEach(view -> 
            System.out.println("VendorCode: " + view.getVendorCode() + ", ProdCost: " + view.getProdCost())
        );

        // Fetch data using MyViewTwo projection
        System.out.println("\nFetching ProdId and ProdCost:");
        List<ProductRepo.MyViewTwo> myViewTwoList = productService.getProdIdAndCost("V1001");
        myViewTwoList.forEach(view -> 
            System.out.println("ProdId: " + view.getProdId() + ", ProdCost: " + view.getProdCost())
        );

		}


}
