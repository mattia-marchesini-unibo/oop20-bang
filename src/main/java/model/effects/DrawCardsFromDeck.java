package model.effects;

import model.Table;

public class DrawCardsFromDeck implements Effect {

    private int howMuch;
    
    public DrawCardsFromDeck(int howMuch) {
        this.howMuch = howMuch;
    }
    
    @Override
    public void useEffect(Table table) {
        table.getDeck().nextCards(this.howMuch);
    }

}
