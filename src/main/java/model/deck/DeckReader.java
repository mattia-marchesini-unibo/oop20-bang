package model.deck;

import java.util.List;

import model.card.Card;

interface DeckReader {

    List<Card> readCards();
}
