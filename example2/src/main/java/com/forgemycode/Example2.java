package com.forgemycode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.forgemycode.beans.Vehicle;
import com.forgemycode.config.ProjectConfig;

public class Example2 {

    public static void main(String[] args) {

       
        /*
        The var keyword was introduced in Java 10. Type inference is used in
        var keyword in which it detects automatically the datatype of a variable
        based on the surrounding context.
        * */
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){

        //Vehicle veh = context.getBean(Vehicle.class);
        var veh = context.getBean("vehicle1",Vehicle.class);
        Vehicle veh2=context.getBean("vehicle1",Vehicle.class);
        System.out.println(veh.hashCode());
        System.out.println(veh2.hashCode());
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

        }
    }
}
