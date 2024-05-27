package Scripts.Panels.CharacterCreation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import Scripts.ImagesConversion.CharacterDisplay;
import Scripts.ImagesConversion.ImageCreate;
import Scripts.Screens.CharacterCreation;

public class ClassPanel extends JPanel {
    SavePanel singlePanel = SavePanel.getInstance();

    public JButton knightClassButton, heraldClassButton, sorcererClassButton, clericClassButton;
    private ArrayList<JButton> classButtons = new ArrayList<JButton>();
    private ArrayList<JLabel> buttonsImage = new ArrayList<JLabel>();
    private JPanel backGNDPanel;

    private static String classChosen = "Cavaleiro";

    public ClassPanel() {
        super();

        // Inicializa os Botoes
        this.knightClassButton = new JButton("Cavaleiro");
        this.heraldClassButton = new JButton("Arauto");
        this.sorcererClassButton = new JButton("Feiticeiro");
        this.clericClassButton = new JButton("Clérigo");

        // Add os botoes no arrayList
        this.classButtons.add(knightClassButton);
        this.classButtons.add(heraldClassButton);
        this.classButtons.add(sorcererClassButton);
        this.classButtons.add(clericClassButton);

        GridLayout buttonsLayout = new GridLayout();
        buttonsLayout.setColumns(1);
        buttonsLayout.setRows(this.classButtons.size());
        buttonsLayout.setVgap(30);

        // Inicializa as molduras dos botoes
        for (int i = 0; i < this.classButtons.size(); i++) {
            ImageCreate backgroundImage = new ImageCreate(0, 0, 350, 100);
            backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
            backgroundImage.setIconFile("Images\\underName.png");
            backgroundImage.imageSetter();
            buttonsImage.add(backgroundImage);
        }
        // Altera propriedades dos botoes
        for (JButton jButton : this.classButtons) {
            jButton.setFont(new Font("Adobe Garamond Pro", Font.ITALIC, 25));
            jButton.setForeground(Color.WHITE);
            jButton.setOpaque(true);
            jButton.setContentAreaFilled(false);
            jButton.setBorderPainted(false);
            jButton.setFocusable(false);
            jButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (e.getSource() == jButton) {
                        buttonsImage.get(classButtons.indexOf(jButton))
                                .setIcon(new ImageIcon("Images\\underNameEntered.png"));
                        ;
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (e.getSource() == jButton) {
                        buttonsImage.get(classButtons.indexOf(jButton)).setIcon(new ImageIcon("Images\\underName.png"));
                        ;
                    }

                }
            });

        }
        // Inicializa o painel de fundo
        this.backGNDPanel = new JPanel();
        this.backGNDPanel.setLayout(buttonsLayout);
        this.backGNDPanel.setBounds(500, 200, 350, 400);
        this.backGNDPanel.setOpaque(false);
        this.backGNDPanel.setBackground(Color.GREEN);
        this.backGNDPanel.setVisible(false);

        this.setLayout(buttonsLayout);
        this.setBounds(500, 200, 350, 400);
        this.setOpaque(false);
        this.setBackground(Color.BLUE);

        for (JButton jButton : this.classButtons) {
            this.add(jButton);
        }
        for (JLabel jLabel : buttonsImage) {
            backGNDPanel.add(jLabel);
        }

        this.backGNDPanel.setVisible(false);
        this.setVisible(false);

        for (JButton jButton : classButtons) {

            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                    for (JButton jButton : classButtons) {
                        if (e.getSource() == jButton) {
                            classChosen = jButton.getText();
                            setVisible(false);
                            backGNDPanel.setVisible(false);
                            CharacterDisplay.updateImages(CharacterCreation.panel);
                            singlePanel.setVisible(true);
                            singlePanel.getCharInstance().setSkillClass(classChosen);
                            singlePanel.updatePanel(singlePanel.getCharInstance());
                        }
                    }
                }

            });
        }

    }

    public ArrayList<JButton> getButtonsArray() {
        return classButtons;
    }

    public static String getClassChosen() {
        return classChosen;
    }

    public JPanel getBackGNDPanel() {
        return backGNDPanel;
    }
}
