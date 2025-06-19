package com.snakegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

        List<Player> players=new ArrayList<>();
       try (Scanner scanner=new Scanner(System.in);) {

            System.out.println("How many players are playing:");
            int noOfPlayers=scanner.nextInt();
            scanner.nextLine();

            for(int i=0;i<noOfPlayers;i++){
                System.out.println("Choose a color for player :"+(i+1)+":");
                String color=scanner.nextLine().trim();
                Player player=new Player(color);
                players.add(player);
            }
             Player gameWinner=null;
             GameManager gameManager=new GameManager(scanner,setUpBoard(),getDice());
             gameWinner=gameManager.playGame(players);
        
            logger.info("<<<<GAME WINNER IS:>>>>" + gameWinner.getColor());
       } catch (Exception e) {
            e.printStackTrace();
       } 
        
       
    }

    private static Board setUpBoard(){
         ISnakePlacementStrategy snakePlacementStrategy=new FixedSnakePlacementStrategy();
         ILadderPlacementStrategy ladderPlacementStrategy=new FixedLadderPlacementStrategy();

         Board board=new Board(snakePlacementStrategy, ladderPlacementStrategy);
         return board;
    }

    private static Dice getDice(){
         return new Dice();
    }
}
