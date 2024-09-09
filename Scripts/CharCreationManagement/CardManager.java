package Scripts.CharCreationManagement;

import javax.swing.*;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.Screens.CharacterCreation;
import Scripts.CharCreationManagement.Screens.MainMenu;
import Scripts.CharCreationManagement.Screens.SearchCharacter;

import java.awt.*;

public class CardManager extends JFrame {
    public CardManager() {
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
