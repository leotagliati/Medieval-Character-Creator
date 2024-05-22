package Scripts.Screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Scripts.AudioHandler;
import Scripts.ImageCreate;
import Scripts.Panels.CharacterCreation.AppearancePanel;
import Scripts.Panels.CharacterCreation.ChosenAttPanel;
import Scripts.Panels.CharacterCreation.ClassPanel;
import Scripts.Panels.CharacterCreation.MainPanel;
import Scripts.Panels.CharacterCreation.NamePanel;
import Scripts.Panels.CharacterCreation.GarmentsPanel;

public class CharacterCreation extends JPanel implements ActionListener
{
    ArrayList<JPanel> subPanelsArrayList = new ArrayList<JPanel>();

    MainPanel mainPanel = new MainPanel();
    NamePanel namePanel = new NamePanel();
    GarmentsPanel garmentsPanel = new GarmentsPanel();
    ClassPanel classPanel = new ClassPanel();
    AppearancePanel appearancePanel = new AppearancePanel();

    public CharacterCreation()
    {
        super();
		this.setLayout(null);
        this.setBackground(Color.BLACK);
        
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


        for (JButton jButton : mainPanel.getButtonsArray()) {
            jButton.addActionListener(this);
            jButton.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseEntered(MouseEvent e)
                {
                    if(e.getSource() == jButton)
                    {
                        mainPanel.getButtonsDesignArray().get(mainPanel.getButtonsArray().indexOf(jButton)).setIcon(new ImageIcon("Images\\buttonClicked.png"));
                    }
                }
                @Override
                public void mouseExited(MouseEvent e){
                    if(e.getSource() == jButton)
                    {
                        mainPanel.getButtonsDesignArray().get(mainPanel.getButtonsArray().indexOf(jButton)).setIcon(new ImageIcon("Images\\button.png"));
                    }
                }
            });
        }

        subPanelsArrayList.add(namePanel);
        subPanelsArrayList.add(classPanel.getBackGNDPanel());
        subPanelsArrayList.add(classPanel);
        subPanelsArrayList.add(appearancePanel);
        subPanelsArrayList.add(garmentsPanel);
        
        this.add(backgroundImage);
        this.add(UIimage);
        this.add(helmImage);
        this.add(swordImage);
        this.add(charImage);
        
        this.add(mainPanel);
        this.add(mainPanel.getBackPanel());
        this.add(namePanel);
        this.add(garmentsPanel);
        this.add(classPanel);
        this.add(classPanel.getBackGNDPanel());
        this.add(appearancePanel);
        this.add(ChosenAttPanel.getPanel());
        this.add(ChosenAttPanel.getBackGNDPanel());

        mainPanel.returnButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.first(getParent());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        AudioHandler.audioPlay("Music\\buttonClicked.wav");

        if(e.getSource() == mainPanel.charNameButton)
        {
            for (JPanel panel : subPanelsArrayList)
            {
                if(panel == namePanel)
                {
                    panel.setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(false);
                    ChosenAttPanel.getBackGNDPanel().setVisible(false);
                    panel.setEnabled(true);
                }
                else panel.setVisible(false);
            }
        }

        else if(e.getSource() == mainPanel.charVestureButton)
        {
            for (JPanel panel : subPanelsArrayList)
            {
                if(panel == garmentsPanel)
                {
                    panel.setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(false);
                    ChosenAttPanel.getBackGNDPanel().setVisible(false);

                }
                else panel.setVisible(false);
            }
        }

        else if(e.getSource() == mainPanel.charClassButton)
        {
            for (JPanel panel : subPanelsArrayList)
            {
                if(panel == classPanel)
                {
                    panel.setVisible(true);
                    classPanel.getBackGNDPanel().setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(false);
                    ChosenAttPanel.getBackGNDPanel().setVisible(false);

                }
                else panel.setVisible(false);
            }
        }

        else if(e.getSource() == mainPanel.charAppearenceButton)
        {
            for (JPanel panel : subPanelsArrayList)
            {
                if(panel == appearancePanel)
                {
                    panel.setVisible(true);
                    ChosenAttPanel.getPanel().setVisible(false);
                    ChosenAttPanel.getBackGNDPanel().setVisible(false);

                }
                else panel.setVisible(false);
            }
        }
    }
}
