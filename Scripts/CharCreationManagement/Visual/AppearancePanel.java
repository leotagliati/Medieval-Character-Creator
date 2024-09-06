package Scripts.CharCreationManagement.Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.Visual.ImagesConversion.CharacterDisplay;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.EyeColorTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.SkinColorTypes;
import Scripts.CharCreationManagement.Visual.Bodypart.BodyPart;
import Scripts.CharCreationManagement.Screens.CharacterCreation;

public class AppearancePanel extends JPanel {
    SavePanel singlePanel = SavePanel.getInstance();

    public static BodyPart eyes = new BodyPart("Olhos", 4);
    public static BodyPart skin = new BodyPart("Cor de pele", 4);

    public static EyeColorTypes eyesType = EyeColorTypes
            .values()[Integer.parseInt(eyes.getBodyPartSliderValue().getText()) - 1];;
    public static SkinColorTypes skinType = SkinColorTypes
            .values()[Integer.parseInt(skin.getBodyPartSliderValue().getText()) - 1];;
    ArrayList<BodyPart> bodyPartsArray = new ArrayList<>();

    private JButton confirmButton = new JButton("Confirmar");

    public AppearancePanel() {
        super();
        eyes.setup(0);
        skin.setup(1);

        bodyPartsArray.add(eyes);
        bodyPartsArray.add(skin);

        for (BodyPart bodyPart : bodyPartsArray) {
            bodyPart.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
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
                AudioHandler.audioPlay("Music\\buttonEntered.wav");
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
                AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                if (e.getSource() == confirmButton) {
                    for (JButton button : MainPanel.getButtonsArray()) {
                        button.setEnabled(true);
                    }
                    eyesType = EyeColorTypes.values()[Integer.parseInt(eyes.getBodyPartSliderValue().getText()) - 1];
                    skinType = SkinColorTypes.values()[Integer.parseInt(skin.getBodyPartSliderValue().getText()) - 1];

                    setVisible(false);

                    singlePanel.setVisible(true);
                    singlePanel.getCharInstance().setEyeColor(eyesType);
                    singlePanel.getCharInstance().setSkinColor(skinType);
                    singlePanel.updatePanel(singlePanel.getCharInstance());

                }
            }

        });

        this.add(confirmButton);
        this.add(buttonImage);

    }
}
