package Scripts.Ex07;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static final String ADDRESS = "127.0.0.1";
    public static final int PORT = 3304;
    private ServerSocket serverSocket;

    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor iniciado na porta " + PORT);
        clientConnectionLoop();
    }

    private void clientConnectionLoop() throws IOException {
        System.out.println("Aguardando a conexao de um cliente");
        do {
            ClientSocket clientSocket = new ClientSocket(serverSocket.accept());
            new Thread(() -> clientMessageLoop(clientSocket)).start();

        } while (true);
    }

    private void clientMessageLoop(ClientSocket clientSocket) {
        String msg;
        try {
            while ((msg = clientSocket.getMessage()) != null && !msg.equalsIgnoreCase("sair")) {
                System.out.printf("Mensagem recebida do cliente %s: %s\n", clientSocket.getRemoteSocketAddress(), msg);

            }
        } finally {
            clientSocket.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("********CONSOLE DO SERVER RAPA*******");

        try {
            Server server = new Server();
            server.start();

        } catch (Exception e) {
            System.out.println("Erro ao iniciar o server: " + e);
        }
        System.out.println("Server finalizado!");;
    }
}
