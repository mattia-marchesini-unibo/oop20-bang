package libs.observe;

import java.util.ArrayList;
import java.util.List;

public class SimpleObservable implements IObservable {

    List<IObserver> observers = new ArrayList<>();
    
    @Override
    public void addObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void removeAllObservers() {
        this.observers.clear();
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(ob -> ob.update());
    }

}
