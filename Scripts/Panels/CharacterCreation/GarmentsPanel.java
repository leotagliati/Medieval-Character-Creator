package Scripts.Panels.CharacterCreation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Scripts.AudioHandler;
import Scripts.ImagesConversion.ImageCreate;
import Scripts.Panels.CharacterCreation.Bodypart.BodyPart;

public class GarmentsPanel extends JPanel{
    public BodyPart helmet = new BodyPart("Capacete", 3);
    public BodyPart chest = new BodyPart("Peitoral", 3);
    public BodyPart legs = new BodyPart("Calça", 3);
    
    private JButton confirmButton = new JButton("Confirmar");

    private static String helmetID;
    private static String chestID;
    private static String legsID;
    
    public GarmentsPanel()
    {
        super();
        helmet.setup(0);
        chest.setup(1);
        legs.setup(2);
        
        // Set propriedades do objeto
        this.setBounds(500, 150, 350, 500);
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        this.setOpaque(false);
        this.setVisible(false);
        
        this.add(this.helmet.getBodyPartText());
        this.add(this.helmet.getBodyPartSlider());
        this.add(this.helmet.getBodyPartSliderValue());
        
        this.add(this.chest.getBodyPartText());
        this.add(this.chest.getBodyPartSlider());
        this.add(this.chest.getBodyPartSliderValue());
        
        this.add(this.legs.getBodyPartText());
        this.add(this.legs.getBodyPartSlider());
        this.add(this.legs.getBodyPartSliderValue());

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
                    helmetID = helmet.getBodyPartSliderValue().getText();
                    chestID = chest.getBodyPartSliderValue().getText();
                    legsID = legs.getBodyPartSliderValue().getText();
                    // JOptionPane.showMessageDialog(null, helmetID);
                    // JOptionPane.showMessageDialog(null, chestID);
                    // JOptionPane.showMessageDialog(null, legsID);
                    setVisible(false);
                    ChosenAttPanel.getTitlesPanel().setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(true);
                    ChosenAttPanel.getSavePanel().setVisible(true);
                    ChosenAttPanel.getSaveBackGNDPanel().setVisible(true);
                    ChosenAttPanel.updatePanel(NamePanel.getNameChosen(), ClassPanel.getClassChosen());
                }
            }
            
        });

        this.add(buttonImage);
        this.add(confirmButton);
    }
    public static String getHelmetID() {
        return helmetID;
    }

    public static String getChestID() {
        return chestID;
    }

    public static String getLegsID() {
        return legsID;
    }
    
}
