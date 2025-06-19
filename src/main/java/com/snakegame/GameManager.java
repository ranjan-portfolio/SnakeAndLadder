package com.snakegame;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;


import com.snakegame.entity.Board;
import com.snakegame.entity.Dice;
import com.snakegame.entity.Player;


public class GameManager {
    private static final Logger logger=Logger.getLogger(GameManager.class.getName());
    
    private Board board;
    private Dice dice;
    private Scanner scanner;

    public GameManager(Scanner scanner,Board board,Dice dice){
        this.board=board;
        this.dice=dice;
        this.scanner=scanner;
    }
   
    public  Player playGame(List<Player> players) {
        if(players!=null && !players.isEmpty()){
            while(true){
                for(Player player: players){
                    if(processTurn(player)){
                        return player;
                    }
                }
            }
        }
        return null;


    }

      boolean processTurn(Player player){
        String color=player.getColor();
        logger.info("This is player::"+color+"::turn");
        logger.info("Press Enter to roll dice::");
        scanner.nextLine();
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
           logger.info("Snake bite<<<<"+color+"::position demoted to::"+snake+"::from::"+player.getCurrentPosition());
            player.setCurrentPosition(snake);
        });
       

        //check ladder and increment the current position
        board.getLadder(newPosition).ifPresent(ladder -> {
            logger.info("Ladder Climb>>>>"+color+"::position promoted to::"+ladder+"::from::"+player.getCurrentPosition());
            player.setCurrentPosition(ladder);
        });
        
        return player.getCurrentPosition()==Board.GAME_WINNING_POSITION;
    }
    
}
