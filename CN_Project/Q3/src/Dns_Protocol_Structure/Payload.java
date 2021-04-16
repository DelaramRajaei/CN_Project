package Dns_Protocol_Structure;

public class Payload {

    private String NAME;           //Domain Name
    private String TYPE;           //Record Type             2byte
    private int CLASS;             //RDATA Classes Type      2byte
    private int TTL;               //                        2byte
    private int RDLENGTH;          //Length Of RDATA         2byte
    private int RDATA;             //                        2byte

    public Payload(){

    }
}
