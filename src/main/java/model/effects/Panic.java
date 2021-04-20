package model.effects;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import model.Player;
import model.Table;
import model.TurnObservable;
import model.card.Card;

public class Panic implements Effect {

    @Override
    public void useEffect(Table table) {
        TurnObservable<List<Player>> opponentOb = table.getChoosePlayersObservable();
        Player current = table.getCurrentPlayer();

        TurnObservable<Map<Card, Player>> cardOb = table.getChooseCardsObservable();

        opponentOb.addObserver(() -> {
            Player opponent = opponentOb.get().get(0);
            cardOb.addObserver(() -> {
                Map<Card, Player> map = cardOb.get();
                opponent.removeCard(map.keySet().iterator().next());
            });

            table.chooseCards(opponent.getCards(), Arrays.asList(current), 1);
        });

        table.choosePlayers(1, 1);
    }

}
