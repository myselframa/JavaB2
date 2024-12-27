package com.forgemycode;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.forgemycode.beans.Vehicle;

public class Example8 {

    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("beans.xml");

        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + vehicle.getName());

    }
}
