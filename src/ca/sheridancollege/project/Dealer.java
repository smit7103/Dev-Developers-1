package ca.sheridancollege.project;

public class Dealer extends BlackjackPlayer {

    public Dealer() {
        super("Dealer");
    }

    public void play(Deck deck) {
        // Dealer must hit until their hand value is at least 17
        while (getHandValue() < 17) {
            System.out.println("Dealer hits.");
            hit(deck); // Hit from the passed deck
        }
    }
}
