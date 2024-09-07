package Scripts.LoginManagement.Visual.TextsFields;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginExistsMessage extends JTextField {
    public static LoginExistsMessage instance;

    private LoginExistsMessage()
    {
        super("Nome de usuário já utilizado!");
        this.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 20));
        this.setBounds(120,430,250,100);
        this.setForeground(Color.red);
        this.setFocusable(false);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBorder(null);
        this.setOpaque(false);
        this.setVisible(false);
    }

    public static LoginExistsMessage getInstance() {
        if (instance == null) {
            instance = new LoginExistsMessage();
        }
        return instance;
    }
}
