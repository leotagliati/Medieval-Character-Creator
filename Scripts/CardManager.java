package Scripts;

import Scripts.Screens.MainMenu;
import Scripts.Screens.CharacterCreation;
import Scripts.Screens.SearchCharacter;

import javax.swing.*;
import java.awt.*;

public class CardManager extends JFrame
{
    public CardManager()
    {
        super("App");

        // Carrega todas as telas
        JPanel mainMenu = new MainMenu();
        JPanel characterCreation = new CharacterCreation();
        JPanel searchCharacter = new SearchCharacter();

        // Estrutura o CardLayout
        JPanel cardLayout = new JPanel(new CardLayout());
        cardLayout.add(mainMenu, "Menu");
        cardLayout.add(characterCreation, "Criar Personagem");
        cardLayout.add(searchCharacter, "Buscar Personagem");

        getContentPane().add(cardLayout);
    }
}
