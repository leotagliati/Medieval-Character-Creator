package Scripts.Ex07;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private Scanner sc;
    private PrintWriter output;

    public Client() {
        this.sc = new Scanner(System.in);
    }

    public void start() throws UnknownHostException, IOException {
        clientSocket = new Socket(Server.ADDRESS, Server.PORT);
        output = new PrintWriter(clientSocket.getOutputStream(), true);
        System.out.println("Cliente " + Server.ADDRESS + ":" + Server.PORT + " conectado ao servidor");
        // *******COMO IMPLEMENTAR ISSO?**********
        // waitForRequestLoop();

    }

    public void waitForRequestLoop(String receivedMessage) {
        String msg = receivedMessage;
        String[] msgSplitted = msg.split(",");
        String command = msgSplitted[0];
        System.out.println("Comando: " + command);
            output.println(msg);

    }

    public void initClient() {
        try {
            Client client = new Client();
            client.start();
        } catch (IOException e) {
            System.out.println("Erro ao inicializar o cliente!" + e);
        }
        System.out.println("Cliente finalizado!");
    }
}
