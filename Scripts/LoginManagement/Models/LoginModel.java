package Scripts.LoginManagement.Models;

public class LoginModel {
    private String username;
    private String password;

    public LoginModel(String name, String pass) {
        this.username = name;
        this.password = pass;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
