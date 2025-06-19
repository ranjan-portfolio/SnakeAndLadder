package com.snakegame;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.snakegame.entity.Board;
import com.snakegame.entity.Dice;
import com.snakegame.entity.Player;
import com.snakegame.placementstrategy.ILadderPlacementStrategy;
import com.snakegame.placementstrategy.ISnakePlacementStrategy;
import com.snakegame.placementstrategy.impl.FixedLadderPlacementStrategy;
import com.snakegame.placementstrategy.impl.FixedSnakePlacementStrategy;

public class SnakeAndLadderGame {
    private static final Logger logger=Logger.getLogger(SnakeAndLadderGame.class.getName());
    public static void main(String[] args) {
        
        Player player=new Player("RED");
        Player player1=new Player("BLUE");
        Player gameWinner=null;

        List<Player> players=List.of(player,player1);
        ISnakePlacementStrategy snakePlacementStrategy=new FixedSnakePlacementStrategy();
        ILadderPlacementStrategy ladderPlacementStrategy=new FixedLadderPlacementStrategy();

        Board board=new Board(snakePlacementStrategy, ladderPlacementStrategy);
        Dice dice=new Dice();
        
        GameManager gameManager=new GameManager(board,dice);
        try{
            gameWinner=gameManager.playGame(players);
        }catch(Exception ex){
            logger.log(Level.SEVERE,"Exception encountered!!!",ex);
            ex.printStackTrace();
            
        }
        
        logger.info("Game Winner IS:" + gameWinner.getColor());
    }
}
