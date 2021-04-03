package model.deck;

import java.util.List;

import model.Card;

class JSONDeckReader implements IDeckReader {

    private List<Card> cards = null;

    private class JSONCard {
        String name;
        int howMany;
        List<JSONCardAction> actions;
        
        public JSONCard(String name, int howMany, List<JSONCardAction> actions) {
            this.name = name;
            this.howMany = howMany;
            this.actions = actions;
        }
    }
    
    private class JSONCardAction {
        String action;
        String to;
        String when;
        
        public JSONCardAction(String action, String to, String when) {
            this.action = action;
            this.to = to;
            this.when = when;
        }
    }

    @Override
    public List<Card> readCards() {
        if(cards == null) {
            
        }
        return cards;
    }

}
