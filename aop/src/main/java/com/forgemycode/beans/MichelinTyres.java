package com.forgemycode.beans;

import org.springframework.stereotype.Component;

@Component
public class MichelinTyres implements Tyre{

	@Override
    public String rotate(){
        return "Vehicle moving with the help of BridgeStone tyres";
    }

    @Override
    public String stop() {
        return "Vehicle stopped with the help of BridgeStone tyres";
    }

}
