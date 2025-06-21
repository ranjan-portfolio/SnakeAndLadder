package com.snakegame.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.snakegame.placementstrategy.ILadderPlacementStrategy;

public class LadderTest {

    ILadderPlacementStrategy ladderPlacementStrategy;
    ConcurrentMap<Integer,Integer> map;
    Ladder ladder;

    @BeforeEach
    public void setUp(){
        ladderPlacementStrategy=mock(ILadderPlacementStrategy.class);
        map=new ConcurrentHashMap<Integer,Integer>();
        map.put(6,42);
        map.put(40,90);
        when(ladderPlacementStrategy.getLadderPositions()).thenReturn(map);
        ladder=new Ladder(ladderPlacementStrategy);
    }

    @Test
    public void testLadderPositions(){
        assertEquals(ladder, map,"ladder should be created using strategy");
    }
    
}
