package com.snakegame.entity;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    public int rollDice(){
        
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
    
}
