package Scripts.CharCreationManagement;

import javax.swing.*;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.Screens.CharacterCreation;
import Scripts.CharCreationManagement.Screens.MainMenu;
import Scripts.CharCreationManagement.Screens.SearchCharacter;

import java.awt.*;

public class CardManager extends JFrame {
    static CardManager instance;

    public static CardManager getInstance() {
        if (instance == null) {
            instance = new CardManager();
        }
        return instance;
    }

    private CardManager() {
        super("App");
        
        AudioHandler.audioPlay(AudioHandler.charCreationTheme);

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
