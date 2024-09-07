package Scripts.LoginManagement.Screens;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Scripts.AudioHandler;

public class TelaLanguage extends JFrame {
    private JButton englishButton;
    private JButton portugueseButton;
    private JPanel panel;

    public TelaLanguage() {
        super("Language");
        this.setBounds(0, 0, 600, 600);
        this.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 600, 600);
        panel.setLayout(new FlowLayout());

        englishButton = new JButton("English");
        englishButton.setBounds(150, 150, 150, 50);
        panel.add(englishButton);

        portugueseButton = new JButton("Portuguese");
        portugueseButton.setBounds(300, 150, 150, 50);
        panel.add(portugueseButton);

        this.add(panel);
        this.setVisible(true);

        portugueseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaLogin telaLogin = TelaLogin.getInstance();
                TelaLogin.n = 0; // Update static variable
                telaLogin.loadLanguage(); // Reload ResourceBundle and update UI
                telaLogin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                telaLogin.setVisible(true); // Show the updated login screen
                dispose();
            }
        });

        englishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                TelaLogin telaLogin = TelaLogin.getInstance();
                TelaLogin.n = 1; // Update static variable
                telaLogin.loadLanguage(); // Reload ResourceBundle and update UI
                telaLogin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                telaLogin.setVisible(true); // Show the updated login screen
                dispose();
            }
        });
    }

}
