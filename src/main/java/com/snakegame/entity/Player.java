package com.snakegame.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    
    private String color;
    private AtomicInteger currentPosition=new AtomicInteger();

    public Player(String color){
        this.color=color;
        currentPosition.set(0);
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCurrentPosition() {
        return currentPosition.get();
    }

    public void setCurrentPosition(int pos) {
        currentPosition.set(pos);
    }

    
}
