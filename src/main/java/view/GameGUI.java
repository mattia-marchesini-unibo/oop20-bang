package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.deck.IDeck;

public class GameGUI {
    
    private static final double PROPORTION = 1.5;
    private static final String MENU_NAME = "Menu";
    private static final String RULES_NAME = "Rules";
    private static final String GAME_NAME = "Game";
    /*
     * Main components
     */
    private JFrame frame = new JFrame("BANG!");
    private JPanel mainPanel = new JPanel();
    private CardLayout layout = new CardLayout();
    private ViewFactory factory = new SwingViewFactory();
    
    public GameGUI(final int playerNum, final IDeck deck) {
        /*
         * Set frame properties
         */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        mainPanel.setLayout(layout);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) (dim.getWidth() / PROPORTION), (int) (dim.getHeight() / PROPORTION));
        /*
         * Add views
         */
        View menuView = factory.getMenuView();
        View rulesView = factory.getRulesView();
        View gameView = factory.getGameView(playerNum, deck);
        mainPanel.add(menuView.getPanel(), MENU_NAME);
        mainPanel.add(rulesView.getPanel(), RULES_NAME);
        mainPanel.add(gameView.getPanel(), GAME_NAME);
        /*
         * Set visible
         */
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }
}
