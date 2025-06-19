package com.snakegame.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import com.snakegame.placementstrategy.ILadderPlacementStrategy;

public class LadderTest {

    ILadderPlacementStrategy ladderPlacementStrategy;

    @BeforeEach
    public void setUp(){
        ladderPlacementStrategy=mock(ILadderPlacementStrategy.class);
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(6,42);
        map.put(40,90);
        when(ladderPlacementStrategy.getLadderPositions()).thenReturn(map);
    }

    @Test
    public void testLadderPositions(){
        Ladder ladder=new Ladder(ladderPlacementStrategy);
        Map<Integer,Integer> map=ladder.getLadderPositions();
        assertTrue(map.get(6)==42);
    }
    
}
