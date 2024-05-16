package Panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Bodypart.Head;

public class AppearancePanel {
    private JPanel appearancePanel;
    
    Head head = new Head();

    public AppearancePanel()
    {
        this.appearancePanel = new JPanel();
		this.appearancePanel.setBounds(400, 150, 300, 500);
        this.appearancePanel.setBackground(Color.GREEN);
        this.appearancePanel.setLayout(null);
        this.appearancePanel.setVisible(false);
        
        
        appearancePanel.add(this.head.getText());
        appearancePanel.add(this.head.getSlider());
        appearancePanel.add(this.head.getSliderPos());
    }
    public JPanel getPanel() {
        return appearancePanel;
    }
    
}
