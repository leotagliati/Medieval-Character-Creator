package Scripts.CharCreationManagement.Screens;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.CardManager;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import Scripts.LoginManagement.Screens.TelaLogin;

public class MainMenu extends JPanel {
    GridBagConstraints gbc = new GridBagConstraints();
    ArrayList<JButton> buttonsArray = new ArrayList<JButton>();
    ArrayList<JLabel> buttonsDesignArray = new ArrayList<JLabel>();

    JButton characterCreationButton = new JButton("Criar Personagem");
    JButton searchCharacterButton = new JButton("Buscar Personagem");
    JButton exitButton = new JButton("Sair do Jogo");

    JPanel backGNDPanel;

    public MainMenu() {
        super();
        this.setLayout(null);
        this.setBackground(Color.GRAY);

        ImageCreate backGNDScenario = new ImageCreate(0, 0, 1920, 1080);
        backGNDScenario.setIconFile("Images\\scenario.gif");
        backGNDScenario.imageSetter();

        GridLayout buttonsLayout = new GridLayout();
        buttonsLayout.setColumns(1);
        buttonsLayout.setRows(this.buttonsArray.size());
        buttonsLayout.setVgap(10);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBounds(1520, 600, 400, 400);
        buttonsPanel.setVisible(true);
        buttonsPanel.setOpaque(false);
        buttonsPanel.setBackground(Color.GREEN);
        buttonsPanel.setLayout(buttonsLayout);

        // Add os botoes no arrayList
        buttonsArray.add(characterCreationButton);
        buttonsArray.add(searchCharacterButton);
        buttonsArray.add(exitButton);

        // Inicializa as molduras dos botoes
        for (int i = 0; i < this.buttonsArray.size(); i++) {
            ImageCreate backgroundImage = new ImageCreate(0, 0, 300, 100);
            backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
            backgroundImage.setIconFile("Images\\button3.png");
            backgroundImage.imageSetter();
            buttonsDesignArray.add(backgroundImage);
        }

        for (JButton button : buttonsArray) {
            button.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 34));
            button.setForeground(Color.WHITE);
            button.setOpaque(true);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusable(false);
            buttonsPanel.add(button);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    AudioHandler.audioPlay(AudioHandler.buttonEntered);
                    buttonsDesignArray.get(buttonsArray.indexOf(button))
                            .setIcon(new ImageIcon("Images\\button3Clicked.png"));
                    ;
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    buttonsDesignArray.get(buttonsArray.indexOf(button)).setIcon(new ImageIcon("Images\\button3.png"));
                    ;
                }
            });
        }

        this.backGNDPanel = new JPanel();
        this.backGNDPanel.setLayout(buttonsLayout);
        this.backGNDPanel.setBounds(1520, 600, 400, 400);
        this.backGNDPanel.setOpaque(false);
        this.backGNDPanel.setBackground(Color.GREEN);

        for (JLabel buttonImage : buttonsDesignArray) {
            backGNDPanel.add(buttonImage);
        }

        this.add(buttonsPanel);
        this.add(backGNDPanel);
        this.add(backGNDScenario);

        // ---------- Navegação pelas telas -----------

        characterCreationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AudioHandler.audioPlay(AudioHandler.buttonClicked);
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Criar Personagem");
            }
        });

        searchCharacterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AudioHandler.audioPlay(AudioHandler.buttonClicked);
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Buscar Personagem");
                SearchCharacter.updateNamesPanel();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AudioHandler.audioPlay(AudioHandler.buttonClicked);
                
                AudioHandler.audioStop(AudioHandler.charCreationTheme);

                TelaLogin.resetInstance();
                TelaLogin telaLogin = TelaLogin.getInstance();
                TelaLogin.n = 1; // Update static variable
                telaLogin.loadLanguage(); // Reload ResourceBundle and update UI
                telaLogin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                telaLogin.setVisible(true); // Show the updated login screen
                CardManager.getInstance().dispose();

            }
        });
    }
}