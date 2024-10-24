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

    public Client()
    {
        this.sc = new Scanner(System.in);
    }

    public void start() throws UnknownHostException, IOException
    {
        clientSocket = new Socket("localhost", 3304);
        output = new PrintWriter(clientSocket.getOutputStream(),true);
        System.out.println("Cliente " + "127.0.0.1" + ":" + "3304" + " conectado ao servidor");
        messageLoop();

    }

    private void messageLoop() {
        String msg;
        System.out.println("Esperando uma digitacao de uma mensagem!");
        do {
            System.out.println("Digite uma mensagem ou sair!");
            msg = sc.nextLine();
            output.println(msg);
            
        } while (!msg.equalsIgnoreCase("sair"));
    }
    public static void main(String[] args) {
        System.out.println("********CONSOLE DO CLIENTE RAPA********");
        try {
            Client client = new Client();
            client.start();
        } catch (IOException e) {
            System.out.println("Erro ao inicializar o cliente!");
        }
        System.out.println("Cliente finalizado!");

    }
}
