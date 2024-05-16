package Scripts.Panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Scripts.Panels.AppearanceBodypart.BodyPart;

public class AppearancePanel {
    private JPanel appearancePanel;
    
    private BodyPart eyes = new BodyPart("Eyes", 2);
    private BodyPart skin = new BodyPart("Skin",3);
    private BodyPart physic = new BodyPart("Physic", 1);

    public AppearancePanel()
    {
        eyes.setup(0);
        skin.setup(1);
        physic.setup(2);

        this.appearancePanel = new JPanel();
		this.appearancePanel.setBounds(400, 150, 300, 500);
        this.appearancePanel.setBackground(Color.GREEN);
        this.appearancePanel.setLayout(null);
        this.appearancePanel.setVisible(false);
        
        
        appearancePanel.add(this.eyes.getBodyPartText());
        appearancePanel.add(this.eyes.getBodyPartSlider());
        appearancePanel.add(this.eyes.getBodyPartSliderValue());

        appearancePanel.add(this.skin.getBodyPartText());
        appearancePanel.add(this.skin.getBodyPartSlider());
        appearancePanel.add(this.skin.getBodyPartSliderValue());

        appearancePanel.add(this.physic.getBodyPartText());
        appearancePanel.add(this.physic.getBodyPartSlider());
        appearancePanel.add(this.physic.getBodyPartSliderValue());
    }
    public JPanel getPanel() {
        return appearancePanel;
    }
    
}
