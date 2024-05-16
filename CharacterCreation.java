import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Scripts.Panels.AppearancePanel;
import Scripts.Panels.ClassPanel;
import Scripts.Panels.GenderPanel;
import Scripts.Panels.MainPanel;
import Scripts.Panels.NamePanel;

public class CharacterCreation extends JFrame implements ActionListener{
    
    
    ArrayList<JPanel> subPanelsArrayList = new ArrayList<JPanel>();
    
    
    MainPanel mainPanel = new MainPanel();
    NamePanel namePanel = new NamePanel();
    GenderPanel genderPanel = new GenderPanel();
    ClassPanel classPanel = new ClassPanel();
    AppearancePanel appearancePanel = new AppearancePanel();
    

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
        charImage.setIcon(new ImageIcon("Images\\charImage.png"));
        charImage.setVisible(true);
        
        JLabel helmImage = new JLabel();
        helmImage.setLayout(new FlowLayout());
        helmImage.setBounds(1004, -196, 1000, 1000);
        helmImage.setIcon(new ImageIcon("Images\\helmImage.png"));
        helmImage.setVisible(true);

        JLabel swordImage = new JLabel();
        swordImage.setLayout(null);
        swordImage.setBounds(856, 140, 500, 500);
        swordImage.setIcon(new ImageIcon("Images\\swordImage.png"));
        swordImage.setVisible(true);

        for (JButton jButton : mainPanel.getMainButtons()) {
            jButton.addActionListener(this);
        }

        subPanelsArrayList.add(namePanel.getPanel());
        subPanelsArrayList.add(classPanel.getPanel());
        subPanelsArrayList.add(appearancePanel.getPanel());
        subPanelsArrayList.add(genderPanel.getPanel());
        
        this.add(helmImage);
        this.add(swordImage);
        this.add(charImage);

        this.add(mainPanel.getButtonsPanel());
        this.add(namePanel.getPanel());
        this.add(genderPanel.getPanel());
        this.add(namePanel.getPanel());
        this.add(classPanel.getPanel());
        this.add(appearancePanel.getPanel());

		this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mainPanel.charNameButton)
        {
            for (JPanel panel : subPanelsArrayList) {
                if(panel == namePanel.getPanel())
                {
                    panel.setVisible(true);
                }
                else panel.setVisible(false);
            }
        }
        else if(e.getSource() == mainPanel.charGenderButton)
        {
            for (JPanel panel : subPanelsArrayList) {
                if(panel == genderPanel.getPanel())
                {
                    panel.setVisible(true);
                }
                else panel.setVisible(false);
            }
        }
        else if(e.getSource() == mainPanel.charClassButton)
        {
            for (JPanel panel : subPanelsArrayList) {
                if(panel == classPanel.getPanel())
                {
                    panel.setVisible(true);
                }
                else panel.setVisible(false);
            }
        }
        else if(e.getSource() == mainPanel.charAppearenceButton)
        {
            for (JPanel panel : subPanelsArrayList) {
                if(panel == appearancePanel.getPanel())
                {
                    panel.setVisible(true);
                }
                else panel.setVisible(false);
            }
        }
    }
    
}
