package com.snakegame.placementstrategy.impl;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

import com.snakegame.placementstrategy.ISnakePlacementStrategy;



public class FixedSnakePlacementStrategy implements ISnakePlacementStrategy {
    private static final Logger logger=Logger.getLogger(FixedSnakePlacementStrategy.class.getName());
    @Override
    public ConcurrentMap<Integer, Integer> getSnakePositions() {
        //logger.info("Getting ladder positions");
       return new ConcurrentHashMap<>(Map.of(99,78,95,75,92,88,89,68,74,53,64,60,62,19,49,11,46,25,16,6));
    }
    
}