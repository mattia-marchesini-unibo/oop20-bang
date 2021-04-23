package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

import libs.observe.ObservableElement;
import model.GameStateMachine;
import model.Player;
import view.View;
import view.ViewFactory;

public class Controller {

    private ViewFactory factory;
    private int numberOfPlayers;
    ObservableElement<String> changeSceneObs = new ObservableElement<>();

    private Map<String, IViewController> controllers = new HashMap<>(Map.ofEntries(
        entry("start", (fct) -> {
//            View v = fct.getStartView();
//            v.show();
        }),
        entry("newGame", (fct) -> {
//            View v = fct.getNewGameView();
//            v.show();
        }),
        entry("game", (IViewController)new GameController(numberOfPlayers))
    ));

    public Controller(ViewFactory factory) {
        this.factory = factory;
        this.factory.setChangeSceneObservable(this.changeSceneObs);

        changeSceneObs.addObserver(() -> {
            controllers.get(changeSceneObs.get()).setup(this.factory);
        });
    }

    public void start() {
        this.changeSceneObs.set("start");
    }
}
