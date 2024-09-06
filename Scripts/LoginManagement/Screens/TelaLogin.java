package Scripts.LoginManagement.Screens;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Scripts.LoginManagement.Login.Buttons.SignInButton;
import Scripts.LoginManagement.Login.Buttons.SignUpButton;
import Scripts.LoginManagement.Login.TextsFields.InvalidLoginMessage;
import Scripts.LoginManagement.Login.TextsFields.LoginExistsMessage;
import Scripts.LoginManagement.Login.TextsFields.PasswordInput;
import Scripts.LoginManagement.Login.TextsFields.UserNameInput;

public class TelaLogin extends JFrame {
    public static TelaLogin instance;

    public static ResourceBundle bn = null;
    public static int n = 0;

    private JTextField passwordExampleText = new JTextField("PasswordExampleText");
    public JPasswordField passwordInputText = new JPasswordField("");

    public static String username = "";
    public static String password = "";
    public static int userName_ID = -1;

    private JLabel loginLabel = new JLabel("LOGIN");
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");

    private SignInButton signInButton = new SignInButton();
    private SignUpButton signUpButton = new SignUpButton();


    public TelaLogin() {
        super("Telao");
        this.setBounds(0, 0, 600, 600);
        this.setLayout(new GridBagLayout());
        
        loadLanguage();
        // seta os propriedades da painel verde
        JPanel areaLoginPanel = new JPanel();
        areaLoginPanel.setPreferredSize(new Dimension(300, 400));
        areaLoginPanel.setBackground(Color.BLUE);
        areaLoginPanel.setLayout(null);


    
        // seta os propriedades da label azul LOGIN
       


        loginLabel.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 30));
        loginLabel.setBounds(50, 0, 200, 50);
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setBackground(Color.GREEN);
        loginLabel.setOpaque(true);

  


        usernameLabel.setBounds(0, 50, 100, 30);



        passwordLabel.setBounds(usernameLabel.getX(), 130, 100, 30);

        areaLoginPanel.add(loginLabel);
        areaLoginPanel.add(usernameLabel);
        areaLoginPanel.add(passwordLabel);

        InvalidLoginMessage invalidLogin = InvalidLoginMessage.getInstance();
        areaLoginPanel.add(invalidLogin);
        LoginExistsMessage loginExistsMessage = LoginExistsMessage.getInstance();
        areaLoginPanel.add(loginExistsMessage);

        // instancia os textos de input do login
        UserNameInput userNameInput = UserNameInput.getInstance();


        areaLoginPanel.add(userNameInput);
        PasswordInput passWordInput = PasswordInput.getInstance();


        areaLoginPanel.add(passWordInput);

        
        
        areaLoginPanel.add(signInButton);

        areaLoginPanel.add(signUpButton);


       
        this.add(areaLoginPanel);
        this.setVisible(true);

    }
    public static TelaLogin getInstance()
    {
        if(instance == null)
        {
            instance = new TelaLogin();
        }
        return instance;
    }
    public void loadLanguage() {
        // Reload the ResourceBundle based on the selected language
        switch (n) {
            case 0:
                bn = ResourceBundle.getBundle("Scripts.LoginManagement.Screens.b_en_US",  new Locale("pt", "BR"));
                break;
            case 1:
                bn = ResourceBundle.getBundle("Scripts.LoginManagement.Screens.b_pt_br", Locale.US);
                break;
        }
        if (instance != null) {
            // Update the text for all UI components based on the new ResourceBundle
            
            loginLabel.setText(bn.getString("loginLabel"));
            usernameLabel.setText(bn.getString("usernameLabel"));
            passwordLabel.setText(bn.getString("passwordLabel"));
            signInButton.setText(bn.getString("signIn"));
            signUpButton.setText(bn.getString("signUp"));
            UserNameInput.getInstance().setText(bn.getString("usernameInput"));
            // Update other components as needed
        }
    }

}
