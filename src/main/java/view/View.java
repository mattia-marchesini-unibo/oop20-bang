package view;

import libs.observe.ObservableElement;

public interface View {
    
    /**
     * @return an {@link} @ObservableElement
     */
    ObservableElement<String> getChangeScreenObservable();
    
    /**
     * Changes the displayed view
     * @param s
     */
    void changeView(final String s);

    /**
     * Shows the current view
     */
    void show();
}
