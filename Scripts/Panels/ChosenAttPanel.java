package Scripts.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChosenAttPanel {
    public static JTextField chosenNameField, chosenClassField, chosenEyes, chosenSkin, chosenPhysic;
    private static JTextField titleName, titleClass;
    private static ArrayList<JTextField> chosenTexts = new ArrayList<JTextField>();
    private static ArrayList<JTextField> titles = new ArrayList<JTextField>();
    private static JPanel chosenPanel = new JPanel();
    private static JPanel backgPanel = new JPanel();

    public static void setupPanel() {
        chosenNameField = new JTextField("Entrada incompleta");
        chosenClassField = new JTextField("Entrada incompleta");
        titleName = new JTextField("Nome: ");
        titleClass = new JTextField("Classe: ");

        GridLayout textLayout = new GridLayout();
        textLayout.setColumns(1);
        textLayout.setRows(2);
        textLayout.setVgap(20);

        GridLayout titleLayout = new GridLayout();
        titleLayout.setColumns(1);
        titleLayout.setRows(2);
        titleLayout.setVgap(20);

        chosenPanel.setBounds(630, 200, 300, 200);
        chosenPanel.setBackground(Color.BLUE);
        chosenPanel.setOpaque(false);
        chosenPanel.setLayout(textLayout);

        backgPanel.setBounds(400, 200, 300, 200);
        backgPanel.setBackground(Color.GREEN);
        backgPanel.setOpaque(false);
        backgPanel.setLayout(titleLayout);

        chosenTexts.add(chosenNameField);
        chosenTexts.add(chosenClassField);

        backgPanel.add(titleName);
        backgPanel.add(titleClass);

        for (JTextField text : chosenTexts) {
            chosenPanel.add(text);
        }
        backgPanel.setVisible(true);
        chosenPanel.setVisible(true);

        titles.add(titleName);
        titles.add(titleClass);
        for (JTextField titles : titles) {
            titles.setEditable(false);
            titles.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 40));
            titles.setHorizontalAlignment(JTextField.CENTER);
            titles.setOpaque(false);
            titles.setForeground(Color.WHITE);
            titles.setBorder(null);
        }
        for (int i = 0; i < chosenTexts.size(); i++) {
            chosenTexts.get(i).setEditable(false);
            chosenTexts.get(i).setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 30));
            chosenTexts.get(i).setHorizontalAlignment(JTextField.LEFT);
            chosenTexts.get(i).setOpaque(false);
            chosenTexts.get(i).setBorder(null);
        }
        chosenNameField.setForeground(Color.RED);
        chosenClassField.setForeground(Color.RED);
    }

    public static JPanel getPanel() {
        return chosenPanel;
    }

    public static JPanel getBackgPanel() {
        return backgPanel;
    }

    public static void updatePanel(String nameChosen, String classChosen) {
        // System.out.println("name:" + nameChosen);
        // System.out.println("class:" + classChosen);
        if (classChosen.equals("Entrada incompleta")) {
            if (nameChosen.equals("Entrada incompleta") || nameChosen.equals(null)) {
                chosenNameField.setText("Entrada incompleta");
                chosenNameField.setForeground(Color.RED);

            } else {
                chosenNameField.setText(nameChosen);
                chosenNameField.setForeground(Color.WHITE);
            }
            chosenClassField.setText(classChosen);
            chosenClassField.setForeground(Color.RED);
        } else {
            if (nameChosen.equals("Entrada incompleta") || nameChosen.equals(null)) {
                chosenNameField.setText("Entrada incompleta");
                chosenNameField.setForeground(Color.RED);

            } else {
                chosenNameField.setText(nameChosen);
                chosenNameField.setForeground(Color.WHITE);
            }
            chosenClassField.setText(classChosen);
            chosenClassField.setForeground(Color.WHITE);
        }
    }

}
