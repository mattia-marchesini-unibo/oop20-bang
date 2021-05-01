package model;

import java.util.HashSet;
import java.util.Set;

public class Logics {

    private Table table;

    public Logics(final Table table) {
        this.table = table;
    }

    public Set<Player> getTargets() {
        Player currentPlayer = this.table.getCurrentPlayer();
        Set<Player> targets = new HashSet<Player>();

        Player cur = currentPlayer;
        for (int i = 1; i <= currentPlayer.getSight(); i++) {
            var playerdx = this.table.getPlayers().getNextOf(cur);
            i = i + playerdx.getRetreat();
            if (i <= currentPlayer.getSight()) {
                targets.add(playerdx);
            }
            cur = this.table.getPlayers().getNextOf(cur);
        }

        cur = currentPlayer;
        for (int i = 1; i <= currentPlayer.getSight(); i++) {
            var playerdx = this.table.getPlayers().getPrevOf(cur);
            i = i + playerdx.getRetreat();
            if (i <= currentPlayer.getSight()) {
                targets.add(playerdx);
            }
            cur = this.table.getPlayers().getPrevOf(cur);
        }
        targets.remove(currentPlayer);
        return targets;
    }
}
