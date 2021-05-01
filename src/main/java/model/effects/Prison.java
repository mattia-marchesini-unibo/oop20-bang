package model.effects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Player;
import model.Table;
import model.TurnObservable;
import model.card.Card;

public class Prison implements Effect {

    @Override
    public void useEffect(Table table) {
        Player p1 = table.getCurrentPlayer();
        TurnObservable<Player> ob = table.getChoosePlayerObservable();

        ob.addObserver(() -> {
            Player p2 = ob.get();
            
            p2.setPrison(true);
        });
        
        List<Player> others = new ArrayList<>(table.getPlayers());
        others.remove(p1);
        table.choosePlayer(others.stream().collect(Collectors.toSet()));
    }

}
