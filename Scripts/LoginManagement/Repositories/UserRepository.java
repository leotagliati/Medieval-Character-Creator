package Scripts.LoginManagement.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Scripts.LoginManagement.Database.DAL.ConnFactory;
import Scripts.LoginManagement.Models.LoginModel;
import Scripts.LoginManagement.Screens.TelaLogin;

import java.util.ArrayList;

public class UserRepository {
    Connection conn;

    public UserRepository() {
        this.conn = ConnFactory.getConn();
    }
    public int getLoginID(String username)
    {
        String command = "SELECT ID FROM tb_users WHERE USERNAME = '" + username +"'";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        int id = -1;
        try {
            stmt = conn.prepareStatement(command);
            ResultSet result = stmt.executeQuery();
            if(result.next())
            {
                id = result.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao incluir os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
        return id;
    }
    public void addLogin() {
        String command = "INSERT INTO tb_users(username,password) VALUES(?,?)";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {

            stmt = conn.prepareStatement(command);
            stmt.setString(1, TelaLogin.username);
            stmt.setString(2, TelaLogin.password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao incluir os dados");
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public boolean verifyLogin(String username, String password) {
        String command = "SELECT * FROM tb_users WHERE username = '" + username + "' and password = '" + password + "'";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(command);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                System.err.println("achei UM CARA com esse username e senha");
                return true;
            } else {
                System.err.println("NAO achei UM CARA com esse username e senha");
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao verificar o login");
            return false;
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public boolean verifyUsername(String username) {
        String command = "SELECT * FROM tb_users WHERE username = '" + username + "'";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(command);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                System.err.println("ACHEI UM CARA com esse username");
                return true;
            } else {
                System.err.println("Nao achei UM CARA com esse username");
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao verificar o username");
            return false;
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public ArrayList<LoginModel> GetAllLogins() {
        String command = "SELECT * FROM tb_users";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        ArrayList<LoginModel> logins = new ArrayList<LoginModel>();
        try {
            stmt = conn.prepareStatement(command);
            ResultSet result = stmt.executeQuery();
            logins = this.getValues(result);
        } catch (SQLException e) {
            System.out.println("Erro ao incluir os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
        return logins;
    }

    private ArrayList<LoginModel> getValues(ResultSet resultSet) {
        ArrayList<LoginModel> values = new ArrayList<LoginModel>();
        try {
            while (resultSet.next()) {
                LoginModel login = new LoginModel(resultSet.getString(1), resultSet.getString(2));
                values.add(login);
            }

        } catch (Exception e) {
            throw new RuntimeException("Deu tudo errado");
        }
        return values;
    }

}