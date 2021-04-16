package Dns_Protocol_Structure;

public class Question {

    private String QName;          //Domain Name
    private String QTYPE;          //Record Type       2byte
    private int QClass;            //Classes Type      2byte

    public Question(String address){
        String[] splitted = address.split(".");
        String adrLength;
        for (int i = 0; i < splitted.length; i++) {
            adrLength = String.format("%02X", splitted[i].length());
        }
    }
}
