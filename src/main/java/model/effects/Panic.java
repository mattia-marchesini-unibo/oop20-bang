package model.effects;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import libs.CircularList;
import model.Card;
import model.Player;
import model.Table;

public class Panic implements Effect {

    @Override
    public void useEffect(Table table) {
        TurnObservable<List<Player>> opponentOb = table.getChoosePlayersObservable();
        Player current = table.getCurrentPlayer();
        Player opponent = null;

        opponentOb.addObserver(() -> {
            opponent = opponentOb.get().get(0);
        });

        TurnObservable<Map<Card, Player>> cardOb = table.getChooseCardsObservable();
        cardOb.addObserver(() -> {
            Map<Card, Player> map = ob.get();
            opponent.removeCard(map.keySet().toArray()[0]);
        });

        table.choosePlayers(1, 1);
        table.chooseCards(opponent.getCards(), Arrays.asList(current), 1);
    }

}
