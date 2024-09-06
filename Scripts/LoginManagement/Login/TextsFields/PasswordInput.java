package Scripts.LoginManagement.Login.TextsFields;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;


public class PasswordInput extends JPasswordField {
    public static PasswordInput instance;

    private PasswordInput() {
        // seta os propriedades da texto de input da senha
        super();
        this.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 20));
        this.setBounds(20, 160, 250, 30);
        this.setForeground(Color.gray);
        this.setOpaque(true);
        this.setEditable(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent c) {

                InvalidLoginMessage.getInstance().setVisible(false);
                LoginExistsMessage.getInstance().setVisible(false);

                PasswordInput.this.setEditable(true);
                PasswordInput.this.setFocusable(true);
                PasswordInput.this.requestFocusInWindow();

            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    PasswordInput.this.setEditable(false);
                    PasswordInput.this.setFocusable(false);
                    if (PasswordInput.this.getPassword().length == 0) {
                        PasswordInput.this.setVisible(true);
                    }
                }
            }
        });
    }

    public static PasswordInput getInstance() {
        if (instance == null) {
            instance = new PasswordInput();
        }
        return instance;
    }
}
