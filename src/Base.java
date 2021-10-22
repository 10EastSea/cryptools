import java.util.Base64;

public class Base {
    private String encodedMsg = "", decodedMsg = "";

    public Base(String msg) {
        try {
            encodedMsg = Base64.getEncoder().encodeToString(msg.getBytes());
            decodedMsg = new String(Base64.getDecoder().decode(msg));
        } catch(IllegalArgumentException e) {
            decodedMsg = "It's not an encoded message";
        }
    }

    public String getEncodedMsg() { return encodedMsg; }
    public String getDecodedMsg() { return decodedMsg; }
}
