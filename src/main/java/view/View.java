package view;

import libs.observe.ObservableElement;

public interface View {
    
    /**
     * @return an {@link} @ObservableElement
     */
    ObservableElement<String> getChangeScreenObservable();
    
    /**
     * Shows the specified view
     * @param s the identifier of the view to show 
     */
    void changeView(final String s);

    /**
     * Shows the current view
     */
    void show();
}
