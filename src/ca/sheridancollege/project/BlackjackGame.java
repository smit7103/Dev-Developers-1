    package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame extends Game {
    private final Deck deck;
    private final Dealer dealer;

    public BlackjackGame(String name) {
        super(name);
        this.deck = new Deck(); // Initialize the deck
        this.dealer = new Dealer();
    }

    public void play() {
        // Shuffle and deal
        deck.shuffle();
        for (Player player : getPlayers()) {
            ((BlackjackPlayer) player).hit(deck);
            ((BlackjackPlayer) player).hit(deck);
        }
        dealer.hit(deck);
        dealer.hit(deck);

        // Players take turns
        Scanner scanner = new Scanner(System.in);
        for (Player player : getPlayers()) {
            BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
            while (blackjackPlayer.getHandValue() < 21) {
                System.out.println(blackjackPlayer.getName() + ", your hand value is " + blackjackPlayer.getHandValue());
                System.out.println("Do you want to hit or stand? (h/s)");
                String decision = scanner.next();
                if (decision.equals("h")) {
                    blackjackPlayer.hit(deck);
                    System.out.println("You hit and got a " + blackjackPlayer.getHandValue());
                } else {
                    System.out.println("You stand.");
                    break;
                }
            }

            if (blackjackPlayer.isBust()) {
                System.out.println(blackjackPlayer.getName() + " busted!");
            }
        }

        // Dealer's turn
        dealer.play(deck);

        // Declare the winner
        declareWinner();
    }

    public void declareWinner() {
        for (Player player : getPlayers()) {
            BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
            if (!blackjackPlayer.isBust() && (dealer.isBust() || blackjackPlayer.getHandValue() > dealer.getHandValue())) {
                System.out.println(blackjackPlayer.getName() + " wins!");
            } else {
                System.out.println("Dealer wins!");
            }
        }
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame("Blackjack");
        game.addPlayer(new BlackjackPlayer("Player 1"));
        game.addPlayer(new BlackjackPlayer("Player 2"));
        game.play();
    }
}