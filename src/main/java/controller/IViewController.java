package controller;

import view.ViewFactory;

@FunctionalInterface
public interface IViewController {

    /**
     * Initialize controller of a single view
     * @param factory
     */
    void setup(final ViewFactory factory);
}
