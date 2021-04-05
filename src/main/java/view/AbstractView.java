package view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import libs.observe.ObservableElement;

public abstract class AbstractView {
    
    protected JPanel panel = new JPanel();
    private ObservableElement<String> changeScreenObservable;
    
    //@Override
    public JPanel getPanel() {
        return this.panel;
    }
    
    //@Override
    public ObservableElement<String> getChangeScreenObservable(){
        return this.getChangeScreenObservable();
    }

    //@Override
    public void show(final JPanel parentPanel, final CardLayout parentLayout, final String viewName) {
        parentLayout.show(parentPanel, viewName);
    }

}
