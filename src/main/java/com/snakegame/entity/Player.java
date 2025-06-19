package com.snakegame.entity;

public class Player {
    
    private String color;
    private int currentPosition;

    public Player(String color){
        this.color=color;
        this.currentPosition=0;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    
}
