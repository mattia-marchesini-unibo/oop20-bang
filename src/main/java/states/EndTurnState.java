package model;

public class EndTurnState implements State {

    private Table table;
    
    public EndTurnState(final Table table) {
        this.table = table;
    }
    
    @Override
    public void handle() {
        this.table.setCurrentPlayer(this.table.getNextPlayer());
        this.table.setState(new DrawCardsState(this.table));
    }

}
