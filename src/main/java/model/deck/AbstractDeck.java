package model.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Card;

abstract class AbstractDeck implements IDeck {

    protected IDeckReader reader;
    protected List<Card> cards = null;

    public AbstractDeck(IDeckReader reader) {
        this.reader = reader;
    }

    @Override
    public void newGame() {
        this.cards = this.reader.readCards();
        Collections.shuffle(this.cards);
    }

    @Override
    public Card nextCard() {
        if(this.cards == null) {
            this.newGame();
        }
        return this.cards.remove(0);
    }

    @Override
    public List<Card> nextCards(int step) {
        if(this.cards == null) {
            this.newGame();
        }

        List<Card> removed = new ArrayList<>();
        for(int i = 0; i < step; i++) {
            removed.add(this.cards.remove(i));
        }
        return removed;
    }

    @Override
    public int remanigCards() {
        return this.cards.size();
    }
}
