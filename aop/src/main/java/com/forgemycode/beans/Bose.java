package com.forgemycode.beans;

import org.springframework.stereotype.Component;

@Component
public class Bose implements Speaker{

	public String makeSound(Song song){
        return "Playing the song "+ song.getTitle()+ " by "
                + song.getSingerName()+
                " with Bose speakers";
    }

}
