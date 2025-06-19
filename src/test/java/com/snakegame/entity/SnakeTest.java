package com.snakegame.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import com.snakegame.placementstrategy.ISnakePlacementStrategy;

public class SnakeTest {

    ISnakePlacementStrategy snakePlacementStrategy;

    @BeforeEach
    public void setUp(){
        snakePlacementStrategy=mock(ISnakePlacementStrategy.class);
        Map<Integer,Integer> snakeMap=new HashMap<Integer,Integer>();
        snakeMap.put(90,34);
        snakeMap.put(60,20);
        when(snakePlacementStrategy.getSnakePositions()).thenReturn(snakeMap);
    }

    @Test
    public void getSnakePositions(){
        Snake snake=new Snake(snakePlacementStrategy);
        Map<Integer,Integer> snakeMap=snake.getSnakePositions();
        assertTrue(snakeMap.get(90)==34);
    }
    
}
