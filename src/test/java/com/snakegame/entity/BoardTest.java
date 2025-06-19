package com.snakegame.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.snakegame.placementstrategy.ILadderPlacementStrategy;
import com.snakegame.placementstrategy.ISnakePlacementStrategy;

public class BoardTest {
     private ISnakePlacementStrategy snakePlacementStrategy;
     private ILadderPlacementStrategy ladderPlacementStrategy;

    @BeforeEach
    public void setup(){
       snakePlacementStrategy=mock(ISnakePlacementStrategy.class);
       ladderPlacementStrategy=mock(ILadderPlacementStrategy.class);
       ConcurrentMap<Integer,Integer> snakeMap=new ConcurrentHashMap<>(Map.of(99,54,66,36));
       ConcurrentMap<Integer,Integer> ladderMap=new ConcurrentHashMap<>(Map.of(33,78,45,90));

       when(snakePlacementStrategy.getSnakePositions()).thenReturn(snakeMap);
       when(ladderPlacementStrategy.getLadderPositions()).thenReturn(ladderMap);
    }

    @Test
    public void testSnakeBites(){
        Board board=new Board(snakePlacementStrategy, ladderPlacementStrategy);
        Optional<Integer> bite=board.getSnakeBites(99);
        assertTrue(bite.isPresent());
        assertEquals(bite.get(),54);
        
    }

    @Test
    public void testLadderJumps(){
         Board board=new Board(snakePlacementStrategy, ladderPlacementStrategy);
         Optional<Integer> jump=board.getLadder(33);
         assertTrue(jump.isPresent());
         assertEquals(jump.get(),78);
    }

    @Test
    public void testNoSnakeBites(){
        Board board=new Board(snakePlacementStrategy, ladderPlacementStrategy);
        Optional<Integer> bite=board.getSnakeBites(10);
        assertTrue(bite.isEmpty());
    }

    @Test
    public void testNoLadderJumps(){
         Board board=new Board(snakePlacementStrategy, ladderPlacementStrategy);
         Optional<Integer> jump=board.getLadder(20);
         assertTrue(jump.isEmpty());
    }

    
}
