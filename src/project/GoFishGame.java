package project;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFishGame extends Game {
    private GoFishDeck deck;

    public GoFishGame(String name) {
        super(name);
        deck = new GoFishDeck(52);
    }

    @Override
    public void play() {
        // Shuffle the deck
        deck.shuffle();

        // Add players to the game
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of players (2-4): ");
        int numPlayers = input.nextInt();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Enter the name of Player " + i + ": ");
            String playerName = input.next();
            GoFishPlayer player = new GoFishPlayer(playerName);
            getPlayers().add(player);
        }

        // Deal initial cards to players
        for (Player player : getPlayers()) {
            for (int i = 0; i < 7; i++) {
                GoFishCard card = (GoFishCard) deck.getCards().remove(0);
                ((GoFishPlayer) player).addToHand(card);
            }
        }

        // Game loop
        boolean gameOver = false;
        while (!gameOver) {
            for (Player currentPlayer : getPlayers()) {
                if (deck.getCards().isEmpty()) {
                    gameOver = true;
                    break;
                }
                // Display the current player's hand
                System.out.println(currentPlayer.getName() + "'s turn");
                System.out.println("Your hand: " + ((GoFishPlayer) currentPlayer).getHand());

                // Choose another player to ask for a card
                System.out.println("Select a player to ask for a card (enter their number): ");
                for (int i = 0; i < getPlayers().size(); i++) {
                    if (getPlayers().get(i) != currentPlayer) {
                        System.out.println((i + 1) + ". " + getPlayers().get(i).getName());
                    }
                }
                int selectedPlayerIndex = input.nextInt() - 1;
                Player selectedPlayer = getPlayers().get(selectedPlayerIndex);

                // Choose a card rank to ask for
                System.out.println("Choose a card rank to ask for (1-13): ");
                int selectedRank = input.nextInt();
                GoFishCard.Value rank = GoFishCard.Value.values()[selectedRank - 1];

                // Check if the selected player has the requested card rank
                ArrayList<GoFishCard> cardsToTransfer = ((GoFishPlayer) selectedPlayer).getCardsByRank(rank);
                if (!cardsToTransfer.isEmpty()) {
                    // Transfer cards from the selected player to the current player
                    ((GoFishPlayer) currentPlayer).transferCards(cardsToTransfer, (GoFishPlayer) selectedPlayer);
                    System.out.println("Success! " + selectedPlayer.getName() + " had cards of rank " + rank + ".");
                } else {
                    // Draw a card from the deck
                    System.out.println("Go fish!");
                    GoFishCard drawnCard = (GoFishCard) deck.getCards().remove(0);
                    ((GoFishPlayer) currentPlayer).addToHand(drawnCard);
                }

                // Check for pairs in the current player's hand
                ((GoFishPlayer) currentPlayer).checkForPairs();

                // Check if the game is over
                if (deck.getCards().isEmpty() && allPlayersHandsEmpty()) {
                    gameOver = true;
                }
            }
        }

        // Declare the winner
        declareWinner();
    }

    private boolean allPlayersHandsEmpty() {
        for (Player player : getPlayers()) {
            if (!((GoFishPlayer) player).getHand().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void declareWinner() {
        int maxPairs = 0;
        GoFishPlayer winner = null;
        for (Player player : getPlayers()) {
            int pairs = ((GoFishPlayer) player).getPairs();
            System.out.println(player.getName() + " has " + pairs + " pairs.");
            if (pairs > maxPairs) {
                maxPairs = pairs;
                winner = (GoFishPlayer) player;
            } else if (pairs == maxPairs) {
                winner = null;
            }
        }

        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with " + maxPairs + " pairs!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        GoFishGame game = new GoFishGame("Go Fish");
        game.play();
    }
}
