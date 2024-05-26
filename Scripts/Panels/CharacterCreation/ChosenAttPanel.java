package Scripts.Panels.CharacterCreation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Scripts.AudioHandler;
import Scripts.ImagesConversion.ImageCreate;
import Scripts.Model.GameCharacter;
import Scripts.Repository.CharacterRepository;

public class ChosenAttPanel {
    public static JTextField nameInput, classInput, eyesInput, skinInput, physicInput;
    private static JTextField nameTitle, classTitle;
    private static ArrayList<JTextField> chosenAttArray = new ArrayList<JTextField>();
    private static ArrayList<JTextField> titlesTextArray = new ArrayList<JTextField>();

    private static JButton saveButton = new JButton("Salvar");

    private static JPanel chosenPanel = new JPanel();
    private static JPanel titlesPanel = new JPanel();
    private static JPanel savePanel = new JPanel();
    private static JPanel saveBackGNDPanel = new JPanel();

    public static void setupPanel() {

        CharacterRepository repo = new CharacterRepository();

        // Inicializa os Textos
        nameTitle = new JTextField("Nome: ");
        nameInput = new JTextField("Entrada incompleta");
        classTitle = new JTextField("Classe: ");
        classInput = new JTextField("Cavaleiro");

        ImageCreate buttonImage = new ImageCreate(450, 500, 300, 100);
        buttonImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        buttonImage.setIconFile("Images\\button.png");
        buttonImage.imageSetter();

        saveButton.setBounds(450, 500, 300, 100);
        saveButton.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 34));
        saveButton.setForeground(Color.WHITE);
        saveButton.setOpaque(true);
        saveButton.setContentAreaFilled(false);
        saveButton.setBorderPainted(false);
        saveButton.setFocusable(false);
        saveButton.setVisible(true);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("name:" + nameInput.getText());
                // System.out.println("class:" + classInput.getText());
                if (!nameInput.getText().equals("Entrada incompleta")) {
                    AudioHandler.audioPlay("Music\\charSaved.wav");
                    saveButton.setText("Salvo!");
                    buttonImage.setIconFile("Images\\charSavedButton.png");
                    buttonImage.imageSetter();
                    // repo.addCharacter(new GameCharacter(nameInput.getText(), classInput.getText(), eyesInput.getText(),
                    //         skinInput.getText(), physicInput.getText()));
                    // funcao de salvar no banco de dados
                } else {
                    AudioHandler.audioPlay("Music\\charNotSaved.wav");
                    saveButton.setText("Insira seu nome!");
                    buttonImage.setIconFile("Images\\charNotSavedButton.png");
                    buttonImage.imageSetter();

                }

            }
        });
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == saveButton) {
                    buttonImage.setIcon(new ImageIcon("Images\\buttonClicked.png"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == saveButton) {
                    saveButton.setText("Salvar");
                    buttonImage.setIcon(new ImageIcon("Images\\button.png"));
                }
            }
        });

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
        chosenPanel.setVisible(true);

        // Set propriedade do painel de fundo
        titlesPanel.setBounds(400, 200, 300, 200);
        titlesPanel.setBackground(Color.GREEN);
        titlesPanel.setOpaque(false);
        titlesPanel.setLayout(titleLayout);
        titlesPanel.setVisible(true);

        savePanel.setBounds(530, 500, 300, 300);
        savePanel.setBackground(Color.YELLOW);
        savePanel.setOpaque(false);
        savePanel.setLayout(titleLayout);
        savePanel.setVisible(true);

        saveBackGNDPanel.setBounds(530, 500, 300, 300);
        saveBackGNDPanel.setBackground(Color.YELLOW);
        saveBackGNDPanel.setOpaque(false);
        saveBackGNDPanel.setLayout(titleLayout);
        saveBackGNDPanel.setVisible(true);

        chosenAttArray.add(nameInput);
        chosenAttArray.add(classInput);

        titlesPanel.add(nameTitle);
        titlesPanel.add(classTitle);

        saveBackGNDPanel.add(buttonImage);
        savePanel.add(saveButton);

        for (JTextField text : chosenAttArray) {
            chosenPanel.add(text);
        }

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
        classInput.setForeground(Color.WHITE);

    }

    public static JPanel getPanel() {
        return chosenPanel;
    }

    public static JPanel getTitlesPanel() {
        return titlesPanel;
    }

    public static JPanel getSavePanel() {
        return savePanel;
    }

    public static JPanel getSaveBackGNDPanel() {
        return saveBackGNDPanel;
    }

    public static void updatePanel(String nameChosen, String classChosen) {
        System.out.println("name:" + nameChosen);
        System.out.println("class:" + classChosen);
        if (classChosen.equals("Entrada incompleta")) {
            if (nameChosen.equals("Entrada incompleta") || nameChosen.equals(null)) {
                nameInput.setText("Entrada incompleta");
                nameInput.setForeground(Color.RED);

            } else {
                nameInput.setText(nameChosen);
                nameInput.setForeground(Color.WHITE);
            }
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
