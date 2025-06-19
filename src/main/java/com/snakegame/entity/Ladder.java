package com.snakegame.entity;

import java.util.Map;

import com.snakegame.placementstrategy.ILadderPlacementStrategy;



public class Ladder {
    ILadderPlacementStrategy ladderPlacementStrategy;

    public Ladder(ILadderPlacementStrategy ladderPlacementStrategy){
        this.ladderPlacementStrategy=ladderPlacementStrategy;
    }

    public Map<Integer,Integer> getLadderPositions(){
        return ladderPlacementStrategy.getLadderPositions();
    }
}
