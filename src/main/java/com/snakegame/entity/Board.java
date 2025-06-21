package com.snakegame.entity;


import java.util.logging.Logger;
import com.snakegame.placementstrategy.ILadderPlacementStrategy;
import com.snakegame.placementstrategy.ISnakePlacementStrategy;



public class Board {

    private Snake snake;
    private Ladder ladder;
    public static final int GAME_WINNING_POSITION=100;
    public static Logger logger=Logger.getLogger(Board.class.getName());

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

    

    public Board(ISnakePlacementStrategy snakePlacementStrategy,ILadderPlacementStrategy ladderPlacementStrategy){
        this.snake=new Snake(snakePlacementStrategy);
        this.ladder=new Ladder(ladderPlacementStrategy);
    }

    

    public int updatePosition(String color,int currentPosition,int diceOutCome){
        Integer updatedPosition=currentPosition+diceOutCome;
        updatedPosition=snake.updatePlayerPositionForSnakeBite(color,updatedPosition);
        updatedPosition=ladder.updatePlayerPositionForLadderJump(color, currentPosition);
        return updatedPosition.intValue();
    }

    public boolean checkBoardEdgeCase(String color,int currentPosition){
        if(currentPosition>GAME_WINNING_POSITION){
            logger.info("Player::"+color+"::exceeds position 100!! try next time");
            return false;
        }
        return true;
    }
    
}
