package Scripts.Panels.CharacterCreation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import Scripts.AudioHandler;
import Scripts.ImagesConversion.ImageCreate;
import Scripts.ImagesConversion.Enums.EyeColorTypes;
import Scripts.ImagesConversion.Enums.PhysicTypes;
import Scripts.ImagesConversion.Enums.SkinColorTypes;
import Scripts.Panels.CharacterCreation.Bodypart.BodyPart;

public class AppearancePanel extends JPanel {

    private BodyPart eyes = new BodyPart("Olhos", 3);
    private BodyPart skin = new BodyPart("Cor de pele", 4);
    private BodyPart physic = new BodyPart("Físico", 2);

    private JButton confirmButton = new JButton("Confirmar");

    public EyeColorTypes eyesType;
    public SkinColorTypes skinType;
    public PhysicTypes physicType;

    public AppearancePanel() {
        super();
        eyes.setup(0);
        skin.setup(1);
        physic.setup(2);

        // Set propriedades do objeto
        this.setBounds(500, 150, 350, 500);
        this.setLayout(null);
        this.setBackground(Color.RED);
        this.setOpaque(false);
        this.setVisible(false);

        this.add(this.eyes.getBodyPartText());
        this.add(this.eyes.getBodyPartSlider());
        this.add(this.eyes.getBodyPartSliderValue());

        this.add(this.skin.getBodyPartText());
        this.add(this.skin.getBodyPartSlider());
        this.add(this.skin.getBodyPartSliderValue());

        this.add(this.physic.getBodyPartText());
        this.add(this.physic.getBodyPartSlider());
        this.add(this.physic.getBodyPartSliderValue());

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
                    eyesType = EyeColorTypes.values()[Integer.parseInt(eyes.getBodyPartSliderValue().getText()) - 1];
                    skinType = SkinColorTypes.values()[Integer.parseInt(skin.getBodyPartSliderValue().getText()) - 1];
                    physicType = PhysicTypes.values()[Integer.parseInt(physic.getBodyPartSliderValue().getText()) - 1];

                    setVisible(false);
                    // JOptionPane.showMessageDialog(null, eyesType.toString());
                    // JOptionPane.showMessageDialog(null, skinType.toString());
                    // JOptionPane.showMessageDialog(null, physicType.toString());
                    ChosenAttPanel.getTitlesPanel().setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(true);
                    ChosenAttPanel.getSavePanel().setVisible(true);
                    ChosenAttPanel.getSaveBackGNDPanel().setVisible(true);
                    ChosenAttPanel.updatePanel(NamePanel.getNameChosen(), ClassPanel.getClassChosen());
                }
            }

        });

        this.add(confirmButton);
        this.add(buttonImage);

    }
}
