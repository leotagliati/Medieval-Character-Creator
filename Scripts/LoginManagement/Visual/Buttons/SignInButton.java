package Scripts.LoginManagement.Visual.Buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Scripts.Audio;
import Scripts.AudioHandler;
import Scripts.CharCreationManagement.CardManager;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import Scripts.Ex07.CharacterServer;
import Scripts.LoginManagement.Repositories.UserRepository;
import Scripts.LoginManagement.Visual.TextsFields.InvalidLoginMessage;
import Scripts.LoginManagement.Visual.TextsFields.LoginExistsMessage;
import Scripts.LoginManagement.Visual.TextsFields.PasswordInput;
import Scripts.LoginManagement.Visual.TextsFields.UserNameInput;
import Scripts.LoginManagement.Screens.TelaLogin;
import Scripts.LoginManagement.Services.AuthenticationService;
import java.io.*;
import java.net.Socket;

public class SignInButton extends JButton {
    private static Socket socket;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;

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
                        socket = new Socket("127.0.0.1", 3304); // Conectar ao servidor
                        out = new ObjectOutputStream(socket.getOutputStream());
                        in = new ObjectInputStream(socket.getInputStream());

                        // Enviar protocolo de login
                        String[] loginData = { "LOGIN", TelaLogin.username, TelaLogin.password };
                        out.writeObject(loginData); // Enviar dados de login e protocolo

                        // Receber resposta do servidor
                        String response = (String) in.readObject();
                        System.out.println(response);

                        if (response.equals("Login bem-sucedido!")) {
                            // TelaLogin.userName_ID =
                            // authService.repository.getLoginID(TelaLogin.username);
                            AudioHandler.audioStop(AudioHandler.loginMenuAmbience);
                            AudioHandler.audioStop(AudioHandler.loginMenuTheme);
                            TelaLogin.getInstance().dispose();

                            CardManager app = CardManager.getInstance();

                            app.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            app.setUndecorated(true);
                            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            app.setVisible(true);
                        } else if (response.equals("Usuário ou senha incorretos.")) {
                            InvalidLoginMessage.getInstance().setVisible(true);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }

            }
        });
    }
}
