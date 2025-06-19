package com.snakegame.placementstrategy;


import java.util.concurrent.ConcurrentMap;

public interface ISnakePlacementStrategy {

    public ConcurrentMap<Integer,Integer> getSnakePositions();
} 
