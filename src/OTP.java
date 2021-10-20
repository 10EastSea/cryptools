import java.util.*;
import java.io.*;
import java.security.*;

public class OTP {
    private String key;
    private String eValue, dValue;

    public OTP(String str) throws UnsupportedEncodingException {
        String binary = Util.stringToBinary(str, "utf-8");
        makeRandomKey(binary.length());
        encryptValue(binary, binary.length());
    }

    public OTP(String eValue, String key) {
        decryptValue(eValue, key);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    private void makeRandomKey(int len) {
        StringBuilder sb = new StringBuilder();

        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());

        for (int i = 0; i < len; i++)
            sb.append(sr.nextInt(2));
        key = sb.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    private void encryptValue(String binary, int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int a = binary.charAt(i) - '0';
            int b = key.charAt(i) - '0';
            sb.append(a ^ b);
        }

        eValue = sb.toString();
    }

    private void decryptValue(String eValue, String key) {
        StringBuilder sb = new StringBuilder();

        int len = (key.length() < eValue.length()) ? key.length() : eValue.length();
        for (int i = 0; i < len; i++) {
            int a = eValue.charAt(i) - '0';
            int b = key.charAt(i) - '0';
            sb.append(a ^ b);
        }

        dValue = Util.binaryToString(sb.toString());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getKey() {
        return key;
    }

    public String getEValue() {
        return eValue;
    }

    public String getDValue() {
        return dValue;
    }
}
