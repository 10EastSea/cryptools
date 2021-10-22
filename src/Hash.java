import java.security.*;

public class Hash {
    private String msg;
    private String md2 = "", md5 = "";
    private String sha1 = "", sha256 = "", sha384 = "", sha512 = "";
    private MessageDigest md;

    public Hash(String msg) {
        this.msg = msg;

        try {
            md2 = makeHash("MD2");
            md5 = makeHash("MD5");
            sha1 = makeHash("SHA-1");
            sha256 = makeHash("SHA-256");
            sha384 = makeHash("SHA-384");
            sha512 = makeHash("SHA-512");
        } catch(NoSuchAlgorithmException e) { }
    }

    private String makeHash(String algorithm) throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance(algorithm);
        md.update(msg.getBytes());
        return Util.bytesToHex(md.digest());
    }

    public String getMD2() { return md2; }
    public String getMD5() { return md5; }
    public String getSHA1() { return sha1; }
    public String getSHA256() { return sha256; }
    public String getSHA384() { return sha384; }
    public String getSHA512() { return sha512; }
}
