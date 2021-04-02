package libs;

import java.util.List;

public class ObserverElement <y> {
	private y element;
	private List<IObserver> observers ;
    
	public y getElement() {
		return element;
	}

	public void setElement(y element) {
		this.element = element;
	}
    public void setNotEqual (y element) {
    	this.element = element;
    }
    public void setNoNotify (y element) {
    	this.element = element;
    }
	public List<IObserver> getObservers() {
		return observers;
	}

	public void setObservers(List<IObserver> observers) {
		this.observers = observers;
	}
	public boolean isEmpty() {
		return observers.isEmpty();
		
	}

	//Da errore??
	@Override 
	public void notify () {
	}
}
