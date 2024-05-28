package Scripts.Panels.CharacterCreation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Scripts.AudioHandler;
import Scripts.ImagesConversion.CharacterDisplay;
import Scripts.ImagesConversion.ImageCreate;
import Scripts.ImagesConversion.Enums.ChestTypes;
import Scripts.ImagesConversion.Enums.HelmetTypes;
import Scripts.ImagesConversion.Enums.LegsTypes;
import Scripts.Panels.CharacterCreation.Bodypart.BodyPart;
import Scripts.Screens.CharacterCreation;

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
    }
}
