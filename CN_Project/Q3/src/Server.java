import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);

            while (true) {
                java.net.Socket socket = serverSocket.accept();

                DataInputStream din = new DataInputStream(socket.getInputStream());
                String clientMessage = din.readUTF();
                InetSocketAddress clientSocket = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("Message received from " + clientSocket.getAddress() +
                        " port " + clientSocket.getPort() +": \""+ clientMessage+ "\"");


                DataOutputStream dout=new DataOutputStream(socket.getOutputStream());
                String serverMessage;
                serverMessage = "Hi back!";
                dout.writeUTF(serverMessage);

                socket.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
