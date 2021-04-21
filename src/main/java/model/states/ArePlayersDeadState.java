package model.states;

import model.GameStateMachine;
import model.Role;
import model.Table;

public class ArePlayersDeadState implements State {

    @Override
    public void handle(GameStateMachine gsMachine) {
        Table table = gsMachine.getTable();
        table.getPlayers().forEach(p -> {
            if(p.getLifePoints() == 0) {
                table.removePlayer(p);
                if(p.getRole() == Role.SHERIFF) {
                    // table.sheriffIsDead();           metodo per modificare la variabile sheriffIsDead
                } else if(p.getRole().equals(Role.OUTLAW) || p.getRole().equals(Role.RENEGADE)) {
                    // table.outlawIsDead();            metodo per diminuire di 1 la variabile countOutlaws
                }
                if(table.isOver()) {
                    gsMachine.setCurrentState(new EndGameState());
                }
            } else {
                gsMachine.setCurrentState(new ChooseCardsState());
            }
        });
        
    }

}
