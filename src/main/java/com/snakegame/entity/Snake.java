package com.snakegame.entity;


import java.util.concurrent.ConcurrentMap;

import com.snakegame.placementstrategy.ISnakePlacementStrategy;



public class Snake {

    private ISnakePlacementStrategy snakePlacementStrategy;

    public Snake(ISnakePlacementStrategy placementStrategy){
        this.snakePlacementStrategy=placementStrategy;
    }

    public ConcurrentMap<Integer,Integer> getSnakePositions(){
        return snakePlacementStrategy.getSnakePositions();
    }
    
}
