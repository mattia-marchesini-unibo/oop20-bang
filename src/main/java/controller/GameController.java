package controller;

public class GameController implements IViewController {

    @Override
    public void setup(IViewFactory factory) {
        v = factory.getGameView();
        
    }

}
