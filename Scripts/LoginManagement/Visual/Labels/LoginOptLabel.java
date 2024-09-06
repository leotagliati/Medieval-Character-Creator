package Scripts.LoginManagement.Visual.Labels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JLabel;

public class LoginOptLabel extends JLabel {

    public LoginOptLabel(String labelText)
    {
        super();
        this.setText(labelText);
        this.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 15));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
    }
}
