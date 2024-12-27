package com.forgemycode;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.forgemycode.beans.Vehicle;
import com.forgemycode.config.ProjectConfig;

public class Example7 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;


        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

       
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("randomNumber = " + randomNumber);

        if((randomNumber% 2) == 0){
        	System.out.println("from volkswagen");
            context.registerBean("volkswagen",
                    Vehicle.class,volkswagenSupplier);
        }else{
        	System.out.println("from Audi");
            context.registerBean("audi",
                    Vehicle.class,audiSupplier);
        }
        
        Vehicle veh=context.getBean(Vehicle.class);
        System.out.println(veh.getName());
        
		

    }
}
