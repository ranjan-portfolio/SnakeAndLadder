package com.snakegame.entity;

import java.util.Map;

import com.snakegame.placementstrategy.ISnakePlacementStrategy;



public class Snake {

    private ISnakePlacementStrategy snakePlacementStrategy;

    public Snake(ISnakePlacementStrategy placementStrategy){
        this.snakePlacementStrategy=placementStrategy;
    }

    public Map<Integer,Integer> getSnakePositions(){
        return snakePlacementStrategy.getSnakePositions();
    }
    
}
