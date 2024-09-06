package Scripts.CharCreationManagement.Visual.Bodypart;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BodyPart extends JSlider
{
    private JTextField bodyPartText;
    private JTextField bodyPartSliderValue;
    private int visualOffset = 120;
    
    public BodyPart(String name, int sliderMaxValue)
    {
        super(1,sliderMaxValue,2);
        this.bodyPartText = new JTextField(name);
        this.bodyPartSliderValue = new JTextField("" + this.getValue());
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

        this.setBounds(50,70 + (sliderOrder * visualOffset),250,40);
        this.setSnapToTicks(true);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                bodyPartSliderValue.setText("" + getBodyPartSlider().getValue());
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
        return this;
    }
    public JTextField getBodyPartSliderValue() {
        return bodyPartSliderValue;
    }
}
