package Scripts.CharCreationManagement.Visual.MenuBar;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Scripts.CharCreationManagement.Screens.MainMenu;

public class MainMenuBar extends JMenuBar {

    public MainMenuBar() {
        JMenu settingsMenu = new JMenu("Settings");
        JMenu languageMenu = new JMenu("Language");

        // Opções de idiomas
        JMenuItem englishItem = new JMenuItem("English");
        JMenuItem portugueseItem = new JMenuItem("Português");
        JMenuItem germanItem = new JMenuItem("Deutsch");
        JMenuItem frenchItem = new JMenuItem("Français");
        JMenuItem spanishItem = new JMenuItem("Español");

        // Action listeners para cada idioma, passando o valor correto diretamente para loadLanguage
        englishItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenu.getInstance().loadLanguage(1); // Define o idioma para Inglês
            }
        });

        portugueseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenu.getInstance().loadLanguage(0); // Define o idioma para Português
            }
        });

        germanItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenu.getInstance().loadLanguage(2); // Define o idioma para Alemão
            }
        });

        frenchItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenu.getInstance().loadLanguage(3); // Define o idioma para Francês
            }
        });

        spanishItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenu.getInstance().loadLanguage(4); // Define o idioma para Espanhol
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
