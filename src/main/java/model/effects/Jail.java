package model.effects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Player;
import model.Role;
import model.Table;
import model.TurnObservable;

public class Jail implements Effect {

    @Override
    public void useEffect(Table table) {
        Player p1 = table.getCurrentPlayer();
        TurnObservable<Player> ob = table.getChoosePlayerObservable();
        
        ob.addObserver(() -> {
            Player p2 = ob.get();
            System.out.println("Dentro la jail il nome è: " + ob.get().getName());
            p2.addActiveCard(p1.getCardsByName("jail").get(0));
            p2.setPrison(true);
        });
        
        List<Player> others = new ArrayList<>(table.getPlayers());
        others.remove(p1);
        others.remove(table.getPlayers().stream().filter(p -> p.getRole().equals(Role.SHERIFF)).findFirst().get());
        table.choosePlayer(others.stream().collect(Collectors.toSet()));
    }

}
