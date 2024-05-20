import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Scripts.ImageCreate;
import Scripts.Panels.AppearancePanel;
import Scripts.Panels.ChosenAttPanel;
import Scripts.Panels.ClassPanel;
import Scripts.Panels.GenderPanel;
import Scripts.Panels.MainPanel;
import Scripts.Panels.NamePanel;
import Scripts.Panels.VesturePanel;

public class MainFrame extends JFrame implements ActionListener{
    
    
    ArrayList<JPanel> subPanelsArrayList = new ArrayList<JPanel>();
    
    
    MainPanel mainPanel = new MainPanel();
    NamePanel namePanel = new NamePanel();
    VesturePanel vesturePanel = new VesturePanel();
    GenderPanel genderPanel = new GenderPanel();
    ClassPanel classPanel = new ClassPanel();
    AppearancePanel appearancePanel = new AppearancePanel();


    MainFrame()
    {
        super("Character Creation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(2560, 1080);
        this.getContentPane().setBackground(Color.BLACK);
		this.setLayout(null);
        
        ChosenAttPanel.setupPanel();

        ImageCreate backgroundImage = new ImageCreate(425, 50, 500, 700);
        backgroundImage.setAlignment(JLabel.ABORT, JLabel.ABORT);
        backgroundImage.setIconFile("Images\\subpanelBackground.png");
        backgroundImage.imageSetter();

        // Image Setter
        ImageCreate UIimage = new ImageCreate(1080, 0, 500, 750);
        UIimage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        UIimage.setIconFile("Images\\hud1.png");
        UIimage.imageSetter();

        ImageCreate charImage = new ImageCreate(1080, 0, 500, 750);
        charImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        charImage.setIconFile("Images\\charImage.png");
        charImage.imageSetter();
        
        ImageCreate helmImage = new ImageCreate(1080, 0, 500, 750);
        helmImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        helmImage.setIconFile("Images\\helmImage.png");
        helmImage.imageSetter();

        ImageCreate swordImage = new ImageCreate(1080, 0, 500, 750);
        swordImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        swordImage.setIconFile("Images\\torsoImage.png");
        swordImage.imageSetter();


        for (JButton jButton : mainPanel.getMainButtons()) {
            jButton.addActionListener(this);
            jButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e)
                {
                    if(e.getSource() == jButton)
                    {
                        mainPanel.getButtonsImage().get(mainPanel.getMainButtons().indexOf(jButton)).setIcon(new ImageIcon("Images\\buttonClicked.png"));
                    }
                }
                @Override
                public void mouseExited(MouseEvent e){
                    if(e.getSource() == jButton)
                    {
                        mainPanel.getButtonsImage().get(mainPanel.getMainButtons().indexOf(jButton)).setIcon(new ImageIcon("Images\\button.png"));
                    }
                }
            });
        }
        subPanelsArrayList.add(namePanel);
        subPanelsArrayList.add(classPanel.getBackgJPanel());
        subPanelsArrayList.add(classPanel);
        subPanelsArrayList.add(appearancePanel);
        subPanelsArrayList.add(vesturePanel);
        
        this.add(backgroundImage);
        this.add(UIimage);
        this.add(helmImage);
        this.add(swordImage);
        this.add(charImage);
        
        this.add(mainPanel);
        this.add(mainPanel.getBackgJPanel());
        this.add(namePanel);
        this.add(vesturePanel);
        this.add(classPanel);
        this.add(classPanel.getBackgJPanel());
        this.add(appearancePanel);
        this.add(ChosenAttPanel.getPanel());

		this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mainPanel.charNameButton)
        {
            
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
        else if(e.getSource() == mainPanel.charVestureButton)
        {
            
            for (JPanel panel : subPanelsArrayList) {
                if(panel == vesturePanel)
                {
                    panel.setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(false);

                }
                else panel.setVisible(false);
            }
        }
        else if(e.getSource() == mainPanel.charClassButton)
        {
            
            for (JPanel panel : subPanelsArrayList) {
                if(panel == classPanel)
                {
                    panel.setVisible(true);
                    classPanel.getBackgJPanel().setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(false);

                }
                else panel.setVisible(false);
            }
        }
        else if(e.getSource() == mainPanel.charAppearenceButton)
        {
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
