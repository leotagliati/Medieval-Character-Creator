package Scripts.CharCreationManagement.Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;

public class MainPanel extends JPanel {
    public JButton charNameButton, charVestureButton, charClassButton, charAppearenceButton, returnButton;
    private ArrayList<JLabel> buttonsDesignArray = new ArrayList<JLabel>();
    private static ArrayList<JButton> buttonsArray = new ArrayList<JButton>();
    private JPanel backGNDPanel;

    public MainPanel()
    {
        super();
        // Inicializa os Botoes
        this.charNameButton = new JButton("Nome");
        this.charClassButton = new JButton("Classe");
        this.charVestureButton = new JButton("Vestimenta");
        this.charAppearenceButton = new JButton("Aparência");
        this.returnButton = new JButton("Voltar");

        // Add os botoes no arrayList
        MainPanel.buttonsArray.add(charNameButton);
        MainPanel.buttonsArray.add(charVestureButton);
        MainPanel.buttonsArray.add(charClassButton);
        MainPanel.buttonsArray.add(charAppearenceButton);
        MainPanel.buttonsArray.add(returnButton);

        GridLayout buttonsLayout = new GridLayout();
        buttonsLayout.setColumns(1);
        buttonsLayout.setRows(MainPanel.buttonsArray.size());
        buttonsLayout.setVgap(30);

        for (int i = 0; i < MainPanel.buttonsArray.size(); i++) {
            ImageCreate backgroundImage = new ImageCreate(0, 0, 300, 100);
            backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
            backgroundImage.setIconFile("Images\\button.png");
            backgroundImage.imageSetter();
            buttonsDesignArray.add(backgroundImage);
        }

        // Set propriedade dos botoes
        for (JButton button : MainPanel.buttonsArray) {
            button.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 28));
            button.setForeground(Color.WHITE);
            button.setOpaque(true);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusable(false);
        }

        // Set painel das imagens de fundo
        this.backGNDPanel = new JPanel();
        this.backGNDPanel.setLayout(buttonsLayout);
        this.backGNDPanel.setBounds(50, 150, 300, 600);
        this.backGNDPanel.setOpaque(false);
        this.backGNDPanel.setBackground(Color.GREEN);

        // Set propriedades do objeto
        this.setLayout(buttonsLayout);
        this.setBounds(75, 150, 250, 600);
        this.setOpaque(false);
        this.setBackground(Color.RED);

        for (JButton button : MainPanel.buttonsArray) {
            this.add(button);
        }
        for (JLabel buttonImage : buttonsDesignArray) {
            backGNDPanel.add(buttonImage);
        }
        loadLanguage(readLanguageFromFile());
    }

    public static ArrayList<JButton> getButtonsArray() {
        return buttonsArray;
    }

    public JPanel getBackPanel() {
        return backGNDPanel;
    }

    public ArrayList<JLabel> getButtonsDesignArray() {
        return buttonsDesignArray;
    }
      public void loadLanguage(int n) {
        ResourceBundle bn;
        
        // Carrega o ResourceBundle com base no idioma selecionado
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
    
        // Atualiza os textos dos componentes de acordo com o idioma selecionado
        if (bn != null) {
            charNameButton.setText(bn.getString("charNameButton"));
            charVestureButton.setText(bn.getString("charVestureButton"));
            charClassButton.setText(bn.getString("charClassButton"));
            charAppearenceButton.setText(bn.getString("charAppearenceButton"));
            returnButton.setText(bn.getString("returnButton"));
        }
    
        // Atualize o painel e os componentes para refletir as mudanças de idioma
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
