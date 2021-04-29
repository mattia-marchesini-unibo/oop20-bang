package model.deck;

import java.util.List;

import model.card.Card;

public interface IDeck {

    void newGame();
    
    List<Card> getCards();
    
    Card nextCard();
    
    List<Card> nextCards(int step);
    
    int remainigCards();
    
    void shuffleDeck();
}
