// Server.java
package Scripts.ClientServer;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3304)) {
            System.out.println("Server started and waiting for clients...");

            while (true) {
                Socket socket = serverSocket.accept();
                // Inicia uma nova thread para cada cliente que se conecta
                // **** DEVE FUNCIONAR O MULTITHREAD ASSIM ****
                Thread clientThread = new Thread(new ClientHandler(socket));
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start: " + e.getMessage());
        }
    }
}
