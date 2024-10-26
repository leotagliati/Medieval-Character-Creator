package Scripts.ClientServer;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Client(String serverAddress, int serverPort) throws IOException {
        socket = new Socket(serverAddress, serverPort);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("Connected to server.");
    }

    // Método para enviar mensagem ao servidor e retornar a resposta
    public String sendMessage(String message) {
        try {
            // Enviar a mensagem
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            // Ler e retornar a resposta do servidor
            String response = bufferedReader.readLine();
            // System.out.println("Server: " + response);

            // Fecha a conexão se a mensagem for "quit"
            if ("quit".equalsIgnoreCase(message)) {
                closeConnection();
                System.out.println("Connection closed.");
            }

            return response; // Retornar a resposta para ser salva em uma variável
        } catch (IOException e) {
            System.out.println("Error sending message: " + e.getMessage());
            return null; // Retorna null em caso de erro
        }
    }

    // Método para fechar a conexão
    private void closeConnection() {
        try {
            if (socket != null) socket.close();
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}
