package Panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AppearancePanel {
    private JPanel appearancePanel;
    
    
    public JTextField headText, torsoText, armsText, legsText;
    public JSlider headSlider, torsoSlider, armsSlider, legsSlider;
    
    private JTextField headSliderPos;
    
    public AppearancePanel()
    {
        this.appearancePanel = new JPanel();
		this.appearancePanel.setBounds(400, 150, 300, 500);
        this.appearancePanel.setBackground(Color.GREEN);
        this.appearancePanel.setLayout(null);
        this.appearancePanel.setVisible(false);
        
        this.headText = new JTextField("Head");
        this.headText.setBounds(25,10,250,40);
        this.headText.setFont(new Font("Jet Brains Mono", Font.PLAIN, 25));
        this.headText.setHorizontalAlignment(JTextField.CENTER);
        this.headText.setOpaque(false);
        this.headText.setBorder(BorderFactory.createEmptyBorder());
        this.headText.setEditable(false);
        
        headSlider = new JSlider(0,3,2);
        headSlider.setBounds(25,70,250,40);
        headSlider.setOpaque(false);
        headSlider.setBorder(BorderFactory.createEmptyBorder());
        headSlider.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent e) {
                if(e.getSource() == headSlider)
                {
                    headSliderPos.setText("" + headSlider.getValue());
                }
            }
            
        });

        headSliderPos = new JTextField("" + this.headSlider.getValue());
        this.headSliderPos.setBounds(25,50,250,20);
        this.headSliderPos.setFont(new Font("Jet Brains Mono", Font.PLAIN, 15));
        this.headSliderPos.setHorizontalAlignment(JTextField.CENTER);
        this.headSliderPos.setOpaque(false);
        this.headSliderPos.setBorder(BorderFactory.createEmptyBorder());
        this.headSliderPos.setEditable(false);

        appearancePanel.add(this.headText);
        appearancePanel.add(this.headSlider);
        appearancePanel.add(this.headSliderPos);
    }
    public JPanel getPanel() {
        return appearancePanel;
    }
    
}
