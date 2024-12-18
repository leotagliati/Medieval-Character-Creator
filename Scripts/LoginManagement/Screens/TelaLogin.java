package Scripts.LoginManagement.Screens;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import Scripts.ClientServer.Client;
import Scripts.LoginManagement.Visual.Buttons.SignInButton;
import Scripts.LoginManagement.Visual.Buttons.SignUpButton;
import Scripts.LoginManagement.Visual.MenuBar.MenuBar;
import Scripts.LoginManagement.Visual.TextsFields.InvalidLoginMessage;
import Scripts.LoginManagement.Visual.TextsFields.LoginExistsMessage;
import Scripts.LoginManagement.Visual.TextsFields.PasswordInput;
import Scripts.LoginManagement.Visual.TextsFields.UserNameInput;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Scripts.AudioHandler;
import Scripts.CharCreationManagement.Visual.ImagesConversion.ImageCreate;
import Scripts.ClientServer.Client;
import Scripts.LoginManagement.Visual.ComboBoxObject;
import Scripts.LoginManagement.Visual.Buttons.SignInButton;
import Scripts.LoginManagement.Visual.Buttons.SignUpButton;
import Scripts.LoginManagement.Visual.TextsFields.InvalidLoginMessage;
import Scripts.LoginManagement.Visual.TextsFields.LoginExistsMessage;
import Scripts.LoginManagement.Visual.TextsFields.PasswordInput;
import Scripts.LoginManagement.Visual.TextsFields.UserNameInput;

public class TelaLogin extends JFrame {
    public static TelaLogin instance;
    private Client client;

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

    private SignInButton signInButton = new SignInButton();
    private SignUpButton signUpButton = new SignUpButton();

    private TelaLogin() {
        super("Telao");
        this.setBounds(0, 0, 600, 600);
        this.setLayout(new GridBagLayout());
        AudioHandler.audioPlay(AudioHandler.loginMenuAmbience);
        AudioHandler.audioPlay(AudioHandler.loginMenuTheme);
        loadLanguage();

        ImageCreate loginGIF = new ImageCreate(0, 0, 500, 500);
        loginGIF.setAlignment(JLabel.CENTER, JLabel.CENTER);
        loginGIF.setIconFile("Images\\menu.gif");
        loginGIF.imageSetter();

        ComboBoxObject comboBox = new ComboBoxObject();
        comboBox.setBounds(400, 0, 50, 20);
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    AudioHandler.audioStop(AudioHandler.loginMenuAmbience);
                    AudioHandler.audioStop(AudioHandler.loginMenuTheme);
                    AudioHandler.audioStop(AudioHandler.gothicMenuTheme);

                    switch (comboBox.getSelectedIndex()) {
                        case 0:
                            AudioHandler.audioPlay(AudioHandler.loginMenuAmbience);
                            AudioHandler.audioPlay(AudioHandler.loginMenuTheme);
                            loginGIF.setIconFile("Images\\menu.gif");
                            loginGIF.imageSetter();
                            break;
                        case 1:
                            AudioHandler.audioPlay(AudioHandler.gothicMenuTheme);
                            loginGIF.setIconFile("Images\\menu2.gif");
                            loginGIF.imageSetter();
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        // seta os propriedades da painel verde
        JPanel areaLoginPanel = new JPanel();
        areaLoginPanel.setPreferredSize(new Dimension(500, 500));
        areaLoginPanel.setBackground(Color.BLUE);
        areaLoginPanel.setLayout(null);

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

        areaLoginPanel.add(comboBox);
        areaLoginPanel.add(passWordInput);

        areaLoginPanel.add(signInButton);

        areaLoginPanel.add(signUpButton);

        areaLoginPanel.add(loginGIF);

        MenuBar menuBar = new MenuBar();
        this.setJMenuBar(menuBar);

        this.add(areaLoginPanel);
        this.setVisible(true);

    }

    public static TelaLogin getInstance() {
        if (instance == null) {
            instance = new TelaLogin();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = new TelaLogin();
    }

    public void loadLanguage() {
        // Carrega o ResourceBundle com base no idioma selecionado
        switch (n) {
            case 0:
                bn = ResourceBundle.getBundle("Scripts.LoginManagement.Screens.b_pt_BR", new Locale("pt", "BR"));
                break;
            case 1:
                bn = ResourceBundle.getBundle("Scripts.LoginManagement.Screens.b_en_US", Locale.US);
                break;
            case 2:
                bn = ResourceBundle.getBundle("Scripts.LoginManagement.Screens.b_de_DE", Locale.GERMANY);
                break;
            case 3:
                bn = ResourceBundle.getBundle("Scripts.LoginManagement.Screens.b_fr_FR", Locale.FRANCE);
                break;
            case 4:
                bn = ResourceBundle.getBundle("Scripts.LoginManagement.Screens.b_es_ES", new Locale("es", "ES"));
                break;
        }
    
        if (instance != null) {
            // Atualiza o texto para todos os componentes da interface com base no novo ResourceBundle
            loginLabel.setText(bn.getString("loginLabel"));
            usernameLabel.setText(bn.getString("usernameLabel"));
            passwordLabel.setText(bn.getString("passwordLabel"));
            signInButton.setText(bn.getString("signIn"));
            signUpButton.setText(bn.getString("signUp"));
            UserNameInput.getInstance().setText(bn.getString("usernameInput"));
    
            // Revalida e repinta a interface para refletir as mudanças
            this.revalidate();
            this.repaint();
        }
    }
    

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
