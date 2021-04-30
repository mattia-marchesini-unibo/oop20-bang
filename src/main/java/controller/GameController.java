package controller;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import libs.observe.ObservableElement;
import model.GameStateMachine;
import model.Player;
import model.SimpleTable;
import model.Table;
import model.deck.Deck;
import model.states.StartTurnState;
import view.CurrentPlayerInfo;
import view.GameViewObservables;
import view.PlayerInfo;
import view.View;
import view.ViewFactory;

public class GameController {

    private GameStateMachine gsMachine;
    private ObservableElement<String> changeSceneObs;
    private List<String> winners;
    private GameViewObservables gameObs;
    private List<Player> allPlayers;

    private Map<String, Runnable> gsMachineMessages = new HashMap<String, Runnable>(
        Map.ofEntries(entry("playedCard", () -> {
            drawTable();
        }), entry("startTurn", () -> {
            drawTable();
        }), entry("endTurn", () -> {
            // this.gameObs.getCharacter().set(null);
            // List<Player> others = new ArrayList<>(this.gsMachine.getTable().getPlayers());
            // this.gameObs.getOtherPlayers()
            // .set(others.subList(1, others.size()).stream().map(p -> getPlayerName(p)).collect(Collectors.toList()));
        }), entry("chooseCards", () -> {
        }), entry("end", () -> {
            this.winners.addAll(
                gsMachine.getTable().getPlayers().stream().map(p -> getPlayerName(p)).collect(Collectors.toList()));
            changeSceneObs.set("end");
        })));

    public GameController(int numberOfPlayers, List<String> winners) {
        winners.clear();
        this.winners = winners;

        this.gsMachine = new GameStateMachine(new SimpleTable(new Deck(), numberOfPlayers));
        var obs = this.gsMachine.getMessageObservable();
        obs.addObserver(() -> {
            if (this.gsMachineMessages.containsKey(obs.get())) {
                this.gsMachineMessages.get(obs.get()).run();
            }
        });

        this.allPlayers = new ArrayList<>(this.gsMachine.getTable().getPlayers());
        this.gameObs = new GameViewObservables();

        this.gameObs.getAction().addObserver(() -> {
            this.gsMachine.setTurnMessage(this.gameObs.getAction().get());
        });
        
        drawTable();
    }

    public void setup(ViewFactory factory) {
        this.changeSceneObs = factory.getChangeScreenObservable();
        View view = factory.getGameView(this.gameObs);

        this.gsMachine.setCurrentState(new StartTurnState());
        view.show();
        this.gsMachine.go();
    }

    private String getPlayerName(Player player) {
        return "player " + Integer.toString(allPlayers.indexOf(player));
    }

    private List<Player> getOthers() {
        Table table = this.gsMachine.getTable();
        Player current = table.getCurrentPlayer();
        List<Player> others = new ArrayList<>(table.getPlayers());
        others.remove(current);
        return others;
    }

    private void drawTable() {
        Player current = this.gsMachine.getTable().getCurrentPlayer();
        var others = getOthers();
        
        this.gameObs.setCurrentPlayer(new CurrentPlayerInfo(
                this.getPlayerName(current),
                current.getLifePoints(),
                current.getRole().toString(),
                current.getActiveCards().stream().map(c -> c.getRealName()).collect(Collectors.toList())));
        this.gameObs.getCurrentPlayer().get().getHand().set(current.getCards().stream().map(c -> c.getRealName()).collect(Collectors.toList()));
        List<PlayerInfo> otherPlayers = new ArrayList<>();
        others.forEach(p -> otherPlayers.add(new PlayerInfo(
                this.getPlayerName(p),
                p.getLifePoints(),
                p.getRole().toString(),
                p.getActiveCards().stream().map(c -> c.getRealName()).collect(Collectors.toList())
            ))
        );
        this.gameObs.setOtherPlayers(otherPlayers);
    }
}
