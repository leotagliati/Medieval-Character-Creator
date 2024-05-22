package Scripts.Panels.CharacterCreation.Bodypart;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BodyPart
{
    private JTextField bodyPartText;
    private JSlider bodyPartSlider;
    private JTextField bodyPartSliderValue;
    private int visualOffset = 120;
    
    public BodyPart(String name, int sliderMaxValue)
    {
        this.bodyPartText = new JTextField(name);
        this.bodyPartSlider = new JSlider(1, sliderMaxValue,2);
        this.bodyPartSliderValue = new JTextField("" + this.bodyPartSlider.getValue());
    }

    public void setup(int sliderOrder)
    {
        this.bodyPartText.setBounds(50, 10 + (sliderOrder * visualOffset),250,40);
        this.bodyPartText.setFont(new Font("Adobe Garamond Pro", Font.ITALIC, 30));
        this.bodyPartText.setHorizontalAlignment(JTextField.CENTER);
        this.bodyPartText.setOpaque(false);
        this.bodyPartText.setForeground(Color.WHITE);
        this.bodyPartText.setBorder(BorderFactory.createEmptyBorder());
        this.bodyPartText.setEditable(false);

        this.bodyPartSlider.setBounds(50,70 + (sliderOrder * visualOffset),250,40);
        this.bodyPartSlider.setSnapToTicks(true);
        this.bodyPartSlider.setOpaque(false);
        this.bodyPartSlider.setBorder(BorderFactory.createEmptyBorder());
        this.bodyPartSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if(e.getSource() == bodyPartSlider)
                {
                    bodyPartSliderValue.setText("" + bodyPartSlider.getValue());
                }
            }
        });
        
        this.bodyPartSliderValue.setBounds(50,50 + (sliderOrder * visualOffset),250,20);
        this.bodyPartSliderValue.setFont(new Font("Jet Brains Mono", Font.PLAIN, 15));
        this.bodyPartSliderValue.setHorizontalAlignment(JTextField.CENTER);
        this.bodyPartSliderValue.setOpaque(false);
        this.bodyPartSliderValue.setForeground(Color.WHITE);
        this.bodyPartSliderValue.setBorder(BorderFactory.createEmptyBorder());
        this.bodyPartSliderValue.setEditable(false);
    }

    public JTextField getBodyPartText() {
        return bodyPartText;
    }
    public JSlider getBodyPartSlider() {
        return bodyPartSlider;
    }
    public JTextField getBodyPartSliderValue() {
        return bodyPartSliderValue;
    }
}
