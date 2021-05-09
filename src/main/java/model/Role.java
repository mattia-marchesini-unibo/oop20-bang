package model;

/**
 * An enum defining the role of a player.
 * 
 * @author Davide Merli
 *
 */
public enum Role {
    SHERIFF, DEPUTY, OUTLAW, RENEGADE;
    
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
