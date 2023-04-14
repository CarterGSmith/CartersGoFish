package project;

public class GoFishCard extends Card {
    public enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}
    public enum Value {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    private Suit suit;
    private Value value;

    public GoFishCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
