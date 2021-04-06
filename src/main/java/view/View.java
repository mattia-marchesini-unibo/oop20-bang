package view;

import libs.observe.ObservableElement;

public interface View {
    
    ObservableElement<String> getChangeScreenObservable();

    void show();
}
