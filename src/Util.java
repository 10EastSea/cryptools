import java.util.regex.Pattern;
import java.io.*;
import java.math.*;

public class Util {
    public static boolean checkBinary(String binary) {
        return Pattern.matches("^[0-1]*$", binary);
    }

    public static boolean checkHex(String hex) {
        return Pattern.matches("^[0-9a-fA-F]*$", hex);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String stringToBinary(String msg, String encode) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();

        byte[] bytes = msg.getBytes("utf-8");
        for (int i = 0; i < bytes.length; i++)
            sb.append(byteToBinary(bytes[i]));

        return sb.toString();
    }

    private static String byteToBinary(byte b) {
        StringBuilder sb = new StringBuilder("00000000");

        for (int i = 0; i < 8; i++) {
            if (((b >> i) & 1) > 0)
                sb.setCharAt(7 - i, '1');
        }

        return sb.toString();
    }

    public static String binaryToString(String msg) {
        int n = msg.length() / 8;
        byte[] bytes = new byte[n];

        for (int i = 0; i < n; i++) {
            String str = msg.substring(i * 8, (i + 1) * 8);
            bytes[i] = binaryToByte(str);
        }

        return new String(bytes);
    }

    private static byte binaryToByte(String binary) {
        byte tmp = 0, result = 0;

        for (int i = 0; i < 8; i++) {
            tmp = (binary.charAt(7 - i) == '1') ? (byte) (1 << i) : 0;
            result = (byte) (tmp | result);
        }

        return result;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String hexToBinary(String hex) {
        StringBuilder sb = new StringBuilder(new BigInteger(hex, 16).toString(2));

        int count = (hex.length() * 4) - sb.toString().length();
        for (int i = 0; i < count; i++)
            sb.insert(0, "0");

        return sb.toString();
    }

    public static String binaryToHex(String binary) {
        StringBuilder sb = new StringBuilder(new BigInteger(binary, 2).toString(16));

        int count = (int) Math.ceil((binary.length() - (sb.toString().length() * 4)) / 4.0);
        for (int i = 0; i < count; i++)
            sb.insert(0, "0");

        return sb.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String xor(String binary1, String binary2) {
        StringBuilder sb = new StringBuilder();

        int len = binary1.length();
        if (binary1.length() > binary2.length()) {
            len = binary2.length();
            int count = binary1.length() - binary2.length();
            for (int i = 0; i < count; i++) {
                int a = binary1.charAt(0) - '0';
                sb.append(a);
                binary1 = binary1.substring(1);
            }
        } else if (binary1.length() < binary2.length()) {
            int count = binary2.length() - binary1.length();
            for (int i = 0; i < count; i++) {
                int a = binary2.charAt(0) - '0';
                sb.append(a);
                binary2 = binary2.substring(1);
            }
        }

        for (int i = 0; i < len; i++) {
            int a = binary1.charAt(i) - '0';
            int b = binary2.charAt(i) - '0';
            sb.append(a ^ b);
        }

        return sb.toString();
    }
}
