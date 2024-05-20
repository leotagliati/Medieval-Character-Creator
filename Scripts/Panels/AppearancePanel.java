package Scripts.Panels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Scripts.ImageCreate;
import Scripts.Panels.AppearanceBodypart.BodyPart;

public class AppearancePanel extends JPanel{
    
    private BodyPart eyes = new BodyPart("Eyes", 3);
    private BodyPart skin = new BodyPart("Skin",3);
    private BodyPart physic = new BodyPart("Physic", 2);
    
    private JPanel backgJPanel;

    public AppearancePanel()
    {
        super();
        eyes.setup(0);
        skin.setup(1);
        physic.setup(2);

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
    }
}
