package com.snakegame;

import java.util.List;
import java.util.logging.Logger;


import com.snakegame.entity.Board;
import com.snakegame.entity.Dice;
import com.snakegame.entity.Player;
import com.snakegame.placementstrategy.ILadderPlacementStrategy;
import com.snakegame.placementstrategy.ISnakePlacementStrategy;
import com.snakegame.placementstrategy.impl.FixedLadderPlacementStrategy;
import com.snakegame.placementstrategy.impl.FixedSnakePlacementStrategy;

public class GameManager {
    private static final Logger logger=Logger.getLogger(GameManager.class.getName());
    
    private Board board;
    private Dice dice;

    public GameManager(Board board,Dice dice){
        this.board=board;
        this.dice=dice;
    }
   
    public  Player playGame(List<Player> players) {
        while(true){
            for(Player player: players){
                if(processTurn(player, board, dice)){
                    return player;
                }
            }

        }


    }

      boolean processTurn(Player player,Board board,Dice dice){
        String color=player.getColor();
        logger.info("This is player::"+color+"::turn");
        int diceOutCome=dice.rollDice();
        logger.info("Dice rolled by::"+color+"::outcome is::"+diceOutCome);
        int newPosition=player.getCurrentPosition()+diceOutCome;
        logger.info("Postion of player::"+color+"::is::"+newPosition);
        if(newPosition>Board.GAME_WINNING_POSITION){
            logger.info("Player::"+color+"::exceeds position 100!! try next time");
            return false;
        } 
        
        player.setCurrentPosition(newPosition);
        newPosition=player.getCurrentPosition();
        //check snake and decrement the current position
        board.getSnakeBites(newPosition).ifPresent(snake -> {
            player.setCurrentPosition(snake);
            logger.info("Snake bite<<<<"+color+"::position demoted to::"+snake+"::from::"+player.getCurrentPosition());
        });
       

        //check ladder and increment the current position
        board.getLadder(newPosition).ifPresent(ladder -> {
            player.setCurrentPosition(ladder);
            logger.info("Snake bite<<<<"+color+"::position demoted to::"+ladder+"::from::"+player.getCurrentPosition());
        });
        
        return player.getCurrentPosition()==Board.GAME_WINNING_POSITION;
    }
    
}
