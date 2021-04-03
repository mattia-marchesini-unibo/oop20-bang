package model.deck;

public class Deck extends AbstractDeck {

    public Deck() {
        super(new JSONDeckReader());
    }
}
