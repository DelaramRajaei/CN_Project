package Dns_Protocol_Structure;

import java.lang.*;
import java.io.*;

public class Header {

    private int messageID;       //                                 16bit
    /* Flags */
    private int QR;              //Query: 0, Response: 1             1bit
    private int OPCODE;          //Standard query,(0-2)              4bit
    private int AA;              //Authoritative Or Not              1bit
    private int TC;              //Message Is Truncated              1bit
    private int RD;              //Recursion                         1bit
    private int RA;              //Iterative                         1bit
    private int Z;               //                                  3bit
    private int RCODE;           //Type Of Error                     4bit
    private int QDCOUNT;         // Number Of Questions              4bit
    private int ANCOUNT;         // Number Of Answers                4bit
    private int NSCOUNT;         // Number Of Authority Records      4bit
    private int ARCOUNT;         // Number Of Additional Records     4bit

    public Header(String type) {
        messageID = typeOfID(type);
        QR = 0;
        OPCODE = 0;
        AA = 0;
        TC = 0;
        RD = 0;
        RA = 0;
        Z = 0;
        RCODE = 0;
        QDCOUNT = 1;
        ANCOUNT = 0;
        NSCOUNT = 0;
        ARCOUNT = 0;
    }

    public String getHeader() {
        String flags = QR + padLeftZeros(OPCODE + "", 4) + AA + TC + RD + RA
                + padLeftZeros(Z + "", 3) + padLeftZeros(RCODE + "", 4);
        flags = String.format("%04X", Integer.parseInt(flags));
        String message = String.format("%04X", messageID) + flags +
                String.format("%04X", QDCOUNT) +
                String.format("%04X", ANCOUNT) +
                String.format("%04X", NSCOUNT) +
                String.format("%04X", ARCOUNT);

        return message;
    }

    private String padLeftZeros(String str, int n) {
        return String.format("%1$" + n + "s", str).replace(' ', '0');
    }

    private int typeOfID(String type) {
        int id;
        switch (type) {
            case "NS":
                id = 2;   // NS record
                break;
            case "CNAME":
                id = 5;   // CNAME record
                break;
            case "MX":
                id = 15;  // MX record
                break;
            default:
                id = 1;   // A record
        }
        return id;
    }
}
