package com.snakegame.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.snakegame.placementstrategy.ILadderPlacementStrategy;



public class Ladder {
    ILadderPlacementStrategy ladderPlacementStrategy;

    public Ladder(ILadderPlacementStrategy ladderPlacementStrategy){
        this.ladderPlacementStrategy=ladderPlacementStrategy;
    }

    public ConcurrentMap<Integer,Integer> getLadderPositions(){
        return ladderPlacementStrategy.getLadderPositions();
    }
}
