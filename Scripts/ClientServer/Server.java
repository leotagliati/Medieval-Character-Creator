// Server.java
package Scripts.ClientServer;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3304)) {
            System.out.println("Server started and waiting for clients...");
            
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
                }
            }
        } catch (IOException e) {
            System.out.println("Server failed to start: " + e.getMessage());
        }
    }
}
