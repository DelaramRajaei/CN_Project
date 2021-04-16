import java.io.DataOutputStream;
import java.util.zip.CheckedOutputStream;

public class Client {

    private static String message = "Hello Server!";

    private static final String dnsServer = "8.8.8.8";
    private static final int dnsServerPort = 53;

    private static final String localServer = "localhost";
    private static final int localServerPort = 3000;


    public static void main(String[] args) {

        sendMessage(message,dnsServer,dnsServerPort); // Send a message to public dns server of google
        sendMessage(message,localServer,localServerPort); // Send a message to local server

    }

    private static void sendMessage(String message, String hostName, int port){
        try {
            java.net.Socket client = new java.net.Socket(hostName, port);

            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
            dout.writeUTF(message);
            dout.flush();
            dout.close();

            client.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
