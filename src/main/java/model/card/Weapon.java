package model.card;

import model.Table;
import model.effects.Effect;

public class Weapon implements Effect {

    private int range;

    public Weapon(int range) {
        this.range = range;
    }

    @Override
    public void useEffect(Table table) {
        table.getCurrentPlayer().modifySight(range);
    }
}
