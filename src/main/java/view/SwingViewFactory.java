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
    private ObservableElement<String> changeScreenObservable;
    
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
                    List<Integer> options = List.of(4, 5, 6, 7);
                    Optional<Integer> playerNum = Optional.ofNullable((Integer) JOptionPane.showInputDialog(frame, "Insert the number of players:",
                                                                                                "Choose players", JOptionPane.PLAIN_MESSAGE, null,
                                                                                                options.toArray(), options.get(0)));
                    if(playerNum.isPresent()) {
                        obs.set(playerNum.get());
                        changeView("game");
                    }
                });
                howToPlay.addActionListener(e -> changeView("rules"));
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
                back.addActionListener(e -> changeView("start"));
                
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
    public View getGameView(GameViewObservables observables) {
        return new AbstractView(frame) {
            
            private JPanel playersPanel;
            private JPanel currentPlayerPanel;
            private JPanel cardsPanel;
            private JPanel blueCardsPanel;
            private JButton endTurn;
            private JTextArea currentPlayerStats;
            
            @Override
            public void initView() {
                /*
                 * Set general view properties
                 */
                panel.setLayout(new BorderLayout());
                playersPanel = new JPanel();
                currentPlayerPanel = new JPanel();
                currentPlayerPanel.setLayout(new BoxLayout(currentPlayerPanel, BoxLayout.Y_AXIS));
                cardsPanel = new JPanel();
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
                        observables.getAction().set("endTurn");
                    }
                });
                
                /*
                 * Add observers
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
                        jb.addActionListener(e -> {
                            List<String> options = List.of("Play", "Discard", "Cancel");
                            int choice = JOptionPane.showOptionDialog(frame, "Do you want to play or discard this card?", "Choose",
                                                                      JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                                                      options.toArray(), options.get(0));
                            if (choice == 0) {
                                observables.getAction().set("Play");
                            } else if (choice == 1) {
                                observables.getAction().set("Discard");
                            }
                        });
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
                
                /*
                 * Compose view
                 */
                currentPlayerPanel.add(new JLabel("Your cards in play:"));
                currentPlayerPanel.add(blueCardsPanel);
                currentPlayerPanel.add(new JLabel("Your cards in hand:"));
                currentPlayerPanel.add(cardsScrollPane);
                currentPlayerPanel.add(endTurn);
                panel.add(playersPanel, BorderLayout.NORTH);
                panel.add(currentPlayerPanel, BorderLayout.SOUTH);
            }
            
        };
    }

    @Override
    public View getEndGameView(ObservableElement<List<String>> winners) {
        return new AbstractView(frame) {
            
            @Override
            public void initView() {
                panel.setLayout(new GridBagLayout());
                JPanel jp = new JPanel();
                jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
                JLabel gameOverLabel = new JLabel("GAME OVER!");
                StringBuilder builder = new StringBuilder("Player" + (winners.get().size() > 1 ? "s " : " "));
                
                winners.get().forEach(w -> {
                    if(winners.get().indexOf(w) != 0) {
                        builder.append(", ");
                    }
                    builder.append(w);
                });
                builder.append(" won the game!");
                JLabel winnersLabel = new JLabel(builder.toString());
                
                gameOverLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
                winnersLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
                jp.add(gameOverLabel);
                jp.add(winnersLabel);
                panel.add(jp);
            }
        };
    }
    
    public ObservableElement<String> getChangeScreenObservable(){
        return this.changeScreenObservable;
    }
    
    public void changeView(final String s) {
        this.changeScreenObservable.set(s);
    }
    
    public static void main(String[] args) {
        var factory = new SwingViewFactory();
        // factory.getEndGameView(new ObservableElement<List<String>>(List.of("Player1", "Player2")));
        factory.getGameView(new GameViewObservables(new ObservableElement<String>("Char"), new ObservableElement<String>("Role"),
                                                    new ObservableElement<Integer>(4), new ObservableElement<List<String>>(List.of("Card")),
                                                    new ObservableElement<List<String>>(List.of("Blue")),
                                                    new ObservableElement<List<String>>(List.of("Boh")),
                                                    new ObservableElement<List<Integer>>(List.of(1)),
                                                    new ObservableElement<List<List<String>>>(List.of(List.of("Card"))),
                                                    new ObservableElement<String>("Azione")));
    }
}
