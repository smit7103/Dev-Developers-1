package ca.sheridancollege.project;

public class BlackjackPlayer extends Player {
    private final GroupOfCards hand;

    public BlackjackPlayer(String name) {
        super(name);
        this.hand = new GroupOfCards(0);
    }

    public void play() {
        System.out.println(getName() + " is playing.");
    }

    public void hit(Deck deck) {
        hand.addCard(deck.dealCard());
    }

    public int getHandValue() {
        int totalValue = 0;
        int aceCount = 0;

        for (Card card : hand.getCards()) {
            totalValue += ((PlayingCard) card).getValue();
            if (((PlayingCard) card).getValue() == 11) {
                aceCount++;
            }
        }

        while (totalValue > 21 && aceCount > 0) {
            totalValue -= 10; // Convert an Ace from 11 to 1
            aceCount--;
        }

        return totalValue;
    }

    public boolean isBust() {
        return getHandValue() > 21;
    }

    public GroupOfCards getHand() {
        return hand;
    }
}

