import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class CharacterCreation extends JFrame implements ActionListener{
    
    
    ArrayList<JPanel> subPanelsArrayList = new ArrayList<JPanel>();
    
	ArrayList<JButton> mainButtons = new ArrayList<JButton>();
    
    
    
	JButton charNameButton, charGenderButton, charClassButton, charAppearenceButton, charBuildButton;
    
    NamePanel namePanel = new NamePanel();
    

    CharacterCreation()
    {
        super("Character Creation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280, 720);
		this.setLayout(null);


        // Image Setter
        JLabel charImage = new JLabel();
        charImage.setLayout(new FlowLayout());
        charImage.setBounds(1000, -100, 1000, 1000);
        charImage.setIcon(new ImageIcon("charImage.png"));
        charImage.setVisible(true);
        
        JLabel helmImage = new JLabel();
        helmImage.setLayout(new FlowLayout());
        helmImage.setBounds(1004, -196, 1000, 1000);
        helmImage.setIcon(new ImageIcon("helmImage.png"));
        helmImage.setVisible(true);

        JLabel swordImage = new JLabel();
        swordImage.setLayout(null);
        swordImage.setBounds(856, 140, 500, 500);
        swordImage.setIcon(new ImageIcon("swordImage.png"));
        swordImage.setVisible(true);

        charNameButton = new JButton("Name");
        charClassButton = new JButton("Class");
        charGenderButton = new JButton("Gender");
        charAppearenceButton = new JButton("Appearence");
        charBuildButton = new JButton("Build");
        
        mainButtons.add(charNameButton);
        mainButtons.add(charGenderButton);
        mainButtons.add(charClassButton);
        mainButtons.add(charAppearenceButton);
        
        for(int i = 0; i < mainButtons.size(); i++)
        {
            mainButtons.get(i).setBounds(50,0 + (i*60),200,50);
        }

        for (JButton jButton : mainButtons) {
            jButton.addActionListener(this);
			jButton.setFont(new Font("Jet Brains Mono", Font.PLAIN, 15));
			jButton.setFocusable(false);
        }
        JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(50, 150, 300, 500);
        buttonsPanel.setBackground(Color.BLACK);
		buttonsPanel.setLayout(null);

        
        for(int i = 0; i < mainButtons.size(); i++)
        {
            buttonsPanel.add(mainButtons.get(i));
        }

        subPanelsArrayList.add(namePanel.getPanel());
        // subPanelsArrayList.add(classPanel);
        // subPanelsArrayList.add(appearancePanel);
        
        this.add(helmImage);
        this.add(swordImage);
        this.add(charImage);

        this.add(buttonsPanel);
        this.add(namePanel.getPanel());
        // this.add(classPanel);
        // this.add(appearancePanel);

		this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == charNameButton)
        {
            for (JPanel panel : subPanelsArrayList) {
                if(panel == namePanel.getPanel())
                {
                    panel.setVisible(true);
                }
                else panel.setVisible(false);
            }
        }
        else if(e.getSource() == charClassButton)
        {
            // for (JPanel panel : subPanelsArrayList) {
            //     if(panel == classPanel)
            //     {
            //         panel.setVisible(true);
            //     }
            //     else panel.setVisible(false);
            // }
        }
        else if(e.getSource() == charAppearenceButton)
        {
            // for (JPanel panel : subPanelsArrayList) {
            //     if(panel == appearancePanel)
            //     {
            //         panel.setVisible(true);
            //     }
            //     else panel.setVisible(false);
            // }
        }
    }
    
}
