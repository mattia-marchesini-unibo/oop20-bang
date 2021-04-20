package model.deck;

import java.util.List;

import model.card.Card;

interface IDeckReader {

    List<Card> readCards();
}
