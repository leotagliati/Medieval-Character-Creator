package Scripts.Screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Scripts.AudioHandler;
import Scripts.ImagesConversion.CharacterDisplay;
import Scripts.ImagesConversion.ImageCreate;
import Scripts.ImagesConversion.ShowPanel;
import Scripts.Model.GameCharacter;
import Scripts.Panels.CharacterCreation.AppearancePanel;
import Scripts.Panels.CharacterCreation.ClassPanel;
import Scripts.Panels.CharacterCreation.MainPanel;
import Scripts.Panels.CharacterCreation.NamePanel;
import Scripts.Panels.CharacterCreation.SavePanel;
import Scripts.Panels.CharacterCreation.GarmentsPanel;

public class CharacterCreation extends JPanel implements ActionListener {
    ArrayList<JPanel> subPanelsArrayList = new ArrayList<JPanel>();

    MainPanel mainPanel = new MainPanel();
    NamePanel namePanel = new NamePanel();
    GarmentsPanel garmentsPanel = new GarmentsPanel();
    ClassPanel classPanel = new ClassPanel();
    AppearancePanel appearancePanel = new AppearancePanel();
    SavePanel savePanel = SavePanel.getInstance();

    public static ShowPanel panel = new ShowPanel();

    GameCharacter char1 = new GameCharacter(namePanel.getNameInput().getText(), ClassPanel.getClassChosen(),
            AppearancePanel.eyesType, AppearancePanel.skinType, GarmentsPanel.helmetType,
            GarmentsPanel.chestType, GarmentsPanel.legsType);

    public CharacterCreation() {
        super();
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        savePanel.initPanel(char1);
        CharacterDisplay.setupImages(panel);

        // Image Setter
        ImageCreate backgroundImage = new ImageCreate(425, 50, 500, 700);
        backgroundImage.setIconFile("Images\\subpanelBackground.png");
        backgroundImage.imageSetter();

        for (JButton jButton : MainPanel.getButtonsArray()) {
            jButton.addActionListener(this);
            jButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (e.getSource() == jButton && jButton.isEnabled()) {
                        mainPanel.getButtonsDesignArray().get(MainPanel.getButtonsArray().indexOf(jButton))
                                .setIcon(new ImageIcon("Images\\buttonClicked.png"));
                    }
                    else mainPanel.getButtonsDesignArray().get(MainPanel.getButtonsArray().indexOf(jButton))
                    .setIcon(new ImageIcon("Images\\button.png"));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (e.getSource() == jButton && jButton.isEnabled()) {
                        mainPanel.getButtonsDesignArray().get(MainPanel.getButtonsArray().indexOf(jButton))
                                .setIcon(new ImageIcon("Images\\button.png"));
                    }
                    else mainPanel.getButtonsDesignArray().get(MainPanel.getButtonsArray().indexOf(jButton))
                    .setIcon(new ImageIcon("Images\\button.png"));
                }
            });
        }

        subPanelsArrayList.add(namePanel);
        subPanelsArrayList.add(classPanel.getBackGNDPanel());
        subPanelsArrayList.add(classPanel);
        subPanelsArrayList.add(appearancePanel);
        subPanelsArrayList.add(garmentsPanel);

        this.add(backgroundImage);
        this.add(panel);
        this.add(mainPanel);
        this.add(mainPanel.getBackPanel());
        this.add(namePanel);
        this.add(garmentsPanel);
        this.add(classPanel);
        this.add(classPanel.getBackGNDPanel());
        this.add(appearancePanel);
        this.add(savePanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == mainPanel.returnButton) {
            AudioHandler.audioPlay("Music\\buttonClicked2.wav");
            CardLayout cardLayout = (CardLayout) getParent().getLayout();
            cardLayout.first(getParent());
        } else {
            AudioHandler.audioPlay("Music\\buttonClicked.wav");
            savePanel.setVisible(false);
            for (JButton button : MainPanel.getButtonsArray()) {
                button.setEnabled(false);
            }
            if (e.getSource() == mainPanel.charNameButton) {
                for (JPanel panel : subPanelsArrayList) {
                    if (panel == namePanel) {
                        panel.setVisible(true);
                        panel.setEnabled(true);
                    } else
                        panel.setVisible(false);
                }
            }

            else if (e.getSource() == mainPanel.charVestureButton) {
                for (JPanel panel : subPanelsArrayList) {
                    if (panel == garmentsPanel) {
                        panel.setVisible(true);

                    } else
                        panel.setVisible(false);
                }
            }

            else if (e.getSource() == mainPanel.charClassButton) {
                for (JPanel panel : subPanelsArrayList) {
                    if (panel == classPanel) {
                        panel.setVisible(true);
                        classPanel.getBackGNDPanel().setVisible(true);

                    } else
                        panel.setVisible(false);
                }
            }

            else if (e.getSource() == mainPanel.charAppearenceButton) {
                for (JPanel panel : subPanelsArrayList) {
                    if (panel == appearancePanel) {
                        panel.setVisible(true);

                    } else
                        panel.setVisible(false);
                }
            }
        }
    }
}
