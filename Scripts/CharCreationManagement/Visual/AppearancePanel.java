package Scripts.CharCreationManagement.Visual;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.Screens.CharacterCreation;
import Scripts.CharCreationManagement.Visual.Bodypart.BodyPart;
import Scripts.CharCreationManagement.Visual.ImagesConversion.CharacterDisplay;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.EyeColorTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.GenderTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.SkinColorTypes;
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

public class AppearancePanel extends JPanel {
    SavePanel singlePanel = SavePanel.getInstance();

    public static BodyPart gender = new BodyPart("Genero", 2);
    public static BodyPart eyes = new BodyPart("Olhos", 4);
    public static BodyPart skin = new BodyPart("Cor de pele", 4);

    public static GenderTypes genderType = GenderTypes.values()[Integer.parseInt(gender.getBodyPartSliderValue().getText()) - 1];
    public static EyeColorTypes eyesType = EyeColorTypes.values()[Integer.parseInt(eyes.getBodyPartSliderValue().getText()) - 1];
    public static SkinColorTypes skinType = SkinColorTypes
            .values()[Integer.parseInt(skin.getBodyPartSliderValue().getText()) - 1];;
    ArrayList<BodyPart> bodyPartsArray = new ArrayList<>();


    private JButton confirmButton = new JButton("Confirmar");

    public AppearancePanel() {
        super();
        gender.setup(0);
        eyes.setup(1);
        skin.setup(2);

        bodyPartsArray.add(gender);
        bodyPartsArray.add(eyes);
        bodyPartsArray.add(skin);

        for (BodyPart bodyPart : bodyPartsArray) {
            bodyPart.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    if (e.getSource() == gender) {
                        genderType = GenderTypes.values()[Integer.parseInt(gender.getBodyPartSliderValue().getText())
                                - 1];
                    }
                    if (e.getSource() == eyes) {
                        eyesType = EyeColorTypes.values()[Integer.parseInt(eyes.getBodyPartSliderValue().getText())
                                - 1];
                    }
                    if (e.getSource() == skin) {
                        skinType = SkinColorTypes.values()[Integer.parseInt(skin.getBodyPartSliderValue().getText())
                                - 1];
                    }
                    CharacterDisplay.updateImages(CharacterCreation.panel);

                }

            });
        }

        // Set propriedades do objeto
        this.setBounds(500, 150, 350, 500);
        this.setLayout(null);
        this.setBackground(Color.RED);
        this.setOpaque(false);
        this.setVisible(false);

        this.add(AppearancePanel.gender.getBodyPartText());
        this.add(AppearancePanel.gender.getBodyPartSlider());
        this.add(AppearancePanel.gender.getBodyPartSliderValue());

        this.add(AppearancePanel.eyes.getBodyPartText());
        this.add(AppearancePanel.eyes.getBodyPartSlider());
        this.add(AppearancePanel.eyes.getBodyPartSliderValue());

        this.add(AppearancePanel.skin.getBodyPartText());
        this.add(AppearancePanel.skin.getBodyPartSlider());
        this.add(AppearancePanel.skin.getBodyPartSliderValue());


        ImageCreate buttonImage = new ImageCreate(5, 400, 350, 100);
        buttonImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        buttonImage.setIconFile("Images\\button.png");
        buttonImage.imageSetter();

        // Set propriedades do botao
        confirmButton = new JButton("Confirm");
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
                AudioHandler.audioPlay(AudioHandler.buttonConfirm);
                if (e.getSource() == confirmButton) {
                    for (JButton button : MainPanel.getButtonsArray()) {
                        button.setEnabled(true);
                    }
                    genderType = GenderTypes.values()[Integer.parseInt(gender.getBodyPartSliderValue().getText()) - 1];
                    eyesType = EyeColorTypes.values()[Integer.parseInt(eyes.getBodyPartSliderValue().getText()) - 1];
                    skinType = SkinColorTypes.values()[Integer.parseInt(skin.getBodyPartSliderValue().getText()) - 1];

                    setVisible(false);

                    singlePanel.setVisible(true);
                    singlePanel.getCharInstance().setGender(genderType);
                    singlePanel.getCharInstance().setEyeColor(eyesType);
                    singlePanel.getCharInstance().setSkinColor(skinType);
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
            gender.getBodyPartText().setText(bn.getString("gender"));
            eyes.getBodyPartText().setText(bn.getString("eyeColor"));
            skin.getBodyPartText().setText(bn.getString("skinColor"));
            confirmButton.setText(bn.getString("confirm"));
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
