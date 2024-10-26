package Scripts.ClientServer;

import java.io.*;
import java.net.*;

// Classe que gerencia a comunicação com um cliente
class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            System.out.println("Client connected!");

            String msgFromClient;
            while ((msgFromClient = bufferedReader.readLine()) != null) {
                System.out.println("Client: " + msgFromClient);

                if (msgFromClient.equalsIgnoreCase("quit")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                
                ProtocolService protocolService = new ProtocolService(msgFromClient);
                String msgToSendBack = protocolService.processProtocol();

                bufferedWriter.write(msgToSendBack);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            System.out.println("Connection error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to close socket: " + e.getMessage());
            }
        }
    }
}
