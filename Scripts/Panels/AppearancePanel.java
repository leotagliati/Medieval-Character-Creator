package Scripts.Panels;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Scripts.AudioHandler;
import Scripts.ImagesConversion.ImageCreate;
import Scripts.Panels.Bodypart.BodyPart;

public class AppearancePanel extends JPanel {

    private BodyPart eyes = new BodyPart("Olhos", 3);
    private BodyPart skin = new BodyPart("Cor de pele", 3);
    private BodyPart physic = new BodyPart("Físico", 2);
    
    private JButton confirmButton = new JButton("Confirmar");
    
    private static String eyeID;
    private static String skinID;
    private static String physicID;
    


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
            public void mouseExited(MouseEvent e){
                if (e.getSource() == confirmButton) {
                    buttonImage.setIcon(new ImageIcon("Images\\button.png"));
                }
            }
        });
        confirmButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                if(e.getSource() == confirmButton)
                {
                    eyeID = eyes.getBodyPartSliderValue().getText();
                    skinID = skin.getBodyPartSliderValue().getText();
                    physicID = physic.getBodyPartSliderValue().getText();
                    setVisible(false);
                    // JOptionPane.showMessageDialog(null, eyeID);
                    // JOptionPane.showMessageDialog(null, skinID);
                    // JOptionPane.showMessageDialog(null, physicID);
                    ChosenAttPanel.getBackGNDPanel().setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(true);
                    ChosenAttPanel.updatePanel(NamePanel.getNameChosen(), ClassPanel.getClassChosen());
                }
            }
            
        });

        this.add(confirmButton);
        this.add(buttonImage);

    }
    public static String getEyeID(){
        return eyeID;
    }
    public static String getSkinID(){
        return skinID;
    }
    public static String getPhysicID(){
        return physicID;
    }

}
