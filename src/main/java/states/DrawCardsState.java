package model;

public class DrawCardsState implements State{

    private static final int N_CARDS = 2;
    private Table table;
    
    public DrawCardsState(final Table table) {
        this.table = table;
    }
    
    @Override
    public void handle() {
        this.table.drawCards(N_CARDS);
        this.table.setState(new ActionsState(this.table));
    }

}
