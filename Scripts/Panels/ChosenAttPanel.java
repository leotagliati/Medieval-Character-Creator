package Scripts.Panels;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChosenAttPanel{
    public static JTextField chosenNameField, chosenClassField, chosenGenderField, chosenEyes, chosenSkin, chosenPhysic;
    private static ArrayList<JTextField> chosenTexts = new ArrayList<JTextField>();
    private static JPanel chosenPanel = new JPanel();

    public static void setupPanel()
    {
        chosenNameField = new JTextField();
        chosenGenderField = new JTextField();
        chosenClassField = new JTextField();
        chosenPanel.setBounds(500, 150, 350, 500);
        chosenPanel.setBackground(Color.BLUE);
        chosenPanel.setLayout(null);
        
        chosenTexts.add(chosenNameField);
        chosenTexts.add(chosenGenderField);
        chosenTexts.add(chosenClassField);
        
        for (JTextField text : chosenTexts) {
            chosenPanel.add(text);
        }
        chosenPanel.setVisible(true);
        
        for (int i = 0; i < chosenTexts.size(); i++) {
            chosenTexts.get(i).setBounds(120, 20+ (i * 60), 200, 50);
            chosenTexts.get(i).setEditable(false);
        }
    }
    public static JPanel getPanel() {
        return chosenPanel;
    }
    public static void updatePanel(String nameChosen, String genderChosen, String classChosen)
    {
        chosenNameField.setText(nameChosen);
        chosenGenderField.setText(genderChosen);
        chosenClassField.setText(classChosen);
    }
    
}
