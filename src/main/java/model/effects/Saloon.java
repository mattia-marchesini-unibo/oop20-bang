package model.effects;

import model.Table;

public class Saloon implements Effect {

    int howMuch;
    
    public Saloon(int howMuch) {
        this.howMuch = howMuch;
    }

    @Override
    public void useEffect(Table table) {
        table.getPlayers().forEach(p -> {
            p.modifyLifePoints(howMuch);
        });
    }

}
