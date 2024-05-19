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
import javax.swing.SwingConstants;

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
		this.setSize(2560, 1080);
        this.getContentPane().setBackground(Color.BLACK);
		this.setLayout(null);
        
        ChosenAttPanel.setupPanel();

        JLabel UIimage = new JLabel();
        UIimage.setLayout(new FlowLayout());
        UIimage.setBounds(1080, 0, 500, 750);
        UIimage.setIcon(new ImageIcon("Images\\hud1.png"));
        UIimage.setHorizontalAlignment(JLabel.CENTER);
        UIimage.setVerticalAlignment(JLabel.CENTER);
        UIimage.setForeground(Color.RED);
        // UIimage.setOpaque(true);
        UIimage.setVisible(true);

        // Image Setter
        JLabel charImage = new JLabel();
        charImage.setLayout(null);
        charImage.setIcon(new ImageIcon("Images\\charImage.png"));
        charImage.setVisible(true);
        charImage.setHorizontalAlignment(JLabel.CENTER);
        charImage.setVerticalAlignment(JLabel.CENTER);
        charImage.setBounds(UIimage.getLocation().x, UIimage.getLocation().y, 500, 800);
        // charImage.setOpaque(true);
        
        JLabel helmImage = new JLabel();
        helmImage.setLayout(null);
        helmImage.setIcon(new ImageIcon("Images\\helmImage.png"));
        helmImage.setHorizontalAlignment(JLabel.CENTER);
        helmImage.setVerticalAlignment(JLabel.CENTER);
        helmImage.setBounds(UIimage.getLocation().x, UIimage.getLocation().y, 500, 800);
        helmImage.setVisible(true);

        JLabel swordImage = new JLabel();
        swordImage.setLayout(null);
        swordImage.setIcon(new ImageIcon("Images\\torsoImage.png"));
        swordImage.setHorizontalAlignment(JLabel.CENTER);
        swordImage.setVerticalAlignment(JLabel.CENTER);
        swordImage.setBounds(UIimage.getLocation().x, UIimage.getLocation().y, 500, 800);
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
