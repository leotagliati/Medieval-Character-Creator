package Scripts.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Scripts.AudioHandler;
import Scripts.ImageCreate;
import Scripts.Panels.Bodypart.BodyPart;

public class GarmentsPanel extends JPanel{
    public BodyPart helmet = new BodyPart("Capacete", 3);
    public BodyPart chest = new BodyPart("Peitoral", 3);
    public BodyPart legs = new BodyPart("Calça", 3);
    private JPanel backgJPanel;
    
    private JButton confirmButton;

    private String helmetID;
    private String chestID;
    private String legsID;
    
    public GarmentsPanel()
    {
        super();
        helmet.setup(0);
        chest.setup(1);
        legs.setup(2);
        
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

        ImageCreate backgroundImage = new ImageCreate(5, 400, 350, 100);
        backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        backgroundImage.setIconFile("Images\\button.png");
        backgroundImage.imageSetter();

        confirmButton = new JButton("Confirmar");
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
                    backgroundImage.setIcon(new ImageIcon("Images\\buttonClicked.png"));
                }
            }
            @Override
            public void mouseExited(MouseEvent e){
                if (e.getSource() == confirmButton) {
                    backgroundImage.setIcon(new ImageIcon("Images\\button.png"));
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
                    setVisible(false);
                    ChosenAttPanel.getBackgPanel().setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(true);
                    ChosenAttPanel.updatePanel(NamePanel.getNameChosen(), ClassPanel.getClassChosen());
                }
            }
            
        });

        this.add(confirmButton);
        this.add(backgroundImage);
    }
    public JPanel getBackgJPanel() {
        return backgJPanel;
    }
}
