package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class GroupOfCards {
    private List<Card> cards;

    public GroupOfCards(int initialSize) {
        cards = new ArrayList<>(initialSize);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}