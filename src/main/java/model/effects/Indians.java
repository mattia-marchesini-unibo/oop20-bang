package model.effects;

import java.util.ArrayList;
import java.util.List;

import model.Card;
import model.Player;
import model.Table;

public class Indians implements Effect {

    @Override
    public void useEffect(Table table) {
        List<Player> others = new ArrayList<>(table.getPlayers());
        others.remove(0);
        
        others.forEach(p -> {
            List<Card> bangs = p.getCardsByName("bang");
            if(bangs.isEmpty()) {
                p.modifyLifePoints(-1);
            }
            else {
                p.removeCard(bangs.get(0));
            }
        });
    }

}
