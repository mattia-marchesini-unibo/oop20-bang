package model.deck;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import libs.resources.Resources;
import model.card.Color;
import model.card.Card;

class JSONDeckReader implements IDeckReader {

    private List<Card> cards = null;
    private final static String DECK_FILE = "deck.json";
    
    private class JSONCard {
        String localName;
        String realName;
        Color color;
        int howMany;
        
        @SuppressWarnings("unused")
        public JSONCard(String localName, String realName, Color color, int howMany) {
            this.localName = localName;
            this.realName = realName;
            this.color = color;
            this.howMany = howMany;
        }
    }

    @Override
    public List<Card> readCards() {
        if (this.cards == null) {
            this.cards = new ArrayList<>();
            String json = Resources.readFile(DECK_FILE);
            Gson gson = new Gson();
            List<JSONCard> c = gson.fromJson(json, new TypeToken<List<JSONCard>>() {}.getType());
            c.forEach(crd -> {
                for(int i = 0; i < crd.howMany; i++) {
                    this.cards.add(new Card(
                        crd.realName + String.valueOf(i),
                        crd.color,
                        crd.localName,
                        crd.realName
                    ));
                }
            });
        }
        return cards;
    }

}
