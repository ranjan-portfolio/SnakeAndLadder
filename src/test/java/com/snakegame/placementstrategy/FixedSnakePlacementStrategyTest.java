package com.snakegame.placementstrategy;

import org.junit.jupiter.api.Test;


import com.snakegame.placementstrategy.impl.FixedSnakePlacementStrategy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class FixedSnakePlacementStrategyTest {

    @Test
    public void testSnakePositions(){
        FixedSnakePlacementStrategy fixedSnakePlacementStrategyTest=new FixedSnakePlacementStrategy();
        Map<Integer,Integer> map=fixedSnakePlacementStrategyTest.getSnakePositions();
        assertTrue(map.get(99)==78);
        assertNull(map.get(1));
    }
    
}
