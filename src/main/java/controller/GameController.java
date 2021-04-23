package controller;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import libs.CircularList;
import libs.observe.ObservableElement;
import model.GameStateMachine;
import model.Player;
import model.SimplePlayer;
import model.Role;
import model.SimpleTable;
import model.deck.Deck;
import view.GameViewObservables;
import view.View;
import view.ViewFactory;

public class GameController {

    private GameStateMachine gsMachine;
    private int numberOfPlayers;
    private ObservableElement<String> changeSceneObs;
    private List<String> winners;

    private static final List<Role> totalRoles = List.of(
        Role.SHERIFF, Role.RENEGADE, Role.OUTLAW, Role.OUTLAW, Role.DEPUTY, Role.OUTLAW, Role.OUTLAW
    );
    private Map<String, Runnable> gsMachineMessages = new HashMap<String, Runnable>(Map.ofEntries(
        entry("playCard", () -> {}),
        entry("endTurn", () -> {}),
        entry("chooseCards", () -> {}),
        entry("end", () -> {
//            winners.addAll(gsMachine.getTable().getPlayers());    TODO: da player a stringhe
            changeSceneObs.set("end");
        })
    ));

    public GameController(int numberOfPlayers, ObservableElement<String> changeSceneObs, List<String> winners) {
        this.numberOfPlayers = numberOfPlayers;
        this.changeSceneObs = changeSceneObs;
        this.winners = winners;
    }

    public void setup(ViewFactory factory) {
        List<Role> roles = totalRoles.subList(0, this.numberOfPlayers);
        Collections.shuffle(roles);
        List<Player> players = roles.stream().map(r -> new SimplePlayer(r, null)).collect(Collectors.toList());
        
        gsMachine = new GameStateMachine(new SimpleTable(new Deck(), new CircularList<Player>(players)));
        
        var viewObs = new GameViewObservables(
            null, null,
            null, null,
            null, null,
            null, null,
            null, null
        );
        View view = factory.getGameView(viewObs);
        
        view.getChangeScreenObservable().addObserver(null);
    }
}
