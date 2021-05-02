package model.effects;

import model.Table;

public interface Effect {

    void useEffect(Table table);
    
    default boolean isAWeapon() {return false;}
}