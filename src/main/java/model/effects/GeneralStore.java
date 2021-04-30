package model.effects;

import java.util.List;
import java.util.Map;

import libs.CircularList;
import model.Player;
import model.Table;
import model.TurnObservable;
import model.card.Card;

public class GeneralStore implements Effect {

    @Override
    public void useEffect(Table table) {
        CircularList<Player> players = table.getPlayers();
        List<Card> cards = table.getDeck().nextCards(players.size());

        TurnObservable<Map<Card, Player>> ob = table.getChooseCardsObservable();
        ob.addObserver(() -> {
            Map<Card, Player> map = ob.get();
            map.keySet().forEach(c -> {
                map.get(c).addCard(c);
            });
        });

        table.chooseCards(cards, players, 1);
    }
}
