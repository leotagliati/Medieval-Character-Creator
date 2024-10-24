package Scripts.Ex07;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Scripts.CharCreationManagement.Model.GameCharacter;
import Scripts.CharCreationManagement.Repository.CharacterRepository;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.ChestTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.EyeColorTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.GenderTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.HelmetTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.LegsTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.SkinColorTypes;
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
                        case "GIVE_USER_ID":
                            // Validar login no banco de dados
                            int ID = validateGiveUserID();
                            if (ID >= 0) {
                                TelaLogin.userName_ID = ID;
                                out.writeObject("" + ID);
                            } else {
                                out.writeObject("Falha ao enviar UserID");
                            }
                            break;
                        case "ADDCHAR":

                            String charName = requestData[1];
                            String charClass = requestData[2];
                            GenderTypes charGender = GenderTypes.valueOf(requestData[3]);
                            EyeColorTypes charEyeColor = EyeColorTypes.valueOf(requestData[4]);
                            SkinColorTypes charSkinColor = SkinColorTypes.valueOf(requestData[5]);
                            HelmetTypes charHelm = HelmetTypes.valueOf(requestData[6]);
                            ChestTypes charChest = ChestTypes.valueOf(requestData[7]);
                            LegsTypes charLegs = LegsTypes.valueOf(requestData[8]);
                            int userName_ID = Integer.parseInt(requestData[9]);

                            GameCharacter characterToSend = new GameCharacter(charName, charClass, charGender,
                                    charEyeColor, charSkinColor, charHelm, charChest, charLegs);

                            // Validar inclusao no banco de dados
                            if (validateAddChar(characterToSend, userName_ID)) {
                                out.writeObject("Inclusao bem-sucedido!");
                            } else {
                                out.writeObject("Inclusao falhou.");
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

    private static int validateGiveUserID() {
        AuthenticationService authenticationService = new AuthenticationService();
        int userName_ID = authenticationService.repository.getLoginID(TelaLogin.username);
        return userName_ID;
    }

    private static boolean validateAddChar(GameCharacter charToSend, int userName_ID) {
        CharacterRepository repo = new CharacterRepository();
        repo.addCharacter(charToSend, userName_ID);
        return true;
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
