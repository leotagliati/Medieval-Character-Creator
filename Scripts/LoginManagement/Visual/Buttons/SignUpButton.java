package Scripts.LoginManagement.Visual.Buttons;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.CardManager;
import Scripts.ClientServer.Client;
import Scripts.LoginManagement.Visual.TextsFields.InvalidLoginMessage;
import Scripts.LoginManagement.Visual.TextsFields.LoginExistsMessage;
import Scripts.LoginManagement.Visual.TextsFields.PasswordInput;
import Scripts.LoginManagement.Visual.TextsFields.UserNameInput;
import Scripts.LoginManagement.Screens.TelaLogin;
import Scripts.LoginManagement.Services.AuthenticationService;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SignUpButton extends JButton {
    public SignUpButton() {
        super();

        this.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 16));
        this.setBounds(120, 400, 120, 40);
        this.setForeground(Color.black);
        this.setFocusable(false);
        this.setOpaque(true);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InvalidLoginMessage.getInstance().setVisible(false);
                LoginExistsMessage.getInstance().setVisible(false);

                if (UserNameInput.getInstance().getText().length() > 0
                        && PasswordInput.getInstance().getPassword().length > 0) {

                    TelaLogin.username = UserNameInput.getInstance().getText();

                    TelaLogin.password = "";
                    for (char c : PasswordInput.getInstance().getPassword()) {
                        TelaLogin.password += c;
                    }

                    // System.out.println(TelaLogin.username);
                    // System.out.println(TelaLogin.password);

                    try {
                        TelaLogin.getInstance().setClient(new Client("127.0.0.1", 3304));

                        String dataToSend = "REGISTER," + TelaLogin.username + "," + TelaLogin.password;

                        String response = TelaLogin.getInstance().getClient().sendMessage(dataToSend);

                        if (response.equals("true")) {
                            System.out.println("Pode Logar!");
                            int id = -1;
                            dataToSend = "GIVE_USER_ID," + TelaLogin.username;
                            id = Integer.parseInt(TelaLogin.getInstance().getClient().sendMessage(dataToSend));

                            if (id >= 0) {
                                TelaLogin.userName_ID = id;
                                System.out.println("ID encontrado!");
                                AudioHandler.audioStop(AudioHandler.loginMenuAmbience);
                                AudioHandler.audioStop(AudioHandler.loginMenuTheme);
                                TelaLogin.getInstance().dispose();

                                CardManager app = CardManager.getInstance();

                                // app.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                // app.setUndecorated(true);
                                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                app.setVisible(true);
                            } else {
                                System.out.println("ID nao encontrado!");
                            }

                        } else {
                            InvalidLoginMessage.getInstance().setVisible(true);

                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    
                } else {
                    InvalidLoginMessage.getInstance().setVisible(true);
                }
            }

        });
    }
}
