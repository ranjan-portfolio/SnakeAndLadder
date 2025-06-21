package com.snakegame.entity;


import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

import com.snakegame.placementstrategy.ILadderPlacementStrategy;



public class Ladder {
    ILadderPlacementStrategy ladderPlacementStrategy;
    private ConcurrentMap<Integer,Integer> ladderPositions;
    public static final Logger logger=Logger.getLogger(Ladder.class.getSimpleName());

    public Ladder(ILadderPlacementStrategy ladderPlacementStrategy){
        this.ladderPlacementStrategy=ladderPlacementStrategy;
        ladderPositions= ladderPlacementStrategy.getLadderPositions();
    }

    public int updatePlayerPositionForLadderJump(String color,int currentPosition){
        Integer ladderJump=ladderPositions.get(currentPosition);
        if(ladderJump!=null){
            logger.info("Ladder jump>>>>"+color+"::position promoted to::"+ladderJump.intValue()+"::from::"+currentPosition);
            return ladderJump;
        }
        return Integer.valueOf(currentPosition);
    }

    
}
