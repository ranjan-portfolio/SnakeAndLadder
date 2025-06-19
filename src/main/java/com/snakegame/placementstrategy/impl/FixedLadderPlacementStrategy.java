package com.snakegame.placementstrategy.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

import com.snakegame.placementstrategy.ILadderPlacementStrategy;



public class FixedLadderPlacementStrategy implements ILadderPlacementStrategy {
    private static final Logger logger=Logger.getLogger(FixedLadderPlacementStrategy.class.getName());

    @Override
    public ConcurrentMap<Integer, Integer> getLadderPositions() {
        //logger.info("getting ladder positions");
        return new ConcurrentHashMap<>(Map.of(2,38,7,14,8,31,15,26,21,42,28,84,36,44,51,67,71,91,78,98));
    }

}
