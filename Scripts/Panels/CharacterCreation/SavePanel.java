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
import Scripts.ImagesConversion.ImageCreate;
import Scripts.ImagesConversion.Enums.ChestTypes;
import Scripts.ImagesConversion.Enums.EyeColorTypes;
import Scripts.ImagesConversion.Enums.HelmetTypes;
import Scripts.ImagesConversion.Enums.LegsTypes;
import Scripts.ImagesConversion.Enums.PhysicTypes;
import Scripts.ImagesConversion.Enums.SkinColorTypes;
import Scripts.Model.GameCharacter;
import Scripts.Repository.CharacterRepository;

public class SavePanel extends JPanel {
    private static SavePanel instance;
    private GameCharacter charInstance;

    public JLabel nameInput, classInput;
    public HelmetTypes helmInput;
    public ChestTypes chestInput;
    public LegsTypes legsInput;
    public EyeColorTypes eyesInput;
    public SkinColorTypes skinInput;
    public PhysicTypes physicInput;
    private JLabel nameTitle, classTitle;
    private ArrayList<JLabel> textArray = new ArrayList<JLabel>();

    private JButton saveButton = new JButton("Salvar");

    private JPanel titlesPanel = new JPanel();

    private SavePanel() {

    }

    public static SavePanel getInstance() {
        if (instance == null) {
            instance = new SavePanel();
        }
        return instance;
    }

    public void initPanel(GameCharacter character) {
        charInstance = character;

        CharacterRepository repo = new CharacterRepository();

        // Set propriedade do objeto
        this.setBounds(425, 50, 500, 700);
        this.setBackground(Color.BLUE);
        this.setOpaque(false);
        this.setLayout(null);
        this.setVisible(true);

        // Inicializa os Textos
        nameTitle = new JLabel("Nome: ");
        classTitle = new JLabel("Classe: ");

        // Inicialize os atributos
        nameInput = new JLabel(character.getName());
        classInput = new JLabel(character.getSkillClass());
        eyesInput = character.getEyeColor();
        skinInput = character.getSkinColor();
        physicInput = character.getPhysicType();
        helmInput = character.getHelmTypes();
        chestInput = character.getChestTypes();
        legsInput = character.getLegsTypes();

        // Add os textos ao array
        textArray.add(nameTitle);
        textArray.add(classTitle);
        textArray.add(nameInput);
        textArray.add(classInput);

        // Cria o design do botao
        ImageCreate buttonImage = new ImageCreate(100, 500, 300, 100);
        buttonImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
        buttonImage.setIconFile("Images\\button.png");
        buttonImage.imageSetter();

        // Inicializa o botao SALVAR
        saveButton.setBounds(100, 500, 300, 100);
        saveButton.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 34));
        saveButton.setForeground(Color.WHITE);
        saveButton.setOpaque(true);
        saveButton.setContentAreaFilled(false);
        saveButton.setBorderPainted(false);
        saveButton.setFocusable(false);
        saveButton.setVisible(true);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nameInput.getText().equals("Entrada incompleta")) {
                    AudioHandler.audioPlay("Music\\charSaved.wav");
                    saveButton.setText("Salvo!");
                    buttonImage.setIconFile("Images\\charSavedButton.png");
                    buttonImage.imageSetter();
                    
                    repo.addCharacter(new GameCharacter(nameInput.getText(), classInput.getText(), eyesInput,
                            skinInput, physicInput, helmInput, chestInput, legsInput));

                } else {
                    AudioHandler.audioPlay("Music\\charNotSaved.wav");
                    saveButton.setText("Insira seu nome!");
                    buttonImage.setIconFile("Images\\charNotSavedButton.png");
                    buttonImage.imageSetter();

                }

            }
        });
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == saveButton) {
                    buttonImage.setIcon(new ImageIcon("Images\\buttonClicked.png"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == saveButton) {
                    saveButton.setText("Salvar");
                    buttonImage.setIcon(new ImageIcon("Images\\button.png"));
                }
            }
        });

        GridLayout layout = new GridLayout();
        layout.setColumns(2);
        layout.setRows(2);
        layout.setVgap(20);
        layout.setHgap(20);

        for (int i = 0; i < textArray.size(); i++) {
            textArray.get(i).setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 30));
            textArray.get(i).setOpaque(false);
            textArray.get(i).setForeground(Color.WHITE);
            textArray.get(i).setBorder(null);
            if (i == 0 || i == 1) {
                textArray.get(i).setHorizontalAlignment(JLabel.RIGHT);
            } else
                textArray.get(i).setHorizontalAlignment(JLabel.CENTER);
        }
        nameInput.setForeground(Color.RED);

        // Set propriedade do painel de fundo
        titlesPanel.setBounds(-50, 150, 500, 100);
        titlesPanel.setBackground(Color.GREEN);
        titlesPanel.setOpaque(false);
        titlesPanel.setLayout(layout);
        titlesPanel.setVisible(true);
        titlesPanel.add(nameTitle);
        titlesPanel.add(nameInput);
        titlesPanel.add(classTitle);
        titlesPanel.add(classInput);

        // Add componentes ao objeto
        this.add(titlesPanel);
        this.add(saveButton);
        this.add(buttonImage);
    }

    public void updatePanel(GameCharacter character) {
        nameInput.setText(character.getName());
        classInput.setText(character.getSkillClass());
        eyesInput = character.getEyeColor();
        skinInput = character.getSkinColor();
        physicInput = character.getPhysicType();
        helmInput = character.getHelmTypes();
        chestInput = character.getChestTypes();
        legsInput = character.getLegsTypes();
    }

    public GameCharacter getCharInstance() {
        return charInstance;
    }
}