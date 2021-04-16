import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        try {
            while (true) {
                ServerSocket serverSocket = new ServerSocket(3000);
                java.net.Socket socket = serverSocket.accept();

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String str = (String) dis.readUTF();

                InetSocketAddress clientSocket = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("Message received from " + clientSocket.getAddress() + " port " + clientSocket.getPort() +": \""+ str+ "\"");
                serverSocket.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
