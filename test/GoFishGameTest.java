package test;

import static org.junit.Assert.*;
import org.junit.Test;
import project.GoFishGame;
import project.GoFishPlayer;

public class GoFishGameTest {

    @Test
    public void testAddPlayer() {
        GoFishGame game = new GoFishGame("Go Fish");
        GoFishPlayer player = new GoFishPlayer("Player1");
        game.addPlayer(player);
        assertEquals(1, game.getPlayers().size());
    }

    @Test
    public void testNextPlayerTurn() {
        GoFishGame game = new GoFishGame("Go Fish");
        GoFishPlayer player1 = new GoFishPlayer("Player1");
        GoFishPlayer player2 = new GoFishPlayer("Player2");
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.nextPlayerTurn();
        assertEquals(player2, game.getCurrentPlayer());
    }

    @Test
    public void testWinCondition() {
        GoFishGame game = new GoFishGame("Go Fish");
        GoFishPlayer player1 = new GoFishPlayer("Player1");
        GoFishPlayer player2 = new GoFishPlayer("Player2");
        game.addPlayer(player1);
        game.addPlayer(player2);
        // Simulate game end conditions
        player1.setPairs(10);
        player2.setPairs(6);
        game.checkWinCondition();
        assertEquals(player1, game.getWinner());
    }
}
