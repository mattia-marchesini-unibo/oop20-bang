package model.effects;

import model.Player;
import model.Table;
import model.TurnObservable;

import java.util.List;

import libs.CircularList;

public class Bang implements Effect {

    @Override
    public void useEffect(Table table) {
        TurnObservable<List<Player>> ob = table.getChoosePlayersObservable();
        Player current = table.getCurrentPlayer();
        CircularList<Player> players = table.getPlayers();

        ob.addObserver(() -> {
            Player p = ob.get().get(0);

            if(p.hasProtection()) {
                p.removeProtection();
            }
            else if(current.getSight() >= Math.abs(players.indexOf(p)) + p.getRetreat()) {
                p.modifyLifePoints(-1);
            }
        });

        table.choosePlayers();
        table.playerUsedCard("bang");
    }
}
