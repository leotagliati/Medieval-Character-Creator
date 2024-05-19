package Scripts.Panels;

import java.awt.Color;

import javax.swing.JPanel;

import Scripts.Panels.AppearanceBodypart.BodyPart;

public class VesturePanel extends JPanel{
    public BodyPart helmet = new BodyPart("Helm", 3);
    public BodyPart chest = new BodyPart("Chest", 3);
    public BodyPart legs = new BodyPart("Leggings", 3);
    public BodyPart arms = new BodyPart("Gauntlets", 3);
    private JPanel backgJPanel;
    
    
    public VesturePanel()
    {
        super();
        helmet.setup(0);
        chest.setup(1);
        legs.setup(2);
        arms.setup(3);
        
        this.setBounds(400, 150, 300, 500);
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
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
        
        
    }
    public JPanel getBackgJPanel() {
        return backgJPanel;
    }
}
