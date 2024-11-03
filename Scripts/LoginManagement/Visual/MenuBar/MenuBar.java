package Scripts.LoginManagement.Visual.MenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        // Cria o menu "Settings"
        JMenu settingsMenu = new JMenu("Settings");

        // Cria o submenu "Language" dentro de "Settings"
        JMenu languageMenu = new JMenu("Language");

        // Adiciona as opções de idioma: English e Português
        JMenuItem englishItem = new JMenuItem("English");
        JMenuItem portugueseItem = new JMenuItem("Português");

        // Adiciona os action listeners para cada opção de idioma
        englishItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Idioma selecionado: English");
                // Implementar a mudança para o idioma Inglês aqui
            }
        });

        portugueseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Idioma selecionado: Português");
                // Implementar a mudança para o idioma Português aqui
            }
        });

        // Adiciona cada item de idioma ao menu "Language"
        languageMenu.add(englishItem);
        languageMenu.add(portugueseItem);

        // Adiciona o menu "Language" ao menu "Settings"
        settingsMenu.add(languageMenu);

        // Adiciona o menu "Settings" à barra de menu
        this.add(settingsMenu);
    }
}
