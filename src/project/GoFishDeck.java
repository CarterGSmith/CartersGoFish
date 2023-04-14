package project;

import java.util.ArrayList;

public class GoFishDeck extends GroupOfCards {
    public GoFishDeck(int size) {
        super(size);
        initializeDeck();
    }

    private void initializeDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (GoFishCard.Suit suit : GoFishCard.Suit.values()) {
            for (GoFishCard.Value value : GoFishCard.Value.values()) {
                deck.add(new GoFishCard(suit, value));
            }
        }
        setCards(deck);
    }
}
