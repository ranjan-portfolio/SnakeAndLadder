package com.snakegame.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.snakegame.placementstrategy.ISnakePlacementStrategy;

public class SnakeTest {

    ISnakePlacementStrategy snakePlacementStrategy;

    @BeforeEach
    public void setUp(){
        snakePlacementStrategy=mock(ISnakePlacementStrategy.class);
        ConcurrentMap<Integer,Integer> snakeMap=new ConcurrentHashMap<Integer,Integer>();
        snakeMap.put(90,34);
        snakeMap.put(60,20);
        when(snakePlacementStrategy.getSnakePositions()).thenReturn(snakeMap);
    }

    @Test
    public void getSnakePositions(){
        Snake snake=new Snake(snakePlacementStrategy);
        ConcurrentMap<Integer,Integer> snakeMap=snake.getSnakePositions();
        assertTrue(snakeMap.get(90)==34);
    }
    
}
