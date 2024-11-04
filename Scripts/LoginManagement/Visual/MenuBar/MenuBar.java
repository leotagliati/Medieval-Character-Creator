package Scripts.LoginManagement.Visual.MenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Scripts.LoginManagement.Screens.TelaLogin;
import Scripts.CharCreationManagement.Screens.MainMenu;
import Scripts.CharCreationManagement.Screens.SearchCharacter;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        JMenu settingsMenu = new JMenu("Settings");
        JMenu languageMenu = new JMenu("Language");

        // Opções de idiomas
        JMenuItem englishItem = new JMenuItem("English");
        JMenuItem portugueseItem = new JMenuItem("Português");
        JMenuItem germanItem = new JMenuItem("Deutsch");
        JMenuItem frenchItem = new JMenuItem("Français");
        JMenuItem spanishItem = new JMenuItem("Español");
        

        // Action listeners para cada idioma, passando o valor correto para MainMenu
        englishItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.n = 1; // Define o idioma para Inglês
                TelaLogin.getInstance().loadLanguage();
                MainMenu.getInstance().setI(1);
                MainMenu.getInstance().loadLanguage(1);
                SearchCharacter.getInstance().setI(1);
                SearchCharacter.getInstance().loadLanguage(1);
                
            }
        });

        portugueseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.n = 0; // Define o idioma para Português
                TelaLogin.getInstance().loadLanguage();
                MainMenu.getInstance().setI(0);
                MainMenu.getInstance().loadLanguage(0);
                SearchCharacter.getInstance().setI(0);
                SearchCharacter.getInstance().loadLanguage(0);
            }
        });

        germanItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.n = 2; // Define o idioma para Alemão
                TelaLogin.getInstance().loadLanguage();
                MainMenu.getInstance().setI(2);
                MainMenu.getInstance().loadLanguage(2);
                SearchCharacter.getInstance().setI(2);
                SearchCharacter.getInstance().loadLanguage(2);
          
            }
        });

        frenchItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.n = 3; // Define o idioma para Francês
                TelaLogin.getInstance().loadLanguage();
                MainMenu.getInstance().setI(3);
                MainMenu.getInstance().loadLanguage(3);
                SearchCharacter.getInstance().setI(3);
                SearchCharacter.getInstance().loadLanguage(3);
            }
        });

        spanishItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.n = 4; // Define o idioma para Espanhol
                TelaLogin.getInstance().loadLanguage();
                MainMenu.getInstance().setI(4);
                MainMenu.getInstance().loadLanguage(4);
                SearchCharacter.getInstance().setI(4);
                SearchCharacter.getInstance().loadLanguage(4);
            }
        });

        // Adiciona as opções ao menu "Language"
        languageMenu.add(englishItem);
        languageMenu.add(portugueseItem);
        languageMenu.add(germanItem);
        languageMenu.add(frenchItem);
        languageMenu.add(spanishItem);

        settingsMenu.add(languageMenu);
        this.add(settingsMenu);
    }
}
