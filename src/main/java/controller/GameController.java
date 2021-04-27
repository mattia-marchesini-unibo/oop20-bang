package controller;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import libs.observe.IObservable;
import libs.observe.ObservableElement;
import libs.observe.SimpleObservable;
import model.GameStateMachine;
import model.Player;
import model.SimplePlayer;
import model.Role;
import model.SimpleTable;
import model.deck.Deck;
import model.states.StartTurnState;
import view.GameViewObservables;
import view.View;
import view.ViewFactory;

public class GameController {

    private GameStateMachine gsMachine;
    private ObservableElement<String> changeSceneObs;
    private List<String> winners;
    private GameViewObservables gameObs;
    private List<Player> allPlayers;

    private static final List<Role> totalRoles = List.of(Role.SHERIFF, Role.RENEGADE, Role.OUTLAW, Role.OUTLAW,
        Role.DEPUTY, Role.OUTLAW, Role.OUTLAW);
    private Map<String, Runnable> gsMachineMessages = new HashMap<String, Runnable>(
        Map.ofEntries(entry("playCard", () -> {
        }), entry("startTurn", () -> {
        }), entry("endTurn", () -> {
            // this.gameObs.getCharacter().set(null);
            List<Player> others = new ArrayList<>(this.gsMachine.getTable().getPlayers());
            this.gameObs.getOtherPlayers()
                .set(others.subList(1, others.size()).stream().map(p -> getPlayerName(p)).collect(Collectors.toList()));
        }), entry("chooseCards", () -> {
        }), entry("end", () -> {
            this.winners.addAll(
                gsMachine.getTable().getPlayers().stream().map(p -> getPlayerName(p)).collect(Collectors.toList()));
            changeSceneObs.set("end");
        })));

    public GameController(int numberOfPlayers, ObservableElement<String> changeSceneObs, List<String> winners) {
        this.changeSceneObs = changeSceneObs;
        winners.clear();
        this.winners = winners;

        List<Role> roles = new ArrayList<>(totalRoles.subList(0, numberOfPlayers));
        Collections.shuffle(roles);
        this.allPlayers = roles.stream().map(r -> new SimplePlayer(r, "player " + Integer.toString(roles.indexOf(r))))
            .collect(Collectors.toList());

        this.gsMachine = new GameStateMachine(new SimpleTable(new Deck(), allPlayers));
        var obs = this.gsMachine.getMessageObservable();
        obs.addObserver(() -> this.gsMachineMessages.get(obs.get()).run());

        Player first = this.allPlayers.get(0);
        this.gameObs = new GameViewObservables(new ObservableElement<String>(getPlayerName(first)),
            new ObservableElement<String>(first.getRole().toString()),
            new ObservableElement<Integer>(first.getLifePoints()), new ObservableElement<List<String>>(),
            new ObservableElement<>(),
            new ObservableElement<List<String>>(allPlayers.subList(1, numberOfPlayers).stream()
                .map(p -> getPlayerName(p)).collect(Collectors.toList())),
            new ObservableElement<List<Integer>>(allPlayers.subList(1, numberOfPlayers).stream()
                .map(p -> p.getLifePoints()).collect(Collectors.toList())),
            new ObservableElement<List<List<String>>>(), new ObservableElement<String>());

        this.gameObs.getAction().addObserver(() -> {
            this.gsMachine.setMessage(this.gameObs.getAction().get());
        });
    }

    public void setup(ViewFactory factory) {
        View view = factory.getGameView(this.gameObs);
        // var obs = view.getChangeScreenObservable();
        // obs.addObserver(() -> this.changeSceneObs.set(obs.get()));

        this.gsMachine.setCurrentState(new StartTurnState());
        view.show();
    }

    private String getPlayerName(Player player) {
        return "player " + Integer.toString(allPlayers.indexOf(player));
    }
}
