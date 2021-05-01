package model.effects;

import java.util.List;

import model.Player;
import model.Table;
import model.TurnObservable;
import model.card.Card;

public class Duel implements Effect {

    @Override
    public void useEffect(Table table) {
        Player p1 = table.getCurrentPlayer();
        TurnObservable<List<Player>> ob = table.getChoosePlayersObservable();

        ob.addObserver(() -> {
            Player p2 = ob.get().get(0);
            
            List<Card> p1Bangs = p1.getCardsByName("bang");
            List<Card> p2Bangs = p2.getCardsByName("bang");
            
            if(p1Bangs.size() > p2Bangs.size()) {
                p2.modifyLifePoints(-1);
            }
            else if(p2Bangs.size() > p1Bangs.size()) {
                p1.modifyLifePoints(-1);
            }
        });
        
        table.choosePlayers();
    }
}
