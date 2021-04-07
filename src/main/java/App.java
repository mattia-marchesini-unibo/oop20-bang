import controller.Controller;

public class App {

    public static void main(String[] args) {
        Controller c = new Controller(new SwingViewFactory());
        c.start();
    }
}
