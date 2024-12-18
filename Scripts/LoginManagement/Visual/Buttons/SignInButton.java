package Scripts.LoginManagement.Visual.Buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Scripts.Audio;
import Scripts.AudioHandler;
import Scripts.CharCreationManagement.CardManager;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import Scripts.ClientServer.Client;
import Scripts.LoginManagement.Repositories.UserRepository;
import Scripts.LoginManagement.Visual.TextsFields.InvalidLoginMessage;
import Scripts.LoginManagement.Visual.TextsFields.LoginExistsMessage;
import Scripts.LoginManagement.Visual.TextsFields.PasswordInput;
import Scripts.LoginManagement.Visual.TextsFields.UserNameInput;
import Scripts.LoginManagement.Screens.TelaLogin;
import Scripts.LoginManagement.Services.AuthenticationService;

public class SignInButton extends JButton {
    public SignInButton() {
        super();

        this.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 16));
        this.setBounds(250, 400, 120, 40);
        this.setForeground(Color.BLACK);

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

                        String dataToSend = "LOGIN," + TelaLogin.username + "," + TelaLogin.password;

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
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    // AuthenticationService authService = new AuthenticationService();
                    // boolean result = authService.SignIn(TelaLogin.username, TelaLogin.password);

                    // TelaLogin.userName_ID =
                    // authService.repository.getLoginID(TelaLogin.username);

                    // if (result == true) {

                    // AudioHandler.audioStop(AudioHandler.loginMenuAmbience);
                    // AudioHandler.audioStop(AudioHandler.loginMenuTheme);
                    // TelaLogin.getInstance().dispose();

                    // CardManager app = CardManager.getInstance();

                    // app.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    // app.setUndecorated(true);
                    // app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // app.setVisible(true);

                    // // TelaNotasUser telaNotas = new TelaNotasUser();
                    // // telaNotas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // } else if (result == false) {
                    // InvalidLoginMessage.getInstance().setVisible(true);

                    // }
                } else {
                    InvalidLoginMessage.getInstance().setVisible(true);
                }
            }

        });
    }
}
