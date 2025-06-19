package com.snakegame.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class DiceTest {

   @Test
    public void testDiceOutcomes(){
        Dice dice=new Dice();
        for(int i=0;i<10;i++){
            int outcome=dice.rollDice();
            assert(outcome>=1 && outcome<=6);
        }
    }

    @RepeatedTest(10)
    public void testDiceResult(){
        Dice dice=new Dice();
        for(int i=0;i<10;i++){
            int outcome=dice.rollDice();
            assert(outcome>=1 && outcome<=6);
        }
    }

    @Test
    public void allDiceOutcomesAppearEventually(){
        boolean[] outcomes=new boolean[6];
        Dice dice=new Dice();
        for(int i=0;i<1000;i++){
            int outcome=dice.rollDice();
            outcomes[outcome-1]=true;
        }

        for(int i=0;i<outcomes.length-1;i++){
            assertTrue(outcomes[i],"Value " + (i + 1) + " did not appear in 1000 rolls");
        }
    }
    
}
