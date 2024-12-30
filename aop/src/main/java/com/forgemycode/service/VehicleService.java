package com.forgemycode.service;



import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.forgemycode.beans.Song;
import com.forgemycode.beans.Speaker;
import com.forgemycode.beans.Tyre;

@Component
public class VehicleService {

    private Logger logger = Logger.getLogger(VehicleService.class.getName());

    @Autowired
    private Speaker speakers;
    @Autowired
    private Tyre tyres;

    
    public String playMusic(boolean vehicleStarted, Song song){
		/*
		 * Instant start = Instant.now(); logger.info("method execution start");
		 */
		/*
		 * String music = null; if(vehicleStarted){ music = speakers.makeSound(song);
		 * }else{ logger.log(Level.SEVERE,"Vehicle not started to perform the" +
		 * " operation"); }
		 */
		/*
		 * logger.info("method execution end"); Instant finish = Instant.now(); long
		 * timeElapsed = Duration.between(start, finish).toMillis();
		 * logger.info("Time took to execute the method : "+timeElapsed);
		 */
        return speakers.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted){
		/*
		 * Instant start = Instant.now(); logger.info("method execution start");
		 */
		/*
		 * String status = null; if(vehicleStarted){ status = tyres.rotate(); }else{
		 * logger.log(Level.SEVERE,"Vehicle not started to perform the" + " operation");
		 * }
		 */
		/*
		 * logger.info("method execution end"); Instant finish = Instant.now(); long
		 * timeElapsed = Duration.between(start, finish).toMillis();
		 * logger.info("Time took to execute the method : "+timeElapsed);
		 */
        return tyres.rotate();
    }

    public String applyBrake(boolean vehicleStarted){
		/*
		 * Instant start = Instant.now(); logger.info("method execution start");
		 */
		/*
		 * String status = null; if(vehicleStarted){ status = tyres.stop(); }else{
		 * logger.log(Level.SEVERE,"Vehicle not started to perform the" + " operation");
		 * }
		 */
		/*
		 * logger.info("method execution end"); Instant finish = Instant.now(); long
		 * timeElapsed = Duration.between(start, finish).toMillis();
		 * logger.info("Time took to execute the method : "+timeElapsed);
		 */
        return tyres.stop();
    }

    public Speaker getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speaker speakers) {
        this.speakers = speakers;
    }

    public Tyre getTyres() {
        return tyres;
    }

    public void setTyres(Tyre tyres) {
        this.tyres = tyres;
    }

	
}
