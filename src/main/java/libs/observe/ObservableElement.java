package libs.observe;

import java.util.ArrayList;
import java.util.List;

public class ObservableElement<E> implements IObservable {
	private E element = null;
	private List<IObserver> observers = new ArrayList<>();
	
	public ObservableElement(final E element){
	    this.element = element;
	}
    
	public E get() {
		return element;
	}

	public void set(E element) {
		this.element = element;
		this.notifyObservers();
	}

    public void setNotEqual(E element) {
        this.element = element;
    	if(!element.equals(element)) {
    	    this.notifyObservers();
    	}
    }

    public void setNoNotify(E element) {
    	this.element = element;
    }
    
    public boolean isEmpty() {
        return this.element == null;
    }

    @Override
	public void addObserver(IObserver observer) {
		this.observers.add(observer);
	}

    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }
    
	@Override 
	public void notifyObservers() {
	    this.observers.forEach(ob -> ob.update());
	}
}
