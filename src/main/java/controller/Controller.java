package controller;

import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

import libs.observe.ObservableElement;
import model.GameStateMachine;

public class Controller {

    private IViewFactory factory;

    private static Map<String, IViewController> controllers = new HashMap<>(Map.ofEntries(
        entry("start", (fct) -> {
            IView v = fct.getStartView();
            v.show();
        }),
        entry("newGame", (fct) -> {
            IView v = fct.getNewGameView();
            v.show();
        }),
        entry("game", (fct) -> {
            IView v = fct.getGameView(players);
//            GameStateMachine machine = new GameStateMachine(new Table());
            v.show();
        })
    ));;

    ObservableElement<String> changeSceneObs = new ObservableElement<>();

//    private ObservableElement<Integer> players = new ObservableElement<>();

    public Controller(IViewFactory factory) {
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
