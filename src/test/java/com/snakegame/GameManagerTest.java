package com.snakegame;

import org.junit.jupiter.api.Test;

import com.snakegame.entity.Board;
import com.snakegame.entity.Dice;
import com.snakegame.entity.Player;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Scanner;

public class GameManagerTest {

    @Test
    public void testPlayReturnsWinner(){
        Dice dice=mock(Dice.class);
        Board board=mock(Board.class);
        Scanner scanner=new Scanner(System.in);

        Player player=new Player("RED");
        Player player2=new Player("Blue");

        List<Player> players=List.of(player,player2);

        GameManager manager=spy(new GameManager(scanner,board, dice));

        doReturn(false).doReturn(false).doReturn(true)
        .when(manager).processTurn(any());

        Player winner = manager.playGame(players);

        // Assert that the correct player is returned
        assertEquals(player, winner);

    }
    
}
