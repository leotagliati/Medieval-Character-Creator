import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.w3c.dom.events.MouseEvent;

public class PanelsHandler extends JFrame implements ChangeListener{
    JPanel namePanel = new JPanel();
    JPanel classPanel = new JPanel();
    JPanel appearancePanel = new JPanel();
    JButton knightClassButton, heraldClassButton, thiefClassButton, sorcererClassButton, clericClassButton;

    ArrayList<JButton> classesButtons =  new ArrayList<JButton>();
    ArrayList<JButton> appearenceButtons =  new ArrayList<JButton>();
    
    public void classPanelHandler()
    {
        knightClassButton = new JButton("Knight");
        heraldClassButton = new JButton("Herald");
        thiefClassButton = new JButton("Thief");
        sorcererClassButton = new JButton("Sorcerer");
        clericClassButton = new JButton("Cleric");


        classesButtons.add(knightClassButton);
        classesButtons.add(heraldClassButton);
        classesButtons.add(thiefClassButton);
        classesButtons.add(sorcererClassButton);
        classesButtons.add(clericClassButton);
        
        classPanel = new JPanel();
		classPanel.setBounds(400, 150, 300, 500);
        classPanel.setBackground(Color.BLUE);
        classPanel.setLayout(null);

        for (JButton jButton : classesButtons) {
            classPanel.add(jButton);
        }
        classPanel.setVisible(false);
        
        for(int i = 0; i < classesButtons.size(); i++)
        {
            classesButtons.get(i).setBounds(50,100 + (i*60),200,50);
        }
    }
    public void namePanelHandler()
    {

        

    }
    public void appearencePanelHandler()
    {
        appearancePanel = new JPanel();
		appearancePanel.setBounds(400, 150, 300, 500);
        appearancePanel.setBackground(Color.GREEN);
        appearancePanel.setLayout(null);
        appearancePanel.setVisible(false);

        JTextField headText = new JTextField("Head");
        headText.setBounds(25,10,250,40);
        headText.setFont(new Font("Jet Brains Mono", Font.PLAIN, 25));
        headText.setHorizontalAlignment(JTextField.CENTER);
        headText.setOpaque(false);
        headText.setBorder(BorderFactory.createEmptyBorder());
        headText.setEditable(false);

        JSlider headSlider = new JSlider(0,100,50);
        headSlider.setBounds(25,50,250,40);
        headSlider.setOpaque(false);
        headSlider.setBorder(BorderFactory.createEmptyBorder());
        headSlider.addChangeListener(this);


        appearancePanel.add(headText);
        appearancePanel.add(headSlider);
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateChanged'");
    }

}
