package Scripts.LoginManagement.Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Scripts.LoginManagement.Repositories.UserRepository;
import Scripts.LoginManagement.Screens.TelaLanguage;
import Scripts.LoginManagement.Screens.TelaLogin;

public class AuthenticationService {
    public UserRepository repository = new UserRepository();

    public boolean SignUp(String username, String password) {
        if (repository.verifyUsername(username) == false) {

            System.out.println("Adding your User...");
            TelaLogin.password = hashingMethod(password);
            repository.addLogin();

            System.out.println("Logging...");
            return true;
        } else if (repository.verifyUsername(username) == true) {
            System.out.println("Nao pode logar com esse nome...");
            return false;
        }
        return false;
    }

    public boolean SignIn(String username, String password) {
        String hashPass = hashingMethod(password);

        if (repository.verifyLogin(username, hashPass) == true) {
            System.out.println("Logando...");
            return true;
        } else if (repository.verifyLogin(username, hashPass) == false) {
            System.out.println("login invalido");
            return false;
        }
        return false;
    }

    public static String hashingMethod(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            messageDigest.update(password.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println("deu errado mane");
            e.printStackTrace();
        }

        return "";
    }
    // public static void main(String[] args) {
    //     String senha = "asd";
    //     String senhaHash = "";
    //     senhaHash = hashingMethod(senha);
    //     System.out.println(senha);
    //     System.out.println(senhaHash);
    // }
}
