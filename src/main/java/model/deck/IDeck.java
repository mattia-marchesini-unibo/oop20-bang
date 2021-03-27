package model.deck;

import java.util.List;

import model.Card;

public interface IDeck {

    void newGame();
    
    Card nextCard();
    
    List<Card> nextCards(int step);
    
    int remanigCards();
}
