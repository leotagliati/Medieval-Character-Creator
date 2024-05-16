package Bodypart;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Head {
    private JTextField headText;
    
    private JSlider headSlider;
    
    private JTextField headSliderPos;
    
    

    public Head()
    {
        this.headText = new JTextField("Head");
        this.headText.setBounds(25,10,250,40);
        this.headText.setFont(new Font("Jet Brains Mono", Font.PLAIN, 25));
        this.headText.setHorizontalAlignment(JTextField.CENTER);
        this.headText.setOpaque(false);
        this.headText.setBorder(BorderFactory.createEmptyBorder());
        this.headText.setEditable(false);
        
        this.headSlider = new JSlider(0,3,2);
        this.headSlider.setBounds(25,70,250,40);
        this.headSlider.setOpaque(false);
        this.headSlider.setBorder(BorderFactory.createEmptyBorder());
        this.headSlider.addChangeListener(new ChangeListener() {
            
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
    }
    
    public JTextField getText() {
        return headText;
    }
    public JSlider getSlider() {
        return headSlider;
    }
    public JTextField getSliderPos() {
        return headSliderPos;
    }
}
