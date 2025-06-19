package com.snakegame.entity;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

import com.snakegame.placementstrategy.ILadderPlacementStrategy;
import com.snakegame.placementstrategy.ISnakePlacementStrategy;



public class Board {

    private Snake snake;
    private Ladder ladder;
    private ConcurrentMap<Integer,Integer> snakePositions;
    private ConcurrentMap<Integer,Integer> ladderPositions;
    public static final int GAME_WINNING_POSITION=100;

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public ConcurrentMap<Integer, Integer> getSnakePositions() {
        return snakePositions;
    }

    public void setSnakePositions(ConcurrentMap<Integer, Integer> snakePositions) {
        this.snakePositions = snakePositions;
    }

    public ConcurrentMap<Integer, Integer> getLadderPositions() {
        return ladderPositions;
    }

    public void setLadderPositions(ConcurrentMap<Integer, Integer> ladderPositions) {
        this.ladderPositions = ladderPositions;
    }

    public Board(ISnakePlacementStrategy snakePlacementStrategy,ILadderPlacementStrategy ladderPlacementStrategy){
        this.snake=new Snake(snakePlacementStrategy);
        this.ladder=new Ladder(ladderPlacementStrategy);
        this.snakePositions=snake.getSnakePositions();
        this.ladderPositions=ladder.getLadderPositions();
    }

    public Optional<Integer> getSnakeBites(int position){
        return Optional.ofNullable(snakePositions.get(position));
    }

    public Optional<Integer> getLadder(int position){
        return Optional.ofNullable(ladderPositions.get(position));
    }
    
}
