package view;

import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuView extends AbstractView implements View {
    
    public MenuView() {
        panel.setLayout(new GridBagLayout());
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        JButton play = new JButton("Play");
        JButton howToPlay = new JButton("How to play");
        JButton quit = new JButton("Quit");
        
        play.addActionListener(e -> {});
        howToPlay.addActionListener(e -> {});
        quit.addActionListener(e -> System.exit(0));
        
        jp.add(play);
        jp.add(howToPlay);
        jp.add(quit);
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        howToPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(jp);
    }

}
