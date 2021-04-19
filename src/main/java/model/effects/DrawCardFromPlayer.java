package model.effects;

import java.util.Arrays;
import java.util.List;

import model.Player;
import model.Table;

public class DrawCardFromPlayer implements Effect {

    private int wichOne;

    public DrawCardFromPlayer(int wichOne) {
        this.wichOne = wichOne;
    }

    @Override
    public void useEffect(Table table) {
        TurnObservable<List<Player>> ob = table.getChoosePlayersObservable();

        ob.addObserver(() -> {
            Player p = ob.get().get(0);

            p.getCards().remove(wichOne);
        });
        table.choosePlayers(1);
    }
}
