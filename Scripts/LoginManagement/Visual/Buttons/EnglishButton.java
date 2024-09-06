package Scripts.LoginManagement.Visual.Buttons;

import java.awt.Color;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;

import Scripts.LoginManagement.Screens.TelaLogin;

public class EnglishButton extends JButton {
    private ResourceBundle resourceBundle = null;
    public EnglishButton() {
        super();
        this.setText("  English  ");
        this.setFont(new java.awt.Font("Adobe Garamond Pro", java.awt.Font.PLAIN, 19)); // Specify the fully qualified name of the Font class
        this.setBounds(150, 0, 150, 40);
        this.setForeground(Color.black);
        this.setFocusable(false);
        this.setOpaque(true);
        this.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
               TelaLogin.bn = ResourceBundle.getBundle("Exercicio02.Visualization.Login.Telas.Aula15", Locale.US);
            }
        });
    
    }
}
