package Scripts;
import Scripts.LoginManagement.Screens.TelaLogin;

public class RunApp {
    public static void main(String[] args) {
        TelaLogin telaLogin = TelaLogin.getInstance();
        TelaLogin.n = 1; 
        telaLogin.loadLanguage(); 
        telaLogin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        telaLogin.setVisible(true);
    }
}
