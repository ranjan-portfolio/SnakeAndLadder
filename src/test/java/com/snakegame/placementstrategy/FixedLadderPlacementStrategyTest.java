package com.snakegame.placementstrategy;

import java.util.Map;
import com.snakegame.placementstrategy.impl.FixedLadderPlacementStrategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class FixedLadderPlacementStrategyTest{

    @Test
    public void testGetLadderPositions() {
       FixedLadderPlacementStrategy fixedLadderPlacementStrategy=new FixedLadderPlacementStrategy();
       Map<Integer,Integer> map=fixedLadderPlacementStrategy.getLadderPositions();
       assertTrue(map.get(2)==38);
       assertNull(map.get(1)); //Negative testcase
    }

}
