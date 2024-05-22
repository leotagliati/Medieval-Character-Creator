package Scripts.Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel
{
    GridBagConstraints gbc = new GridBagConstraints();

    public MainMenu()
    {
        super();
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.GRAY);

        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridwidth = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Menu");
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(title, gbc);

        JButton characterCreationButton = new JButton("Criar Personagem");
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(characterCreationButton, gbc);

        JButton searchCharacterButton = new JButton("Buscar Personagem");
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(searchCharacterButton, gbc);

        JButton deleteCharacterButton = new JButton("Deletar Personagem");
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(deleteCharacterButton, gbc);

        JButton exitButton = new JButton("Sair");
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(exitButton, gbc);

        // ---------- Navegação pelas telas -----------

        characterCreationButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Criar Personagem");
            }
        });

        searchCharacterButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Buscar Personagem");
            }
        });

        deleteCharacterButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Deletar Personagem");
            }
        });

        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }
        });
    }
}