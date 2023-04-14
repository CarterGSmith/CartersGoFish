package test;
import static org.junit.Assert.*;
import org.junit.Test;
import project.GoFishCard;
import project.GoFishCard.Value;
import GoFishCard.Suit;

public class GoFishCardTest {

    @Test
    public void testToString() {
        GoFishCard card = new GoFishCard(Value.ACE, Suit.CLUBS);
        assertEquals("ACE of CLUBS", card.toString());
    }

    @Test
    public void testEquals() {
        GoFishCard card1 = new GoFishCard(Value.ACE, Suit.CLUBS);
        GoFishCard card2 = new GoFishCard(Value.ACE, Suit.CLUBS);
        assertTrue(card1.equals(card2));
    }
}
