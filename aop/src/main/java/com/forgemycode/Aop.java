package com.forgemycode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.forgemycode.beans.Song;
import com.forgemycode.config.ProjectConfig;
import com.forgemycode.service.VehicleService;

public class Aop {

    public static void main(String[] args) {

       
        /*
        The var keyword was introduced in Java 10. Type inference is used in
        var keyword in which it detects automatically the datatype of a variable
        based on the surrounding context.
        * */
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){

        //Vehicle veh = context.getBean(Vehicle.class);
           
            var vehicleServices = context.getBean(VehicleService.class);
            System.out.println(vehicleServices.getClass());
            Song song = new Song();
            song.setTitle("Blank Space");
            song.setSingerName("Taylor Swift");
            boolean vehicleStarted = true;
            String moveVehicleStatus = vehicleServices.moveVehicle(vehicleStarted);
            //System.out.println(moveVehicleStatus);
            String playMusicStatus = vehicleServices.playMusic(vehicleStarted,song);
           // System.out.println(playMusicStatus);
            String applyBrakeStatus = vehicleServices.applyBrake(vehicleStarted);
            //System.out.println(applyBrakeStatus);

        }
    }
}
