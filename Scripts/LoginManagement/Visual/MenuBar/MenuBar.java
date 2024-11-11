package Scripts.LoginManagement.Visual.MenuBar;

import Scripts.CharCreationManagement.Screens.MainMenu;
import Scripts.CharCreationManagement.Screens.SearchCharacter;
import Scripts.LoginManagement.Screens.TelaLogin;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        JMenu settingsMenu = new JMenu("Settings");
        JMenu languageMenu = new JMenu("Language");

        JMenuItem englishItem = new JMenuItem("English");
        JMenuItem portugueseItem = new JMenuItem("Português");
        JMenuItem germanItem = new JMenuItem("Deutsch");
        JMenuItem frenchItem = new JMenuItem("Français");
        JMenuItem spanishItem = new JMenuItem("Español");

        // Define o action listener para cada idioma, passando o valor correto
        englishItem.addActionListener(e -> setLanguage(1, "Scripts/LoginManagement/Visual/MenuBar/LanguageNumber.txt"));
        portugueseItem.addActionListener(e -> setLanguage(0, "Scripts/LoginManagement/Visual/MenuBar/LanguageNumber.txt"));
        germanItem.addActionListener(e -> setLanguage(2, "Scripts/LoginManagement/Visual/MenuBar/LanguageNumber.txt"));
        frenchItem.addActionListener(e -> setLanguage(3, "Scripts/LoginManagement/Visual/MenuBar/LanguageNumber.txt"));
        spanishItem.addActionListener(e -> setLanguage(4, "Scripts/LoginManagement/Visual/MenuBar/LanguageNumber.txt"));

        // Adiciona as opções ao menu "Language"
        languageMenu.add(englishItem);
        languageMenu.add(portugueseItem);
        languageMenu.add(germanItem);
        languageMenu.add(frenchItem);
        languageMenu.add(spanishItem);

        settingsMenu.add(languageMenu);
        this.add(settingsMenu);
    }

    private void setLanguage(int languageCode, String filePath) {
        TelaLogin.n = languageCode;
        TelaLogin.getInstance().loadLanguage();
        MainMenu.getInstance().setI(languageCode);
        MainMenu.getInstance().loadLanguage(languageCode);
        SearchCharacter.getInstance().setI(languageCode);
        //SearchCharacter.getInstance().loadLanguage(languageCode);
        
        WriteNumberLanguage(languageCode, filePath);
    }

    public static void WriteNumberLanguage(int n, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(n));
            System.out.println("Idioma selecionado: " + n);
        } catch (IOException ex) {
            System.err.println("Erro ao escrever no arquivo: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Teste do método de escrita
        WriteNumberLanguage(1, "Scripts/LoginManagement/Visual/MenuBar/LanguageNumber.txt");

        // Teste da interface gráfica
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Menu de Idiomas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setJMenuBar(new MenuBar());
            frame.setVisible(true);
        });
    }
}
