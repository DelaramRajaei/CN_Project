import Dns_Protocol_Structure.Header;
import Dns_Protocol_Structure.Payload;
import Dns_Protocol_Structure.Question;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static String message = "Hello Server!";

    private static final String dnsServer = "8.8.8.8";
    private static final int dnsServerPort = 53;

    private static final String localServer = "localhost";
    private static final int localServerPort = 3000;


    public static void main(String[] args) {

        buildMessage("A", "google.com");

//        try {
//
////            java.net.Socket client = new java.net.Socket(dnsServer, dnsServerPort);
////
////            Scanner scan = new Scanner(System.in);
////            System.out.println("Please enter name address:");
////            String nameAddress = scan.nextLine();
////
////            sendMessage(message, client); // Send a message to local server
////            getMessage(client);
////
////            client.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void buildMessage(String type, String address) {
        Header header = new Header(type);
        Question question = new Question(address);
        Payload answer = new Payload();
        Payload Authority = new Payload();
        Payload Additional = new Payload();

        System.out.println(header.getHeader());
    }

    private static void getMessage(Socket client) {
        try {
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            String receive = in.readUTF();
            System.out.println("Server said: " + receive);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void sendMessage(String message, Socket client) {
        try {

            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
            dout.writeUTF(message);
            dout.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
