package Scripts.CharCreationManagement.Visual;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NamePanel extends JPanel {

    SavePanel singlePanel = SavePanel.getInstance();

    private JLabel titleText = new JLabel("Insira seu nome");
    private JLabel pressEnterText1 = new JLabel("Aperte a tecla");
    private JLabel pressEnterText2 = new JLabel("para confirmar");
    private JTextField nameInput = new JTextField("Entrada incompleta");

    public static String nameChosen = "Entrada incompleta";

    public NamePanel() {
        super();
        // Set propriedade do titleText
        this.titleText.setBounds(40, 30, 270, 50);
        this.titleText.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 40));
        this.titleText.setHorizontalAlignment(JTextField.CENTER);
        this.titleText.setOpaque(false);
        this.titleText.setBorder(null);
        this.titleText.setForeground(Color.WHITE);
        this.titleText.setVisible(true);

        this.pressEnterText1.setBounds(50, 140, 400, 400);
        this.pressEnterText1.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 30));
        this.pressEnterText1.setHorizontalAlignment(JLabel.LEFT);
        this.pressEnterText1.setOpaque(false);
        this.pressEnterText1.setBorder(null);
        this.pressEnterText1.setForeground(Color.WHITE);
        this.pressEnterText1.setVisible(true);

        ImageCreate enterIconImage = new ImageCreate(80, 120, 400, 400);
        enterIconImage.setIconFile("Images\\enterButton.png");
        enterIconImage.imageSetter();

        this.pressEnterText2.setBounds(50, 330, 400, 200);
        this.pressEnterText2.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 30));
        this.pressEnterText2.setHorizontalAlignment(JLabel.LEFT);
        this.pressEnterText2.setOpaque(false);
        this.pressEnterText2.setBorder(null);
        this.pressEnterText2.setForeground(Color.WHITE);
        this.pressEnterText2.setVisible(true);

        // Set propriedade do nameInput
        this.nameInput.setBounds(50, 100, 250, 70);
        this.nameInput.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 25));
        this.nameInput.setHorizontalAlignment(JTextField.CENTER);
        this.nameInput.setOpaque(false);
        this.nameInput.setBorder(null);
        this.nameInput.setForeground(Color.RED);
        this.nameInput.setEditable(false);
        this.nameInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameInput.setEditable(true);
                if (nameInput.getText().equals("Entrada incompleta")) {
                    nameInput.setText("");
                }
                nameInput.setForeground(Color.WHITE);
            }
        });
        this.nameInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    AudioHandler.audioPlay(AudioHandler.buttonClicked);
                    for (JButton button : MainPanel.getButtonsArray()) {
                        button.setEnabled(true);
                    }
                    if (nameInput.getText().equals("") || nameInput.getText().toLowerCase().equals("entrada incompleta")) {
                        nameInput.setText("Entrada incompleta");
                        nameInput.setForeground(Color.RED);
                    }

                    nameInput.setEditable(false);
                    nameChosen = nameInput.getText();
                    setVisible(false);
                    
                    singlePanel.setVisible(true);
                    singlePanel.getCharInstance().setName(nameChosen);
                    if (!nameChosen.equals("Entrada incompleta")) {
                        singlePanel.nameInput.setForeground(Color.WHITE);
                    } else
                        singlePanel.nameInput.setForeground(Color.RED);
                    singlePanel.updatePanel(singlePanel.getCharInstance());
                }
                else
                {
                    AudioHandler.audioPlay(AudioHandler.keyTyped);
                }
            }

        });
        this.nameInput.setVisible(true);

        ImageCreate backgroundImage = new ImageCreate(0, 80, 350, 100);
        backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        backgroundImage.setIconFile("Images\\namePanelUnder.png");
        backgroundImage.imageSetter();

        // Set propriedades do objeto
        this.setBounds(500, 150, 350, 500);
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        this.add(this.pressEnterText1);
        this.add(enterIconImage);
        this.add(this.pressEnterText2);
        this.add(this.titleText);
        this.add(this.nameInput);
        this.add(backgroundImage);
        this.setOpaque(false);
        this.setVisible(false);
        loadLanguage(readLanguageFromFile());
    }

    public JTextField getNameInput() {
        return nameInput;
    }

    public void setNameInput(JTextField nameTextField) {
        this.nameInput = nameTextField;
    }

    public static String getNameChosen() {
        return nameChosen;
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
            titleText.setText(bn.getString("titleText"));
            pressEnterText1.setText(bn.getString("pressEnterText1"));
            pressEnterText2.setText(bn.getString("pressEnterText2"));
            nameInput.setText(bn.getString("nameInput"));
        }
    
        // Atualize o painel e os componentes 
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
