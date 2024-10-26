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
        this.protocolMessage.toUpperCase();
        String[] messageData = this.protocolMessage.split(",");

        switch (messageData[0]) {
            case "LOGIN":
                String username = messageData[1];
                String password = messageData[2];
                AuthenticationService authenticationService = new AuthenticationService();
                result = authenticationService.SignIn(username, password);
                if(result)
                {
                    resultString = "true";
                }
                else
                {
                    resultString = "false";
                }
                break;

            default:
                resultString = "Protocolo " + messageData[0] + " desconhecido";
                break;
        }
        return resultString;
    }
}
