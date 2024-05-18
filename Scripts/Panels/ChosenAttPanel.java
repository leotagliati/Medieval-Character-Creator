package Scripts.Panels;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public final class ChosenAttPanel {
    public JTextField chosenNameField, chosenClassField, chosenGenderField;
    private ArrayList<JTextField> chosenTexts = new ArrayList<JTextField>();
    private JPanel chosenPanel = new JPanel();

    
    private ChosenAttPanel()
    {
        this.chosenNameField = new JTextField();
        this.chosenGenderField = new JTextField();
        this.chosenClassField = new JTextField();
        
        this.chosenPanel.setBounds(400, 150, 300, 500);
        this.chosenPanel.setBackground(Color.BLUE);
        this.chosenPanel.setLayout(null);
        
        this.chosenTexts.add(chosenNameField);
        this.chosenTexts.add(chosenGenderField);
        this.chosenTexts.add(chosenClassField);
        
        for (JTextField text : this.chosenTexts) {
            this.chosenPanel.add(text);
        }
        this.chosenPanel.setVisible(true);
        
        for (int i = 0; i < this.chosenTexts.size(); i++) {
            this.chosenTexts.get(i).setBounds(50, 200 + (i * 60), 200, 50);
        }
    }
    
    public JPanel getPanel() {
        return chosenPanel;
    }
}
