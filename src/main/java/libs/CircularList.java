package libs;

import java.util.ArrayList;

public class CircularList<X> extends ArrayList<X> {
    
    private static final long serialVersionUID = 7770028322718010907L;
    private int currentIndex = 0;
    private X currentElement = this.get(this.currentIndex);
    
    public int getCurrentIndex() {
        return this.currentIndex;
    }
    
    public X getCurrentElement() {
        return this.currentElement;
    }
    
    public X getNext() {
        if(this.currentIndex == this.size() - 1) {
            currentElement = this.get(0);
        } else {
            currentIndex++;
            currentElement = this.get(this.currentIndex);
        }
        return this.currentElement;
    }
}