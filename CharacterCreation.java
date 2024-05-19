import java.awt.Color;
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
import Scripts.Panels.ChosenAttPanel;
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
        this.getContentPane().setBackground(Color.BLACK);
		this.setLayout(null);
        
        ChosenAttPanel.setupPanel();

        JLabel UIimage = new JLabel();
        UIimage.setLayout(new FlowLayout());
        UIimage.setBounds(800, -100, 500, 1000);
        UIimage.setIcon(new ImageIcon("Images\\hud1.png"));
        UIimage.setVisible(true);

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
        subPanelsArrayList.add(namePanel);
        subPanelsArrayList.add(classPanel);
        subPanelsArrayList.add(appearancePanel);
        subPanelsArrayList.add(genderPanel);
        
        this.add(UIimage);
        this.add(helmImage);
        this.add(swordImage);
        this.add(charImage);

        this.add(mainPanel);
        this.add(mainPanel.getBackgJPanel());
        this.add(namePanel);
        this.add(genderPanel);
        this.add(classPanel);
        this.add(appearancePanel);
        this.add(ChosenAttPanel.getPanel());

		this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mainPanel.charNameButton)
        {
            mainPanel.getButtonsImageLabel().get(0).setIcon(new ImageIcon("Images\\buttonClicked.png"));
            mainPanel.getButtonsImageLabel().get(1).setIcon(new ImageIcon("Images\\button.png"));
            mainPanel.getButtonsImageLabel().get(2).setIcon(new ImageIcon("Images\\button.png"));
            mainPanel.getButtonsImageLabel().get(3).setIcon(new ImageIcon("Images\\button.png"));
            for (JPanel panel : subPanelsArrayList) {
                if(panel == namePanel)
                {
                    panel.setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(false);
                    panel.setEnabled(true);
                }
                else panel.setVisible(false);
            }
        }
        else if(e.getSource() == mainPanel.charGenderButton)
        {
            mainPanel.getButtonsImageLabel().get(0).setIcon(new ImageIcon("Images\\button.png"));
            mainPanel.getButtonsImageLabel().get(1).setIcon(new ImageIcon("Images\\buttonClicked.png"));
            mainPanel.getButtonsImageLabel().get(2).setIcon(new ImageIcon("Images\\button.png"));
            mainPanel.getButtonsImageLabel().get(3).setIcon(new ImageIcon("Images\\button.png"));
            for (JPanel panel : subPanelsArrayList) {
                if(panel == genderPanel)
                {
                    panel.setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(false);

                }
                else panel.setVisible(false);
            }
        }
        else if(e.getSource() == mainPanel.charClassButton)
        {
            mainPanel.getButtonsImageLabel().get(0).setIcon(new ImageIcon("Images\\button.png"));
            mainPanel.getButtonsImageLabel().get(1).setIcon(new ImageIcon("Images\\button.png"));
            mainPanel.getButtonsImageLabel().get(2).setIcon(new ImageIcon("Images\\buttonClicked.png"));
            mainPanel.getButtonsImageLabel().get(3).setIcon(new ImageIcon("Images\\button.png"));
            for (JPanel panel : subPanelsArrayList) {
                if(panel == classPanel)
                {
                    panel.setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(false);

                }
                else panel.setVisible(false);
            }
        }
        else if(e.getSource() == mainPanel.charAppearenceButton)
        {
            mainPanel.getButtonsImageLabel().get(0).setIcon(new ImageIcon("Images\\button.png"));
            mainPanel.getButtonsImageLabel().get(1).setIcon(new ImageIcon("Images\\button.png"));
            mainPanel.getButtonsImageLabel().get(2).setIcon(new ImageIcon("Images\\button.png"));
            mainPanel.getButtonsImageLabel().get(3).setIcon(new ImageIcon("Images\\buttonClicked.png"));
            for (JPanel panel : subPanelsArrayList) {
                if(panel == appearancePanel)
                {
                    panel.setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(false);

                }
                else panel.setVisible(false);
            }
        }
    }
    
}
