package com.snakegame.placementstrategy;

import java.util.concurrent.ConcurrentMap;

public interface ILadderPlacementStrategy {
    public ConcurrentMap<Integer,Integer> getLadderPositions();
}
