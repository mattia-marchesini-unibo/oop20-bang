package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import libs.resources.Resources;

public class RulesView extends AbstractView implements View {

    private static final String ROLES_FILENAME = "files/Rules_Roles.txt";
    private static final String BROWN_FILENAME = "files/Rules_BrownCards.txt";
    private static final String BLUE_FILENAME = "files/Rules_BlueCards.txt";
    
    JButton showRoles = new JButton("Roles");
    JButton showBrown = new JButton("Brown cards");
    JButton showBlue = new JButton("Blue cards");
    JTextArea text = new JTextArea();
    
    public RulesView() {
        JPanel south = new JPanel();
        panel.setLayout(new BorderLayout());
        text.setEditable(false);
        
        showRoles.addActionListener(e -> {
            writeText(ROLES_FILENAME);
            showRoles.setEnabled(false);
            showBrown.setEnabled(true);
            showBlue.setEnabled(true);
        });
        showBrown.addActionListener(e -> {
            writeText(BROWN_FILENAME);
            showRoles.setEnabled(true);
            showBrown.setEnabled(false);
            showBlue.setEnabled(true);
        });
        showBlue.addActionListener(e -> {
            writeText(BLUE_FILENAME);
            showRoles.setEnabled(true);
            showBrown.setEnabled(true);
            showBlue.setEnabled(false);
        });
        
        showRoles.setEnabled(false);
        writeText(ROLES_FILENAME);
        
        south.add(showRoles);
        south.add(showBrown);
        south.add(showBlue);
        panel.add(text, BorderLayout.CENTER);
        panel.add(south, BorderLayout.SOUTH);
    }
    
    private void writeText(final String filename) {
        text.setText(Resources.readFile(filename));
    }
}
