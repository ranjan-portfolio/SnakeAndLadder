package com.snakegame.entity;


import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

import com.snakegame.placementstrategy.ISnakePlacementStrategy;



public class Snake {

    public ISnakePlacementStrategy snakePlacementStrategy;
    public ConcurrentMap<Integer,Integer> snakePositions;
    public static final Logger logger= Logger.getLogger(Snake.class.getSimpleName());

    public Snake(ISnakePlacementStrategy placementStrategy){
        this.snakePlacementStrategy=placementStrategy;
        snakePositions=snakePlacementStrategy.getSnakePositions();
    }

    public Integer updatePlayerPositionForSnakeBite(String color,int currentPosition){
        Integer snakeBites=snakePositions.get(currentPosition);
        if(snakeBites!=null){
            logger.info("Snake bite<<<<"+color+"::position demoted to::"+snakeBites.intValue()+"::from::"+currentPosition);
            return snakeBites;
        }
        return Integer.valueOf(currentPosition);
    }

    
}
