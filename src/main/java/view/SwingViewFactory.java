package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Optional;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import libs.observe.ObservableElement;
import libs.resources.Resources;
//import model.Player;
import view.components.SubView;

public class SwingViewFactory implements ViewFactory {
    
    private JFrame frame = new JFrame("BANG!");
    
    @Override
    public View getMenuView(final ObservableElement<Integer> obs) {
        return new AbstractView(frame) {
            
            @Override
            public void initView() {
                panel.setLayout(new GridBagLayout());
                JPanel jp = new JPanel();
                jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
                JButton play = new JButton("Play");
                JButton howToPlay = new JButton("How to play");
                JButton quit = new JButton("Quit");
                
                play.addActionListener(e -> {
                    List<Integer> possibilities = List.of(4, 5, 6, 7);
                    Optional<Integer> playerNum = Optional.ofNullable((Integer) JOptionPane.showInputDialog(frame, "Insert the number of players:",
                                                                                                "Choose players", JOptionPane.PLAIN_MESSAGE, null,
                                                                                                possibilities.toArray(), possibilities.get(0)));
                    if(playerNum.isPresent()) {
                        obs.set(playerNum.get());
                    }
                    changeView("GameView");
                });
                howToPlay.addActionListener(e -> changeView("RulesView"));
                quit.addActionListener(e -> System.exit(0));
                
                jp.add(play);
                jp.add(howToPlay);
                jp.add(quit);
                play.setAlignmentX(Component.CENTER_ALIGNMENT);
                howToPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
                quit.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(jp);
            }
        };
    }

    @Override
    public View getRulesView() {
        return new AbstractView(frame) {
            
            private static final String ROLES_FILENAME = "files/Rules_Roles.txt";
            private static final String BROWN_FILENAME = "files/Rules_BrownCards.txt";
            private static final String BLUE_FILENAME = "files/Rules_BlueCards.txt";
            
            @Override
            public void initView() {
                JPanel south = new JPanel();
                panel.setLayout(new BorderLayout());
                JTextArea text = new JTextArea();
                text.setEditable(false);
                JButton showRoles = new JButton("Roles");
                JButton showBrown = new JButton("Brown cards");
                JButton showBlue = new JButton("Blue cards");
                JButton back = new JButton("Back");
                
                showRoles.addActionListener(e -> {
                    text.setText(Resources.readFile(ROLES_FILENAME));
                    showRoles.setEnabled(false);
                    showBrown.setEnabled(true);
                    showBlue.setEnabled(true);
                });
                showBrown.addActionListener(e -> {
                    text.setText(Resources.readFile(BROWN_FILENAME));
                    showRoles.setEnabled(true);
                    showBrown.setEnabled(false);
                    showBlue.setEnabled(true);
                });
                showBlue.addActionListener(e -> {
                    text.setText(Resources.readFile(BLUE_FILENAME));
                    showRoles.setEnabled(true);
                    showBrown.setEnabled(true);
                    showBlue.setEnabled(false);
                });
                back.addActionListener(e -> changeView("MenuView"));
                
                showRoles.setEnabled(false);
                text.setText(Resources.readFile(ROLES_FILENAME));
                
                south.add(showRoles);
                south.add(showBrown);
                south.add(showBlue);
                south.add(back);
                panel.add(text, BorderLayout.CENTER);
                panel.add(south, BorderLayout.SOUTH);
            }
        };
    }

    @Override
    public View getGameView(final SubView currentPlayer, final SubView players) {
        return new AbstractView(frame) {
            
            private JPanel playersPanel;
            private JPanel currentPlayerPanel;
            private JPanel cards;
            
            @Override
            public void initView() {
                panel.setLayout(new BorderLayout());
                playersPanel = new JPanel();
                currentPlayerPanel = new JPanel();
                currentPlayerPanel.setLayout(new BoxLayout(currentPlayerPanel, BoxLayout.Y_AXIS));
                
                cards = new JPanel();
                JScrollPane scrollPane = new JScrollPane(cards);
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                
                currentPlayerPanel.add(scrollPane);
                panel.add(playersPanel, BorderLayout.NORTH);
                panel.add(currentPlayerPanel, BorderLayout.SOUTH);
            }
            /*
            public void updateView(final Player currentPlayer, final List<Player> players) {
                players.forEach(p -> {
                    JTextArea playerStat = new JTextArea();
                    playerStat.setEditable(false);
                    playerStat.append(p.getName());
                    playerStat.append("\nHP: " + p.getLifePoints());
                    if(p.equals(currentPlayer)) {
                        currentPlayerPanel.add(playerStat);
                    } else {
                        playersPanel.add(playerStat);
                    }
                });
                
                currentPlayer.getCards().forEach(c -> {
                    JButton button = new JButton();
                    // add image to button
                    button.addActionListener(e -> c.getEffects());
                });
            }*/
        };
    }
    
    public static void main(String[] args) {
        SwingViewFactory f = new SwingViewFactory();
        f.getMenuView(null);
    }

}
