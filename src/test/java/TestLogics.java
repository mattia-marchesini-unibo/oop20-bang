import org.junit.Test;

import libs.CircularList;
import model.GameStateMachine;
import model.Logics;
import model.Player;
import model.Role;
import model.SimplePlayer;
import model.SimpleTable;
import model.Table;
import model.TurnObservable;
import model.card.Card;
import model.deck.IDeck;
import model.effects.Effect;
import model.states.CheckDeadPlayersState;
import model.states.ChooseActionState;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestLogics {
    
    private static final List<Role> roles = List.of(
            Role.SHERIFF, Role.RENEGADE, Role.OUTLAW, Role.OUTLAW, Role.DEPUTY, Role.OUTLAW, Role.DEPUTY);
    
    public List<Role> getRolesForPlayers(final int n){
        return roles.subList(0, n);
    }
    
    public static void main(String[] args) {
        CircularList<Player> list = new CircularList<>();
        Player p = new SimplePlayer(Role.SHERIFF, "HDavi");
        list.add(p);
        var tab = new SimpleTable(null, list);
        var g = new GameStateMachine(tab);
        g.setCurrentState(new CheckDeadPlayersState());
        g.setMessage("PlayCard");
        p.modifyLifePoints(-5);
        List<Player> dead = tab.getPlayers().stream()
                .filter(p1 -> p1.getLifePoints() == 0)
                .collect(Collectors.toList());
        System.out.println("Vuoto: " + dead.isEmpty());
        System.out.println(p.getLifePoints());
        g.go();
        System.out.println(g.getCurrentState().toString());
    }
}