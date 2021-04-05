package view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import libs.observe.ObservableElement;

public interface View {
    
    JPanel getPanel();
    
    ObservableElement<String> getChangeScreenObservable();

    void show(final JPanel parentPanel, final CardLayout parentLayout, final String viewName);
}
