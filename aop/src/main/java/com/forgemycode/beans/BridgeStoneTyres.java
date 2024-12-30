package com.forgemycode.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BridgeStoneTyres implements Tyre{

    @Override
    public String rotate(){
        return "Vehicle moving with the help of Michelin tyres";
    }

    @Override
    public String stop() {
        return "Vehicle stopped with the help of Michelin tyres";
    }


}
