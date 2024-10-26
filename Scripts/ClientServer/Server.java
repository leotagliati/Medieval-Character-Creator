package Scripts.ClientServer;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(3304);
        while (true) {
            try {
                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                while (true) {
                    String msgFromClient = bufferedReader.readLine();

                    System.out.println("Client: " + msgFromClient);

                    bufferedWriter.write("Msg RECEIVED");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    if(msgFromClient.equalsIgnoreCase("quit"))
                    {
                        break;
                    }
                }
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
