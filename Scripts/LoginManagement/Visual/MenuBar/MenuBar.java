package Scripts.LoginManagement.Visual.MenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Scripts.LoginManagement.Screens.TelaLogin;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        JMenu settingsMenu = new JMenu("Settings");

        JMenu languageMenu = new JMenu("Language");

        JMenuItem englishItem = new JMenuItem("English");
        JMenuItem portugueseItem = new JMenuItem("Português");

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

        languageMenu.add(englishItem);
        languageMenu.add(portugueseItem);
        settingsMenu.add(languageMenu);

        this.add(settingsMenu);
    }
}
