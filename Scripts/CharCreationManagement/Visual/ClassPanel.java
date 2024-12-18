package Scripts.CharCreationManagement.Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.Visual.ImagesConversion.CharacterDisplay;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import Scripts.CharCreationManagement.Screens.CharacterCreation;

public class ClassPanel extends JPanel {
    SavePanel singlePanel = SavePanel.getInstance();

    public JButton knightClassButton, heraldClassButton, sorcererClassButton, clericClassButton;
    private ArrayList<JButton> classButtons = new ArrayList<JButton>();
    private ArrayList<JLabel> buttonsImage = new ArrayList<JLabel>();
    private JPanel backGNDPanel;

    private static String classChosen = "Cavaleiro";

    public ClassPanel() {
        super();

        // Inicializa os Botoes
        this.knightClassButton = new JButton("Cavaleiro");
        this.heraldClassButton = new JButton("Arauto");
        this.sorcererClassButton = new JButton("Feiticeiro");
        this.clericClassButton = new JButton("Clérigo");

        // Add os botoes no arrayList
        this.classButtons.add(knightClassButton);
        this.classButtons.add(heraldClassButton);
        this.classButtons.add(sorcererClassButton);
        this.classButtons.add(clericClassButton);

        GridLayout buttonsLayout = new GridLayout();
        buttonsLayout.setColumns(1);
        buttonsLayout.setRows(this.classButtons.size());
        buttonsLayout.setVgap(30);

        // Inicializa as molduras dos botoes
        for (int i = 0; i < this.classButtons.size(); i++) {
            ImageCreate backgroundImage = new ImageCreate(0, 0, 350, 100);
            backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
            backgroundImage.setIconFile("Images\\underName.png");
            backgroundImage.imageSetter();
            buttonsImage.add(backgroundImage);
        }
        // Altera propriedades dos botoes
        for (JButton jButton : this.classButtons) {
            jButton.setFont(new Font("Adobe Garamond Pro", Font.ITALIC, 25));
            jButton.setForeground(Color.WHITE);
            jButton.setOpaque(true);
            jButton.setContentAreaFilled(false);
            jButton.setBorderPainted(false);
            jButton.setFocusable(false);
            jButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (e.getSource() == jButton) {
                        AudioHandler.audioPlay(AudioHandler.buttonEntered);
                        buttonsImage.get(classButtons.indexOf(jButton))
                                .setIcon(new ImageIcon("Images\\underNameEntered.png"));
                        ;
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (e.getSource() == jButton) {
                        buttonsImage.get(classButtons.indexOf(jButton)).setIcon(new ImageIcon("Images\\underName.png"));
                        ;
                    }

                }
            });

        }
        // Inicializa o painel de fundo
        this.backGNDPanel = new JPanel();
        this.backGNDPanel.setLayout(buttonsLayout);
        this.backGNDPanel.setBounds(500, 200, 350, 400);
        this.backGNDPanel.setOpaque(false);
        this.backGNDPanel.setBackground(Color.GREEN);
        this.backGNDPanel.setVisible(false);

        this.setLayout(buttonsLayout);
        this.setBounds(500, 200, 350, 400);
        this.setOpaque(false);
        this.setBackground(Color.BLUE);

        for (JButton jButton : this.classButtons) {
            this.add(jButton);
        }
        for (JLabel jLabel : buttonsImage) {
            backGNDPanel.add(jLabel);
        }

        this.backGNDPanel.setVisible(false);
        this.setVisible(false);

        for (JButton jButton : classButtons) {

            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AudioHandler.audioPlay(AudioHandler.buttonClicked);
                    for (JButton jButton : classButtons) {
                        if (e.getSource() == jButton) {
                            classChosen = jButton.getText();
                            setVisible(false);
                            backGNDPanel.setVisible(false);
                            CharacterDisplay.updateImages(CharacterCreation.panel);
                            singlePanel.setVisible(true);
                            singlePanel.getCharInstance().setSkillClass(classChosen);
                            singlePanel.updatePanel(singlePanel.getCharInstance());
                            for (JButton button : MainPanel.getButtonsArray()) {
                                button.setEnabled(true);
                            }
                        }
                    }
                }

            });
        }
        loadLanguage(readLanguageFromFile());

    }

    public ArrayList<JButton> getButtonsArray() {
        return classButtons;
    }

    public static String getClassChosen() {
        return classChosen;
    }

    public JPanel getBackGNDPanel() {
        return backGNDPanel;
    }
    public void loadLanguage(int n) {
    ResourceBundle bn;

    // Carrega o ResourceBundle
    switch (n) {
        case 0:
            bn = ResourceBundle.getBundle("Scripts.CharCreationManagement.Screens.b_pt_BR", new Locale("pt", "BR"));
            break;
        case 1:
            bn = ResourceBundle.getBundle("Scripts.CharCreationManagement.Screens.b_en_US", Locale.US);
            break;
        case 2:
            bn = ResourceBundle.getBundle("Scripts.CharCreationManagement.Screens.b_de_DE", Locale.GERMANY);
            break;
        case 3:
            bn = ResourceBundle.getBundle("Scripts.CharCreationManagement.Screens.b_fr_FR", Locale.FRANCE);
            break;
        case 4:
            bn = ResourceBundle.getBundle("Scripts.CharCreationManagement.Screens.b_es_ES", new Locale("es", "ES"));
            break;
        default:
            bn = ResourceBundle.getBundle("Scripts.CharCreationManagement.Screens.b_en_US", Locale.US); // Idioma padrão
    }

    // Atualiza os textos
    if (bn != null) {
        knightClassButton.setText(bn.getString("knight"));
        heraldClassButton.setText(bn.getString("herald"));
        sorcererClassButton.setText(bn.getString("sorcerer"));
        clericClassButton.setText(bn.getString("cleric"));
    }

  
    this.repaint();
    this.revalidate();
}
    public int readLanguageFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Scripts/LoginManagement/Visual/MenuBar/LanguageNumber.txt"))) {
            String line = reader.readLine();
            return Integer.parseInt(line);
        } catch (IOException | NumberFormatException ex) {
            System.err.println("Erro ao ler o arquivo de idioma: " + ex.getMessage());
            ex.printStackTrace();
            return -1; // Retorna -1 caso haja algum erro ao ler ou converter o número
 
            }       
    }
}
