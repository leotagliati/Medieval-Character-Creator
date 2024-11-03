package Scripts.LoginManagement.Visual.MenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Scripts.LoginManagement.Screens.TelaLogin;

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

        // Action listeners para cada idioma
        englishItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.n = 1; // Define o idioma para Inglês
                TelaLogin.getInstance().loadLanguage();
            }
        });

        portugueseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.n = 0; // Define o idioma para Português
                TelaLogin.getInstance().loadLanguage();
            }
        });

        germanItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.n = 2; // Define o idioma para Alemão
                TelaLogin.getInstance().loadLanguage();
            }
        });

        frenchItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.n = 3; // Define o idioma para Francês
                TelaLogin.getInstance().loadLanguage();
            }
        });

        spanishItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.n = 4; // Define o idioma para Espanhol
                TelaLogin.getInstance().loadLanguage();
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
