package com.forgemycode.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Sony implements Speaker{

    public String makeSound(Song song){
        return "Playing the song "+ song.getTitle()+ " by "
                + song.getSingerName()+
                " with Sony speakers";
    }


}
