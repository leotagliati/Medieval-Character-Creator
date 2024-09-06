package Scripts.CharCreationManagement.Screens;

import javax.swing.*;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.Visual.ImagesConversion.CharacterDisplay;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ShowPanel;
import Scripts.CharCreationManagement.Visual.ImagesConversion.StringToPath;
import Scripts.CharCreationManagement.Model.GameCharacter;
import Scripts.CharCreationManagement.Repository.CharacterRepository;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SearchCharacter extends JPanel {
    static ArrayList<GameCharacter> charArray = new ArrayList<>();
    ArrayList<JButton> buttonsArray = new ArrayList<>();
    static ArrayList<String> charNamesArray = new ArrayList<>();
    static ArrayList<JLabel> nameLabelArray = new ArrayList<>();
    ArrayList<JTextField> charClassesArray = new ArrayList<>();
    JScrollPane charDataPanel;

    private JTextField titleText = new JTextField("Personagens Criados");
    static JPanel insidePanel = new JPanel();
    static GameCharacter charSelected;
    public static ShowPanel displayCharPanel = new ShowPanel();

    public SearchCharacter() {
        super();
        this.setLayout(null);
        this.setBackground(Color.black);

        ImageCreate backgroundImage = new ImageCreate(0, 0, 500, 700);
        backgroundImage.setIconFile("Images\\hud1.png");
        backgroundImage.imageSetter();
        displayCharPanel.add(backgroundImage);

        

        GridLayout buttonsLayout = new GridLayout(charNamesArray.size(), 1, 0, 0);
        insidePanel.setLayout(buttonsLayout);
        insidePanel.setOpaque(false);
        insidePanel.setBackground(Color.BLUE);

        // Set propriedade do titleText
        this.titleText.setBounds(50, 50, 500, 70);
        this.titleText.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 60));
        this.titleText.setHorizontalAlignment(JTextField.CENTER);
        this.titleText.setOpaque(false);
        this.titleText.setBorder(null);
        this.titleText.setForeground(Color.WHITE);
        this.titleText.setEditable(false);
        this.titleText.setVisible(true);

        // Configura o JScrollPane e adiciona o painel dentro dele
        charDataPanel = new JScrollPane(insidePanel);
        this.charDataPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.charDataPanel.setBounds(70, 143, 870, 610);
        this.charDataPanel.setOpaque(false);
        this.charDataPanel.setBorder(null);

        ImageCreate scrollPaneImage = new ImageCreate(-245, -350, 1500, 1600);
        scrollPaneImage.setIconFile("Images\\ScrollPaneBorder.png");
        scrollPaneImage.imageSetter();

        for (String nameData : charNamesArray) {
            charDataPanel.add(new JTextField(nameData));
            for (JTextField classData : charClassesArray) {
                charDataPanel.add(classData);
            }
        }

        JButton returnButton = new JButton("Voltar");
        JButton deleteButton = new JButton("Deletar");
        returnButton.setBounds(130, 800, 300, 100);
        deleteButton.setBounds(520, 800, 300, 100);

        buttonsArray.add(returnButton);
        buttonsArray.add(deleteButton);

        for (JButton button : buttonsArray) {
            button.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 28));
            button.setForeground(Color.WHITE);
            button.setOpaque(true);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusable(false);
        }

        ImageCreate returnButtonImage = new ImageCreate(130, 800, 300, 100);
        returnButtonImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        returnButtonImage.setIconFile("Images\\button.png");
        returnButtonImage.imageSetter();

        ImageCreate deleteButtonImage = new ImageCreate(520, 800, 300, 100);
        deleteButtonImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        deleteButtonImage.setIconFile("Images\\deleteStandardButton.png");
        deleteButtonImage.imageSetter();

        this.add(displayCharPanel);
        this.add(titleText);
        this.add(returnButton);
        this.add(returnButtonImage);
        this.add(deleteButton);
        this.add(deleteButtonImage);
        this.add(charDataPanel);
        this.add(scrollPaneImage);


        // Volta para o menu inicial

        for (JButton button : buttonsArray) {
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == returnButton) {
                        AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                        CardLayout cardLayout = (CardLayout) getParent().getLayout();
                        cardLayout.first(getParent());
                    }
                    if (e.getSource() == deleteButton) {
                        CharacterRepository repo = new CharacterRepository();
                        if (charSelected != null) {
                            AudioHandler.audioPlay("Music\\deleteConfirm.wav");
                            repo.deleteCharacter(charSelected);
                            deleteButtonImage.setIconFile("Images\\deleteStandardButton.png");
                            deleteButtonImage.imageSetter();
                            deleteButton.setText("Deletado!");
                            CharacterDisplay.clearImages(displayCharPanel);
                            CardLayout cardLayout = (CardLayout) getParent().getLayout();
                            cardLayout.first(getParent());
                        } else
                            AudioHandler.audioPlay("Music\\charNotSaved.wav");

                    }
                }
            });
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    AudioHandler.audioPlay("Music\\buttonEntered.wav");
                    if (e.getSource() == returnButton) {
                        returnButtonImage.setIcon(new ImageIcon("Images\\buttonClicked.png"));

                    }
                    if (e.getSource() == deleteButton) {
                        deleteButtonImage.setIcon(new ImageIcon("Images\\deleteConfirmButton.png"));
                        deleteButton.setText("DELETAR");
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (e.getSource() == returnButton) {
                        returnButtonImage.setIcon(new ImageIcon("Images\\button.png"));
                    }
                    if (e.getSource() == deleteButton) {
                        deleteButtonImage.setIcon(new ImageIcon("Images\\deleteStandardButton.png"));
                        deleteButton.setText("Deletar");
                    }
                }
            });
        }
    }

    public static void updateNamesPanel() {
        charSelected = null;
        CharacterRepository repo = new CharacterRepository();
        charArray = repo.GetAllCharcters();
        charNamesArray.clear();
        for (GameCharacter character : charArray) {
            charNamesArray.add(character.getName());

        }
        for (JLabel jLabel : nameLabelArray) {
            insidePanel.remove(jLabel);
        }
        nameLabelArray.clear();
        for (int i = 0; i < charNamesArray.size(); i++) {
            JLabel nameLabel = new JLabel(charNamesArray.get(i));
            int helmetID = charArray.get(i).getHelmTypes().ordinal() + 1;
            int chestID = charArray.get(i).getChestTypes().ordinal() + 1;
            int skinID = charArray.get(i).getSkinColor().ordinal() + 1;
            nameLabel.setIcon(new ImageIcon(StringToPath.convertIcon(
                    (helmetID + "" + chestID + "" + skinID))));
            // System.out.println(helmetID + "" + eyesID + "" + skinID);
            nameLabel.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 30));
            nameLabel.setHorizontalAlignment(JLabel.LEFT);
            nameLabel.setIconTextGap(25);
            nameLabel.setOpaque(true);
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setBackground(new Color(52, 28, 39));
            nameLabel.setBorder(BorderFactory.createLineBorder(new Color(37, 20, 28), 2));
            nameLabelArray.add(nameLabel);
            insidePanel.add(nameLabel);

        }

        for (JLabel nameLabel : nameLabelArray) {
            nameLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // System.out.println(e.getSource());
                    for (JLabel nameLabel : nameLabelArray) {
                        nameLabel.setForeground(Color.WHITE);

                        if (e.getSource() != nameLabel) {
                            nameLabel.setBackground(new Color(52, 28, 39));
                        

                        } else {

                            // Chamar a funcao de updateCharacter
                            nameLabel.setBackground(new Color(215, 135, 49));
                            int pos = nameLabelArray.indexOf(nameLabel);
                            int index = charArray.get(pos).getId();
                            charSelected = repo.searchCharacter(index);
                            CharacterDisplay.findImages(charSelected, displayCharPanel);
                        }
                    }
                }
            });

        }
    }
}
