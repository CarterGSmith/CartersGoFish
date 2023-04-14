package test;

import static org.junit.Assert.*;
import org.junit.Test;
import project.GoFishPlayer;
import project.GoFishCard;
import project.GoFishCard.Value;
import project.GoFishCard.Suit;

public class GoFishPlayerTest {

    @Test
    public void testAddCard() {
        GoFishPlayer player = new GoFishPlayer("Player1");
        GoFishCard card = new GoFishCard(Value.ACE, Suit.CLUBS);
        player.addCard(card);
        assertEquals(1, player.getHand().size());
    }

    @Test
    public void testRemoveCard() {
        GoFishPlayer player = new GoFishPlayer("Player1");
        GoFishCard card = new GoFishCard(Value.ACE, Suit.CLUBS);
        player.addCard(card);
        player.removeCard(card);
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void testCheckForPairs() {
        GoFishPlayer player = new GoFishPlayer("Player1");
        GoFishCard card1 = new GoFishCard(Value.ACE, Suit.CLUBS);
        GoFishCard card2 = new GoFishCard(Value.ACE, Suit.HEARTS);
        player.addCard(card1);
        player.addCard(card2);
        player.checkForPairs();
        assertEquals(0, player.getHand().size());
        assertEquals(1, player.getPairs());
    }
}
