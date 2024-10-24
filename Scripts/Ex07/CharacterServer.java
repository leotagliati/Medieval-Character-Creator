package Scripts.Ex07;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Scripts.LoginManagement.Screens.TelaLogin;
import Scripts.LoginManagement.Services.AuthenticationService;

public class CharacterServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3304)) {
            System.out.println("Servidor iniciado. Aguardando conexões...");

            while (true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

                    // Receber protocolo e dados do cliente
                    String[] requestData = (String[]) in.readObject();
                    String protocol = requestData[0];

                    switch (protocol) {
                        case "LOGIN":
                            String username = requestData[1];
                            String password = requestData[2];

                            // Validar login no banco de dados
                            if (validateLogin(username, password)) {
                                out.writeObject("Login bem-sucedido!");
                            } else {
                                out.writeObject("Usuário ou senha incorretos.");
                            }
                            break;

                        case "REGISTER":
                            username = requestData[1];
                            password = requestData[2];

                            // Validar login no banco de dados
                            if (validateRegister(username, password)) {
                                out.writeObject("Cadrasto bem-sucedido!");
                            } else {
                                out.writeObject("Usuário já cadastrado");
                            }
                            break;

                        default:
                            out.writeObject("Protocolo desconhecido.");
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateRegister(String username, String password) {
        AuthenticationService authService = new AuthenticationService();
        boolean result = authService.SignUp(username, password);
        return result;
    }

    public static boolean validateLogin(String username, String password) {

        AuthenticationService authService = new AuthenticationService();
        boolean result = authService.SignIn(username, password);
        return result;
    }
}
