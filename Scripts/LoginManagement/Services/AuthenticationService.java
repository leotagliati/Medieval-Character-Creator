package Scripts.LoginManagement.Services;

import Scripts.LoginManagement.UserRepository;

public class AuthenticationService {
    public UserRepository repository = new UserRepository();

    public boolean SignUp(String username, String password) {
        if (repository.verifyUsername(username) == false) {

            System.out.println("Adding your User...");
            repository.addLogin();
            
            System.out.println("Logging...");
            return true;
        } else if (repository.verifyUsername(username) == true) {
            System.out.println("Nao pode logar com esse nome...");
            return false;
        }
        return false;
    }
    public boolean SignIn(String username, String password)
    {
        if (repository.verifyLogin(username,password) == true) {
            System.out.println("Logando...");
            return true;
        } else if (repository.verifyLogin(username,password) == false) {
            System.out.println("login invalido");
            return false;
        }
        return false;
    }
}
