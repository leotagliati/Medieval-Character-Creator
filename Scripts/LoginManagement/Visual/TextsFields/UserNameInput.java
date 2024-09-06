package Scripts.LoginManagement.Visual.TextsFields;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class UserNameInput extends JTextField {
    public static UserNameInput instance;

    public UserNameInput() {
        // seta os propriedades da texto de input do login
        super();
        this.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 20));
        this.setBounds(20, 80, 250, 30);
        this.setForeground(Color.gray);
        this.setOpaque(true);
        this.setEditable(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent c) {
                UserNameInput.this.setEditable(true);
                if (UserNameInput.this.getText().equals("Type your username")|| UserNameInput.this.getText().equals("Digite seu usuário")) {
                    UserNameInput.this.setText("");
                }
                UserNameInput.this.setForeground(Color.BLACK);

                InvalidLoginMessage.getInstance().setVisible(false);
                LoginExistsMessage.getInstance().setVisible(false);

            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (UserNameInput.this.getText().equals("")) {
                        UserNameInput.this.setText("Type your username");
                        UserNameInput.this.setForeground(Color.gray);
                    }
                    UserNameInput.this.setEditable(false);
                }
            }
        });
    }
    public static UserNameInput getInstance() {
        if (instance == null) {
            instance = new UserNameInput();
        }
        return instance;
    }

}
