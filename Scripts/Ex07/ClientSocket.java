package Scripts.Ex07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientSocket {
    private final Socket socket;
    private final BufferedReader input;
    private final PrintWriter output;

    public ClientSocket(Socket socket) throws IOException {
        this.socket = socket;
        System.out.println("Cliente " + socket.getRemoteSocketAddress() + " se conectou!");
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
    }

    public SocketAddress getRemoteSocketAddress() {
        return this.socket.getRemoteSocketAddress();
    }

    public void close() {
        try {
            input.close();
            output.close();
            socket.close();

        } catch (IOException e) {
            return;
        }
    }

    public boolean sendMsg(String msg)
    {
        output.println(msg);
        return !output.checkError();
    }

    public String getMessage() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }

}
