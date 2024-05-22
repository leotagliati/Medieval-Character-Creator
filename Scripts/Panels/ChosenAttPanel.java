package Scripts.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChosenAttPanel {
    public static JTextField nameInput, classInput, chosenEyes, chosenSkin, chosenPhysic;
    private static JTextField nameTitle, classTitle;
    private static ArrayList<JTextField> chosenAttArray = new ArrayList<JTextField>();
    private static ArrayList<JTextField> titlesTextArray = new ArrayList<JTextField>();
    private static JPanel chosenPanel = new JPanel();
    private static JPanel backGNDPanel = new JPanel();

    public static void setupPanel() {
        // Inicializa os Textos
        nameTitle = new JTextField("Nome: ");
        nameInput = new JTextField("Entrada incompleta");
        classTitle = new JTextField("Classe: ");
        classInput = new JTextField("Entrada incompleta");

        GridLayout inputTextLayout = new GridLayout();
        inputTextLayout.setColumns(1);
        inputTextLayout.setRows(2);
        inputTextLayout.setVgap(20);

        GridLayout titleLayout = new GridLayout();
        titleLayout.setColumns(1);
        titleLayout.setRows(2);
        titleLayout.setVgap(20);

        // Set propriedade do painel dos inputs
        chosenPanel.setBounds(630, 200, 300, 200);
        chosenPanel.setBackground(Color.BLUE);
        chosenPanel.setOpaque(false);
        chosenPanel.setLayout(inputTextLayout);

        // Set propriedade do painel de fundo
        backGNDPanel.setBounds(400, 200, 300, 200);
        backGNDPanel.setBackground(Color.GREEN);
        backGNDPanel.setOpaque(false);
        backGNDPanel.setLayout(titleLayout);

        chosenAttArray.add(nameInput);
        chosenAttArray.add(classInput);

        backGNDPanel.add(nameTitle);
        backGNDPanel.add(classTitle);

        for (JTextField text : chosenAttArray) {
            chosenPanel.add(text);
        }
        backGNDPanel.setVisible(true);
        chosenPanel.setVisible(true);

        titlesTextArray.add(nameTitle);
        titlesTextArray.add(classTitle);

        // Set propriedade dos titulos
        for (JTextField titles : titlesTextArray) {
            titles.setEditable(false);
            titles.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 40));
            titles.setHorizontalAlignment(JTextField.CENTER);
            titles.setOpaque(false);
            titles.setForeground(Color.WHITE);
            titles.setBorder(null);
        }

        // Set propriedade dos inputs
        for (int i = 0; i < chosenAttArray.size(); i++) {
            chosenAttArray.get(i).setEditable(false);
            chosenAttArray.get(i).setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 30));
            chosenAttArray.get(i).setHorizontalAlignment(JTextField.LEFT);
            chosenAttArray.get(i).setOpaque(false);
            chosenAttArray.get(i).setBorder(null);
        }
        
        nameInput.setForeground(Color.RED);
        classInput.setForeground(Color.RED);
    }

    public static JPanel getPanel() {
        return chosenPanel;
    }

    public static JPanel getBackGNDPanel() {
        return backGNDPanel;
    }

    public static void updatePanel(String nameChosen, String classChosen) {
        // System.out.println("name:" + nameChosen);
        // System.out.println("class:" + classChosen);
        if (classChosen.equals("Entrada incompleta")) {
            if (nameChosen.equals("Entrada incompleta") || nameChosen.equals(null)) {
                nameInput.setText("Entrada incompleta");
                nameInput.setForeground(Color.RED);

            } else {
                nameInput.setText(nameChosen);
                nameInput.setForeground(Color.WHITE);
            }
            classInput.setText(classChosen);
            classInput.setForeground(Color.RED);
        } else {
            if (nameChosen.equals("Entrada incompleta") || nameChosen.equals(null)) {
                nameInput.setText("Entrada incompleta");
                nameInput.setForeground(Color.RED);

            } else {
                nameInput.setText(nameChosen);
                nameInput.setForeground(Color.WHITE);
            }
            classInput.setText(classChosen);
            classInput.setForeground(Color.WHITE);
        }
    }

}
