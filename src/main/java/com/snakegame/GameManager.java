package com.snakegame;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;


import com.snakegame.entity.Board;
import com.snakegame.entity.Dice;
import com.snakegame.entity.Player;


public class GameManager {
    private static final Logger logger=Logger.getLogger(GameManager.class.getSimpleName());
    
    private Board board;
    private Dice dice;
    private Scanner scanner;
    private boolean isWinnerFound=false;

    public GameManager(Scanner scanner,Board board,Dice dice){
        this.board=board;
        this.dice=dice;
        this.scanner=scanner;
    }
   
    public  Player playGame(List<Player> players) {
        if(players!=null && !players.isEmpty()){
            while(!isWinnerFound){
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
        int newPosition=board.updatePosition(color, player.getCurrentPosition(), diceOutCome);
        if(board.checkBoardEdgeCase(color,newPosition)){
            return false;
        } 
        logger.info("Postion of player::"+color+"::is::"+newPosition);
        player.setCurrentPosition(newPosition);
        return isWinnerFound=player.getCurrentPosition()==Board.GAME_WINNING_POSITION;
    }
    
}
