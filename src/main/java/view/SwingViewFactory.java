package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Optional;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import libs.observe.IObserver;
import libs.observe.ObservableElement;
import libs.resources.Resources;

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
                        changeView("GameView");
                    }
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
    public View getGameView(final GameViewObservables observables) {
        return new AbstractView(frame) {
            
            private JPanel playersPanel;
            private JPanel currentPlayerPanel;
            private JPanel cardsPanel;
            private JPanel blueCardsPanel;
            private JButton endTurn;
            private GameViewObservables observables;
            private JTextArea currentPlayerStats;
            
            @Override
            public void initView() {
                panel.setLayout(new BorderLayout());
                playersPanel = new JPanel();
                currentPlayerPanel = new JPanel();
                currentPlayerPanel.setLayout(new BoxLayout(currentPlayerPanel, BoxLayout.Y_AXIS));
                blueCardsPanel = new JPanel();
                
                JScrollPane cardsScrollPane = new JScrollPane(cardsPanel);
                cardsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                cardsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                
                currentPlayerStats = new JTextArea();
                currentPlayerStats.setEditable(false);
                
                endTurn = new JButton("End turn");
                endTurn.addActionListener(e -> {
                    int cardsToDiscard = observables.getHand().get().size() - observables.getLifePoints().get();
                    if(cardsToDiscard > 0) {
                        JOptionPane.showMessageDialog(null, "You must discard " + cardsToDiscard + (cardsToDiscard == 1 ? "card" : "cards"),
                                                      "Discard cards", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        observables.getTurn().notifyObservers();
                    }
                });
                /*
                 * Observers
                 */
                IObserver currentPlayerObs = () -> {
                    currentPlayerStats.setText("Name: " + observables.getCharacter().get());
                    currentPlayerStats.append("\nHP: " + observables.getLifePoints().get());
                    currentPlayerStats.append("\nRole: " + observables.getRole().get());
                };
                IObserver playersObs = () -> {
                    playersPanel.removeAll();
                    for(int i = 0; i < observables.getOtherPlayers().get().size(); i++) {
                        JPanel jp = new JPanel();
                        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
                        
                        JTextArea text = new JTextArea();
                        text.setEditable(false);
                        text.append("Name: " + observables.getOtherPlayers().get().get(i));
                        text.append("\nHP: " + observables.getOtherLifePoints().get());
                        jp.add(text);
                        
                        observables.getOtherBlueCards().get().get(i).forEach(c -> {
                            JButton jb = new JButton(c);
                            jp.add(jb);
                        });
                        
                        playersPanel.add(jp);
                    }
                };
                
                observables.getCharacter().addObserver(currentPlayerObs);
                observables.getLifePoints().addObserver(currentPlayerObs);
                observables.getRole().addObserver(currentPlayerObs);
                observables.getHand().addObserver(() -> {
                    cardsPanel.removeAll();
                    observables.getHand().get().forEach(c -> {
                        JButton jb = new JButton(new ImageIcon(ClassLoader.getSystemResource("images/" + c + ".png")));
                        jb.addActionListener(e -> observables.getHand().notifyObservers());
                        cardsPanel.add(jb);
                    });
                });
                observables.getBlueCards().addObserver(() -> {
                    blueCardsPanel.removeAll();
                    observables.getBlueCards().get().forEach(c -> {
                        JButton jb = new JButton(new ImageIcon(ClassLoader.getSystemResource("images/" + c + ".png")));
                        blueCardsPanel.add(jb);
                    });
                });
                observables.getOtherPlayers().addObserver(playersObs);
                observables.getOtherLifePoints().addObserver(playersObs);
                observables.getOtherBlueCards().addObserver(playersObs);
                
                
                currentPlayerPanel.add(new JLabel("Your cards in play:"));
                currentPlayerPanel.add(blueCardsPanel);
                currentPlayerPanel.add(new JLabel("Your cards in hand:"));
                currentPlayerPanel.add(cardsPanel);
                currentPlayerPanel.add(endTurn);
                panel.add(playersPanel, BorderLayout.NORTH);
                panel.add(currentPlayerPanel, BorderLayout.SOUTH);
            }
            
        };
    }
    
}
