package Scripts.Screens;

import javax.swing.*;

import Scripts.ImagesConversion.ImageCreate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Scripts.AudioHandler;


public class MainMenu extends JPanel
{
    GridBagConstraints gbc = new GridBagConstraints();

    public MainMenu()
    {
        super();
        this.setLayout(null);
        this.setBackground(Color.GRAY);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBounds(1420,500,500,500);
        buttonsPanel.setVisible(true);
        buttonsPanel.setBackground(Color.GREEN);
        buttonsPanel.setLayout(new GridBagLayout());

        ImageCreate backGNDScenario = new ImageCreate(0, 0, 1920, 1080);
        backGNDScenario.setIconFile("Images\\scenario.gif");
        backGNDScenario.imageSetter();
        
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridwidth = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel title = new JLabel("Menu");
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonsPanel.add(title, gbc);
        
        JButton characterCreationButton = new JButton("Criar Personagem");
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonsPanel.add(characterCreationButton, gbc);
        
        JButton searchCharacterButton = new JButton("Buscar Personagem");
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonsPanel.add(searchCharacterButton, gbc);
        
        JButton deleteCharacterButton = new JButton("Deletar Personagem");
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonsPanel.add(deleteCharacterButton, gbc);
        
        JButton exitButton = new JButton("Sair");
        gbc.gridx = 0;
        gbc.gridy = 4;
        buttonsPanel.add(exitButton, gbc);
        
        this.add(buttonsPanel);
        this.add(backGNDScenario);
        
        // ---------- Navegação pelas telas -----------
        
        characterCreationButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Criar Personagem");
            }
        });

        searchCharacterButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Buscar Personagem");
            }
        });

        deleteCharacterButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Deletar Personagem");
            }
        });

        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                AudioHandler.audioPlay("Music\\buttonClicked2.wav");
                System.exit(0);
            }
        });
    }
}