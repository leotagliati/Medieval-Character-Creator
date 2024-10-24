package Scripts.LoginManagement.Screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.CardManager;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import Scripts.Ex07.Client;
import Scripts.LoginManagement.Services.AuthenticationService;
import Scripts.LoginManagement.Visual.Buttons.SignInButton;
import Scripts.LoginManagement.Visual.Buttons.SignUpButton;
import Scripts.LoginManagement.Visual.TextsFields.InvalidLoginMessage;
import Scripts.LoginManagement.Visual.TextsFields.LoginExistsMessage;
import Scripts.LoginManagement.Visual.TextsFields.PasswordInput;
import Scripts.LoginManagement.Visual.TextsFields.UserNameInput;

public class TelaLogin extends JFrame {
    public static TelaLogin instance;

    public static ResourceBundle bn = null;
    public static int n = 0;

    private JTextField passwordExampleText = new JTextField("PasswordExampleText");
    public JPasswordField passwordInputText = new JPasswordField("");

    public static String username = "";
    public static String password = "";
    public static int userName_ID = -1;

    private JLabel loginLabel = new JLabel("Chronicles of Erathor");
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");

    // private SignInButton signInButton = new SignInButton();
    
        
    private SignUpButton signUpButton = new SignUpButton();
    
    private Client client;

    public Client getClient() {
        return client;
    }

    private TelaLogin() {
        super("Telao");
        this.setBounds(0, 0, 600, 600);
        this.setLayout(new GridBagLayout());

        client = new Client();
        client.initClient();

        AudioHandler.audioPlay(AudioHandler.loginMenuAmbience);
        AudioHandler.audioPlay(AudioHandler.loginMenuTheme);
        loadLanguage();

        ImageCreate loginGIF = new ImageCreate(0, 0, 500, 500);
        loginGIF.setAlignment(JLabel.CENTER, JLabel.CENTER);
        loginGIF.setIconFile("Images\\menu.gif");
        loginGIF.imageSetter();

        // seta os propriedades da painel verde
        JPanel areaLoginPanel = new JPanel();
        areaLoginPanel.setPreferredSize(new Dimension(500, 500));
        areaLoginPanel.setBackground(Color.BLUE);
        areaLoginPanel.setLayout(null);
        JButton signInButton = new JButton("SignUp");
    
        signInButton.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 16));
        signInButton.setBounds(250, 400, 120, 40);
        signInButton.setForeground(Color.BLACK);
            
            signInButton.addActionListener(new ActionListener() {
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
    
                        client.waitForRequestLoop("FINDLOGINUSER," + TelaLogin.username);
                        AuthenticationService authService = new AuthenticationService();
                        boolean result = authService.SignIn(TelaLogin.username, TelaLogin.password);
    
                        // TelaLogin.userName_ID = authService.repository.getLoginID(TelaLogin.username);
    
                        if (result == true) {
    
                            AudioHandler.audioStop(AudioHandler.loginMenuAmbience);
                            AudioHandler.audioStop(AudioHandler.loginMenuTheme);
                            TelaLogin.getInstance().dispose();
    
                            CardManager app = CardManager.getInstance();
    
                            app.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            app.setUndecorated(true);
                            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            app.setVisible(true);
    
                            // TelaNotasUser telaNotas = new TelaNotasUser();
                            // telaNotas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        } else if (result == false) {
                            InvalidLoginMessage.getInstance().setVisible(true);
    
                        }
                    } else {
                        InvalidLoginMessage.getInstance().setVisible(true);
                    }
                }
            });
        // seta os propriedades da label azul LOGIN

        loginLabel.setFont(new Font("Enchanted land", Font.BOLD, 55));
        loginLabel.setBounds(50, 150, 400, 100);
        loginLabel.setForeground(Color.white);
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setBackground(Color.GREEN);
        loginLabel.setOpaque(false);

        usernameLabel.setBounds(100, 250, 100, 30);
        usernameLabel.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 20));
        usernameLabel.setForeground(Color.WHITE);

        passwordLabel.setBounds(usernameLabel.getX(), 330, 100, 30);
        passwordLabel.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 20));
        passwordLabel.setForeground(Color.WHITE);

        areaLoginPanel.add(loginLabel);
        areaLoginPanel.add(usernameLabel);
        areaLoginPanel.add(passwordLabel);

        InvalidLoginMessage invalidLogin = InvalidLoginMessage.getInstance();
        areaLoginPanel.add(invalidLogin);
        LoginExistsMessage loginExistsMessage = LoginExistsMessage.getInstance();
        areaLoginPanel.add(loginExistsMessage);

        // instancia os textos de input do login
        UserNameInput.resetInstance();
        UserNameInput userNameInput = UserNameInput.getInstance();
        areaLoginPanel.add(userNameInput);

        PasswordInput.resetInstance();
        PasswordInput passWordInput = PasswordInput.getInstance();

        areaLoginPanel.add(passWordInput);

        areaLoginPanel.add(signInButton);

        areaLoginPanel.add(signUpButton);

        areaLoginPanel.add(loginGIF);

        this.add(areaLoginPanel);
        this.setVisible(true);

    }

    public static TelaLogin getInstance() {
        if (instance == null) {
            instance = new TelaLogin();
        }
        return instance;
    }
    public static void resetInstance()
    {
        instance = new TelaLogin();
    }
    public void loadLanguage() {
        // Reload the ResourceBundle based on the selected language
        switch (n) {
            case 0:
                bn = ResourceBundle.getBundle("Scripts.LoginManagement.Screens.b_pt_BR", new Locale("pt", "BR"));
                break;
            case 1:
                bn = ResourceBundle.getBundle("Scripts.LoginManagement.Screens.b_en_US", Locale.US);
                break;
        }
        if (instance != null) {
            // Update the text for all UI components based on the new ResourceBundle

            loginLabel.setText(bn.getString("loginLabel"));
            usernameLabel.setText(bn.getString("usernameLabel"));
            passwordLabel.setText(bn.getString("passwordLabel"));
            // signInButton.setText(bn.getString("signIn"));
            signUpButton.setText(bn.getString("signUp"));
            UserNameInput.getInstance().setText(bn.getString("usernameInput"));
            // Update other components as needed
        }
    }
    

}
