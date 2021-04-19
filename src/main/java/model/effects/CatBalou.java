package model.effects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import model.Card;
import model.Player;
import model.Table;

public class CatBalou implements Effect {

    @Override
    public void useEffect(Table table) {
        List<Player> others = new ArrayList<>(table.getPlayers());
        others.remove(0);
        Player opponent = others.get((int)(Math.random() * others.size()));
        
        TurnObservable<Map<Card, Player>> cardOb = table.getChooseCardsObservable();
        cardOb.addObserver(() -> {
            Card card = ob.get().keySet().toArray()[0];
            opponent.removeCard(card);
        });
        
        table.chooseCards(opponent.getCards(), Arrays.asList(table.getCurrentPlayer()), 1);
    }

}
