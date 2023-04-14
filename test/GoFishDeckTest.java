package test;

import static org.junit.Assert.*;
import org.junit.Test;
import project.GoFishDeck;

public class GoFishDeckTest {

    @Test
    public void testDeckInitialization() {
        GoFishDeck deck = new GoFishDeck();
        assertEquals(52, deck.getSize());
    }

    @Test
    public void testDeckShuffling() {
        GoFishDeck deck1 = new GoFishDeck();
        GoFishDeck deck2 = new GoFishDeck();
        deck1.shuffle();
        assertNotEquals(deck1, deck2);
    }

    @Test
    public void testDeal() {
        GoFishDeck deck = new GoFishDeck();
        deck.deal(5);
        assertEquals(47, deck.getSize());
    }
}
