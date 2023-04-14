package project;

import java.util.ArrayList;
import java.util.HashMap;

public class GoFishPlayer extends Player {

    private ArrayList<GoFishCard> hand;
    private int pairs;

    public GoFishPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
        pairs = 0;
    }

    public void addToHand(GoFishCard card) {
        hand.add(card);
    }

    public ArrayList<GoFishCard> getHand() {
        return hand;
    }

    public void transferCards(ArrayList<GoFishCard> cards, GoFishPlayer toPlayer) {
        for (GoFishCard card : cards) {
            hand.remove(card);
            toPlayer.addToHand(card);
        }
    }

    public void checkForPairs() {
        for (int i = 0; i < hand.size() - 1; i++) {
            GoFishCard card1 = hand.get(i);
            for (int j = i + 1; j < hand.size(); j++) {
                GoFishCard card2 = hand.get(j);
                if (card1.getValue() == card2.getValue()) {
                    hand.remove(card1);
                    hand.remove(card2);
                    pairs++;
                    return;
                }
            }
        }
    }

    public int getPairs() {
        return pairs;
    }

    public ArrayList<GoFishCard> getCardsByRank(GoFishCard.Value rank) {
        ArrayList<GoFishCard> cardsWithRank = new ArrayList<>();
        for (GoFishCard card : hand) {
            if (card.getValue() == rank) {
                cardsWithRank.add(card);
            }
        }
        return cardsWithRank;
    }

    @Override
    public void play() {}
}

