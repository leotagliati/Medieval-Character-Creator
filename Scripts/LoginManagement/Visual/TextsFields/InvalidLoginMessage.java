package Scripts.LoginManagement.Visual.TextsFields;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InvalidLoginMessage extends JTextField{
    public static InvalidLoginMessage instance;

    private InvalidLoginMessage()
    {
        super("Nome e/ou senha invalidos!");
        this.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 20));
        this.setBounds(20,230,250,100);
        this.setForeground(Color.red);
        this.setFocusable(false);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBorder(null);
        this.setOpaque(false);
        this.setVisible(false);
    }

    public static InvalidLoginMessage getInstance() {
        if (instance == null) {
            instance = new InvalidLoginMessage();
        }
        return instance;
    }
    
}
