package Scripts.ClientServer;

import Scripts.LoginManagement.Services.AuthenticationService;

public class ProtocolService {
    String protocolMessage;

    public ProtocolService(String protocolMessage) {
        this.protocolMessage = protocolMessage;
    }

    public String processProtocol() {
        String resultString = "";
        boolean result = false;
        // this.protocolMessage.toUpperCase();
        String[] messageData = this.protocolMessage.split(",");
        AuthenticationService authenticationService = new AuthenticationService();
        messageData[0].toUpperCase();

        switch (messageData[0]) {
            case "LOGIN":
                String usernameToLogin = messageData[1];
                String passwordToLogin = messageData[2];
                result = authenticationService.SignIn(usernameToLogin, passwordToLogin);
                if (result) {
                    resultString = "true";
                } else {
                    resultString = "false";
                }
                break;
            case "REGISTER":
                String usernameToRegister = messageData[1];
                String passwordToRegister = messageData[2];
                result = authenticationService.SignUp(usernameToRegister, passwordToRegister);
                if (result) {
                    resultString = "true";
                } else {
                    resultString = "false";
                }
                break;

            case "GIVE_USER_ID":
                authenticationService = new AuthenticationService();
                String usernameToGetLogin = messageData[1];
                System.out.println(usernameToGetLogin);
                resultString = "" + authenticationService.repository.getLoginID(usernameToGetLogin);
                break;

            default:
                resultString = "Protocolo " + messageData[0] + " desconhecido";
                break;
        }
        return resultString;
    }
}
