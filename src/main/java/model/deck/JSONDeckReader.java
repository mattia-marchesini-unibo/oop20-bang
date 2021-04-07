package model.deck;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import libs.resources.Resources;
import model.Card;

class JSONDeckReader implements IDeckReader {

    private List<Card> cards = null;
    private final static String DECK_FILE = "deck.json";
    
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
        if (this.cards == null) {
            this.cards = new ArrayList<>();
            String json = Resources.readFile(DECK_FILE);
            Gson gson = new Gson();
            List<JSONCard> c = gson.fromJson(json, new TypeToken<List<Card>>() {}.getType());
            c.forEach(crd -> {
                for(int i = 0; i < crd.howMany; i++) {
                    this.cards.add(new Card(crd.name + String.valueOf(i), crd.name, crd.actions));
                }
            });
        }
        return cards;
    }

}
