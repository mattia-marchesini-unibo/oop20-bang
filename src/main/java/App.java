import controller.Controller;
import view.SwingViewFactory;

public class App {

    public static void main(String[] args) {
        System.out.println("ciao");
        Controller c = new Controller(new SwingViewFactory());
        c.start();
    }
}
