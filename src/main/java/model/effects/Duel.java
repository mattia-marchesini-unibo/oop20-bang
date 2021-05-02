package model.effects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Player;
import model.Table;
import model.TurnObservable;
import model.card.Card;

public class Duel implements Effect {

    @Override
    public void useEffect(Table table) {
        Player p1 = table.getCurrentPlayer();
        TurnObservable<Player> ob = table.getChoosePlayerObservable();

        ob.addObserver(() -> {
            Player p2 = ob.get();
            
            List<Card> p1Bangs = p1.getCardsByName("bang");
            List<Card> p2Bangs = p2.getCardsByName("bang");
            
            if(p1Bangs.size() > p2Bangs.size()) {
                p2.modifyLifePoints(-1);
            }
            else if(p2Bangs.size() > p1Bangs.size()) {
                p1.modifyLifePoints(-1);
            }
        });
        
        List<Player> others = new ArrayList<>(table.getPlayers());
        others.remove(p1);
        table.choosePlayer(others.stream().collect(Collectors.toSet()));
    }
}
