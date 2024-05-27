package Scripts.Screens;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Scripts.AudioHandler;
import Scripts.ImagesConversion.CharacterDisplay;
import Scripts.ImagesConversion.ImageCreate;
import Scripts.ImagesConversion.ShowPanel;
import Scripts.Model.GameCharacter;
import Scripts.Repository.CharacterRepository;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;

public class SearchCharacter extends JPanel {
    static ArrayList<GameCharacter> charArray = new ArrayList<>();
    ArrayList<JButton> buttonsArray = new ArrayList<>();
    static ArrayList<String> charNamesArray = new ArrayList<>();
    ArrayList<JTextField> charClassesArray = new ArrayList<>();
    static ArrayList<JLabel> nameLabelArray = new ArrayList<>();

    private static int[] idLabelArray;

    private JTextField titleText = new JTextField("Personagens Criados");

    static JPanel insidePanel = new JPanel();

    JScrollPane charDataPanel;

    public static ShowPanel displayCharPanel = new ShowPanel();

    public SearchCharacter() {
        super();
        this.setLayout(null);
        this.setBackground(Color.black);

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
        this.charDataPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.charDataPanel.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2));
        this.charDataPanel.setBounds(50, 140, 500, 600);
        this.charDataPanel.setOpaque(false);

        // Adiciona o JScrollPane ao JPanel principal
        this.add(charDataPanel);

        // ImageCreate UIimage = new ImageCreate(1080, 40, 500, 750);
        // UIimage.setIconFile("Images\\hud1.png");
        // UIimage.imageSetter();
        // this.add(UIimage);

        // ImageCreate charImage = new ImageCreate(1080, 0, 500, 750);
        // charImage.setIconFile("Images\\charImage.png");
        // charImage.imageSetter();
        // this.add(charImage);

        // charClassesArray.add(classText);
        // charClassesArray.add(classText2);

        // Adiciona os nomes como JLabels ao painel

        // SearchCharacter.updateLabels();

        for (String nameData : charNamesArray) {
            charDataPanel.add(new JTextField(nameData));
            for (JTextField classData : charClassesArray) {
                charDataPanel.add(classData);
            }
        }

        JButton returnButton = new JButton("Voltar");
        returnButton.setBounds(130, 750, 300, 100);
        returnButton.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 28));
        returnButton.setForeground(Color.WHITE);
        returnButton.setOpaque(true);
        returnButton.setContentAreaFilled(false);
        returnButton.setBorderPainted(false);
        returnButton.setFocusable(false);

        ImageCreate buttonImage = new ImageCreate(130, 750, 300, 100);
        buttonImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        buttonImage.setIconFile("Images\\button.png");
        buttonImage.imageSetter();

        this.add(displayCharPanel);
        this.add(titleText);
        this.add(returnButton);
        this.add(buttonImage);
        this.add(charDataPanel);

        // Volta para o menu inicial

        returnButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.first(getParent());
            }
        });
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == returnButton) {
                    buttonImage.setIcon(new ImageIcon("Images\\buttonClicked.png"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == returnButton) {
                    buttonImage.setIcon(new ImageIcon("Images\\button.png"));
                }
            }
        });
    }

    public static void labels() {

        CharacterRepository repo = new CharacterRepository();
        charArray = repo.GetAllCharcters();
        idLabelArray = new int[charArray.size()];
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
            nameLabel.setIcon(new ImageIcon("Images\\user.png"));
            nameLabel.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 25));
            nameLabel.setHorizontalAlignment(JLabel.LEFT);
            nameLabel.setOpaque(true);
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setBackground(Color.darkGray);
            nameLabel.setBorder(BorderFactory.createEtchedBorder(1));
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
                            nameLabel.setBackground(Color.darkGray);

                        } else {

                            // Chamar a funcao de updateCharacter
                            nameLabel.setBackground(new Color(215, 135, 49));
                            int index = nameLabelArray.indexOf(nameLabel) + 1;
                            // System.out.println(index);
                            GameCharacter charToFind = repo.searchCharacter(index);
                            CharacterDisplay.findImages(charToFind, displayCharPanel);
                            // System.out.println(charToFind.getName());
                            // System.out.println(charToFind.getSkillClass());
                        }
                    }
                }
            });

        }
    }
}
