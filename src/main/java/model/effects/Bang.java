package model.effects;

import model.Logics;
import model.Player;
import model.Table;
import model.TurnObservable;

import libs.CircularList;

public class Bang implements Effect {

    @Override
    public void useEffect(Table table) {
        if(table.getCurrentPlayer().getActiveCardsByName("volcanic").size() != 0 || !table.getPlayerUsedCards().contains("bang")) {
            TurnObservable<Player> ob = table.getChoosePlayerObservable();
            Player current = table.getCurrentPlayer();
            CircularList<Player> players = table.getPlayers();

            ob.addObserver(() -> {
                Player p = ob.get();

                if(p.hasProtection()) {
                    p.removeProtection();
                }
                else if(current.getSight() >= Math.abs(players.indexOf(p)) + p.getRetreat()) {
                    p.modifyLifePoints(-1);
                }
            });
            Logics logics = new Logics(table);

            table.choosePlayer(logics.getTargets());
            table.playerUsedCard("bang");
        }
    }
}
