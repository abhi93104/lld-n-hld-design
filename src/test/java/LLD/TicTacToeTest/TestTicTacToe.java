package LLD.TicTacToeTest;

import LLD.TicTacToe.Game;
import LLD.TicTacToe.Player;
import LLD.TicTacToe.Symbol;
import LLD.TicTacToe.TicTacToeException;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTicTacToe {


    @BeforeEach
    public void setup(){
        System.out.println("Setting up for the test");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Running post test script");
    }

    @Test
    public void test() throws TicTacToeException {
        Game game = new Game(4);
        game.addPlayers(new Player("Abhishek", Symbol.O));
        game.addPlayers(new Player("Honey", Symbol.X));
        game.addPlayers(new Player("Shubham", Symbol.A));
        //TODO: read scanner input from test file and then call startGame()

        Assert.assertEquals(1,1);
    }
}
