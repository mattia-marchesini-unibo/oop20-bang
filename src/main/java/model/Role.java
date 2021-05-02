package model;

public enum Role {
    SHERIFF, DEPUTY, OUTLAW, RENEGADE;
    
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
