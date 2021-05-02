package model.deck;

public class SimpleDeck extends AbstractDeck {

    public SimpleDeck() {
        super(new JSONDeckReader());
    }
}
