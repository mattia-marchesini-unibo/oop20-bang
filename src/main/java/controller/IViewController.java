package controller;

import view.ViewFactory;

@FunctionalInterface
public interface IViewController {

    void setup(ViewFactory factory);
}
