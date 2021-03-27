package model;

public class ActionsState implements State{

    private Table table;
    
    public ActionsState(final Table table) {
        this.table = table;
    }
    
    @Override
    public void handle() {
        // TODO
        //this.table.action(action, targets);  <- questo non so bene come farlo, dovremo consultarci
        this.table.setState(new EndTurnState(this.table));
    }
    
}
