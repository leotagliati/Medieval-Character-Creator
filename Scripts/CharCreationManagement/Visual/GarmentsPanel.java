package Scripts.CharCreationManagement.Visual;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.Screens.CharacterCreation;
import Scripts.CharCreationManagement.Visual.Bodypart.BodyPart;
import Scripts.CharCreationManagement.Visual.ImagesConversion.CharacterDisplay;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.ChestTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.HelmetTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.LegsTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GarmentsPanel extends JPanel {
    SavePanel singlePanel = SavePanel.getInstance();

    public static BodyPart helmet = new BodyPart("Capacete", 3);
    public static BodyPart chest = new BodyPart("Peitoral", 3);
    public static BodyPart legs = new BodyPart("Calça", 3);
    ArrayList<BodyPart> bodyPartsArray = new ArrayList<>();

    private JButton confirmButton = new JButton("Confirmar");

    public static HelmetTypes helmetType = HelmetTypes
            .values()[Integer.parseInt(helmet.getBodyPartSliderValue().getText()) - 1];
    public static ChestTypes chestType = ChestTypes.values()[Integer.parseInt(chest.getBodyPartSliderValue().getText())
            - 1];
    public static LegsTypes legsType = LegsTypes.values()[Integer.parseInt(legs.getBodyPartSliderValue().getText())
            - 1];

    public GarmentsPanel() {
        super();
        helmet.setup(0);
        chest.setup(1);
        legs.setup(2);

        bodyPartsArray.add(helmet);
        bodyPartsArray.add(chest);
        bodyPartsArray.add(legs);

        for (BodyPart bodyPart : bodyPartsArray) {
            bodyPart.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    if (e.getSource() == helmet) {
                        helmetType = HelmetTypes.values()[Integer.parseInt(helmet.getBodyPartSliderValue().getText())
                                - 1];
                    }
                    if (e.getSource() == chest) {
                        chestType = ChestTypes.values()[Integer.parseInt(chest.getBodyPartSliderValue().getText()) - 1];

                    }
                    if (e.getSource() == legs) {
                        legsType = LegsTypes.values()[Integer.parseInt(legs.getBodyPartSliderValue().getText()) - 1];

                    }
                    CharacterDisplay.updateImages(CharacterCreation.panel);
                }

            });
        }

        // Set propriedades do objeto
        this.setBounds(500, 150, 350, 500);
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        this.setOpaque(false);
        this.setVisible(false);

        this.add(GarmentsPanel.helmet.getBodyPartText());
        this.add(GarmentsPanel.helmet.getBodyPartSlider());
        this.add(GarmentsPanel.helmet.getBodyPartSliderValue());

        this.add(GarmentsPanel.chest.getBodyPartText());
        this.add(GarmentsPanel.chest.getBodyPartSlider());
        this.add(GarmentsPanel.chest.getBodyPartSliderValue());

        this.add(GarmentsPanel.legs.getBodyPartText());
        this.add(GarmentsPanel.legs.getBodyPartSlider());
        this.add(GarmentsPanel.legs.getBodyPartSliderValue());

        ImageCreate buttonImage = new ImageCreate(5, 400, 350, 100);
        buttonImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        buttonImage.setIconFile("Images\\button.png");
        buttonImage.imageSetter();

        // Set propriedades do botao
        confirmButton.setBounds(50, 400, 260, 100);
        confirmButton.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 28));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setOpaque(true);
        confirmButton.setContentAreaFilled(false);
        confirmButton.setBorderPainted(false);
        confirmButton.setFocusable(false);
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                AudioHandler.audioPlay(AudioHandler.buttonEntered);
                if (e.getSource() == confirmButton) {
                    buttonImage.setIcon(new ImageIcon("Images\\buttonClicked.png"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == confirmButton) {
                    buttonImage.setIcon(new ImageIcon("Images\\button.png"));
                }
            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AudioHandler.audioPlay(AudioHandler.buttonClicked);
                if (e.getSource() == confirmButton) {
                    for (JButton button : MainPanel.getButtonsArray()) {
                        button.setEnabled(true);
                    }

                    helmetType = HelmetTypes.values()[Integer.parseInt(helmet.getBodyPartSliderValue().getText()) - 1];
                    chestType = ChestTypes.values()[Integer.parseInt(chest.getBodyPartSliderValue().getText()) - 1];
                    legsType = LegsTypes.values()[Integer.parseInt(legs.getBodyPartSliderValue().getText()) - 1];

                    setVisible(false);

                    singlePanel.setVisible(true);
                    singlePanel.getCharInstance().setHelmTypes(helmetType);
                    singlePanel.getCharInstance().setChestTypes(chestType);
                    singlePanel.getCharInstance().setLegsTypes(legsType);
                    singlePanel.updatePanel(singlePanel.getCharInstance());
                }
            }

        });

        this.add(confirmButton);
        this.add(buttonImage);
        loadLanguage(readLanguageFromFile());
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
        helmet.getBodyPartText().setText(bn.getString("helmet"));
        chest.getBodyPartText().setText(bn.getString("chest"));
        legs.getBodyPartText().setText(bn.getString("legs"));
        confirmButton.setText(bn.getString("confirm"));
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
