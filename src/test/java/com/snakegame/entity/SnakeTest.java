package com.snakegame.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.snakegame.placementstrategy.ISnakePlacementStrategy;

public class SnakeTest {

    private ISnakePlacementStrategy snakePlacementStrategy;
    private Snake snake;
    private ConcurrentMap<Integer,Integer> snakeMap;


    @BeforeEach
    public void setUp(){
        snakePlacementStrategy=mock(ISnakePlacementStrategy.class);
        snakeMap=new ConcurrentHashMap<Integer,Integer>();
        snakeMap.put(90,34);
        snakeMap.put(60,20);
        when(snakePlacementStrategy.getSnakePositions()).thenReturn(snakeMap);
        snake=new Snake(snakePlacementStrategy);
    }

    @Test
    public void getSnakePositions(){
        
        assertEquals(snake.snakePositions, snakeMap,"Snake positions should be intialized through strategy");
    }
    
}
