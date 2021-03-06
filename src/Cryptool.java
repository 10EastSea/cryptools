public class Cryptool {

    /*
     *  How to use: java -jar cryptools.jar [FALG]
     *
     *      [FLAG]
     *          -s2b <string>: 문자열을 2진법으로 바꿈 (UTF-8)
     *          -b2s <binary>: 2진법을 문자열로 바꿈 (UTF-8)
     *          -s2b-ascii <string>: 문자열을 2진법으로 바꿈 (ASCII)
     *          -b2s-ascii <binary>: 2진법을 문자열로 바꿈 (ASCII)
     *
     *          -h2b <hex>: 16진법을 2진법으로 바꿈
     *          -b2h <binary>: 2진법을 16진법으로 바꿈
     *          -h2s <hex>: 16진법을 문자열로 바꿈 (UTF-8)
     *          -s2h <string>: 문자열을 16진법으로 바꿈 (UTF-8)
     *          -h2s-ascii <hex>: 16진법을 문자열로 바꿈 (ASCII)
     *          -s2h-ascii <string>: 문자열을 16진법으로 바꿈 (ASCII)
     *
     *          -xor <binary1> <binary2>: binary1과 binary2를 xor 연산
     *          -xor-hex <hex1> <hex2>: hex1과 hex2를 xor 연산
     *
     *          -otp-e <string>: 문자열을 OTP로 암호화 (암호화된 값과 키를 제공)
     *          -otp-d <encryption value> <key>: 암호화된 값을 복호화
     *          -otp-e-hex <string>: 문자열을 OTP로 암호화 (암호화된 값과 키를 제공)
     *          -otp-d-hex <encryption value> <key>: 암호화된 값을 복호화
     * 
     *          -md2 <message>: MD2 해시 값
     *          -md5 <message>: MD5 해시 값
     *          -sha1 <message>: SHA-1 해시 값
     *          -sha256 <message>: SHA-256 해시 값
     *          -sha384 <message>: SHA-384 해시 값
     *          -sha512 <message>: SHA-512 해시 값
     * 
     *          -b64-e <message>: Base64 인코딩
     *          -b64-d <encoded message>: Base64 디코딩 
     * 
     *          [FLAG]-f <file path> (<file path2>): 파일 입출력으로 위 과정 수행
     *
     *          -help: 사용법을 보여줌
     */

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String remainArgs(String[] args, int start) {
        StringBuilder sb = new StringBuilder();
        for(int i=start; i<args.length; i++) sb.append(args[i] + " ");
        return sb.toString().trim();
    }

    public static void help(String msg) {
        System.out.println("\n" + msg + "\n");
        System.out.println("    -s2b <string>       : string to binary (string encoded with UTF-8)");
        System.out.println("    -b2s <binary>       : binary to string (string encoded with UTF-8)");
        System.out.println("    -s2b-ascii <string> : string to binary (string encoded with ASCII)");
        System.out.println("    -b2s-ascii <binary> : binary to string (string encoded with ASCII)");
        System.out.println();
        System.out.println("    -h2b <hex>          : hex to binary");
        System.out.println("    -b2h <binary>       : binary to hex");
        System.out.println("    -h2s <hex>          : hex to string (string encoded with UTF-8)");
        System.out.println("    -s2h <string>       : string to hex (string encoded with UTF-8)");
        System.out.println("    -h2s-ascii <hex>    : hex to string (string encoded with ASCII)");
        System.out.println("    -s2h-ascii <string> : string to hex (string encoded with ASCII)");
        System.out.println();
        System.out.println("    -xor <binary1> <binary2> : <binary1> xor <binary2>");
        System.out.println("    -xor-hex <hex1> <hex2>   : <hex1> xor <hex2>");
        System.out.println();
        System.out.println("    -otp-e <string>                     : encryption of <string> using One Time Pad (return encryption value and key)");
        System.out.println("    -otp-d <encryption value> <key>     : decryption of <encryption value> using One Time Pad");
        System.out.println("    -otp-e-hex <string>                 : encryption of <string> using One Time Pad (return encryption value and key)");
        System.out.println("    -otp-d-hex <encryption value> <key> : decryption of <encryption value> using One Time Pad");
        System.out.println();
        System.out.println("    -md2 <message>    : hash to message using MD2");
        System.out.println("    -md5 <message>    : hash to message using MD5");
        System.out.println("    -sha1 <message>   : hash to message using SHA-1");
        System.out.println("    -sha256 <message> : hash to message using SHA-256");
        System.out.println("    -sha384 <message> : hash to message using SHA-384");
        System.out.println("    -sha512 <message> : hash to message using SHA-512");
        System.out.println();
        System.out.println("    -b64-e <message>         : encode the message using Base64 Encode");
        System.out.println("    -b64-d <encoded message> : decode the encoded message using Base64 Decode");
        System.out.println();
        System.out.println("    [FLAG]-f <file path> (<file path2>) : perform the above process by FileIO");
        System.out.println();
        System.out.println("    -help: show you how to use it");
        System.out.println();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) throws Exception {
        if(args.length < 1) { help("Please enter the [FLAG]"); return; }

        if(args[0].equals("-s2b")) {
            if(args.length < 2) { help("[-s2b]: Please enter the <string>"); return; }
            System.out.println(Util.stringToBinary(remainArgs(args, 1), "utf-8"));
        } else if(args[0].equals("-b2s")) {
            if(args.length < 2) { help("[-b2s]: Please enter the <binary>"); return; }

            String binary = remainArgs(args, 1);
            if(!Util.checkBinary(binary)) { help("[-b2s]: <binary> is not binary (Enter only 0 and 1)"); return; }

            System.out.println(Util.binaryToString(binary));
        } else if(args[0].equals("-s2b-ascii")) {
            if(args.length < 2) { help("[-s2b-ascii]: Please enter the <string>"); return; }
            System.out.println(Util.stringToBinary(remainArgs(args, 1), "ascii"));
        } else if(args[0].equals("-b2s-ascii")) {
            if(args.length < 2) { help("[-b2s-ascii]: Please enter the <binary>"); return; }

            String binary = remainArgs(args, 1);
            if(!Util.checkBinary(binary)) { help("[-b2s-ascii]: <binary> is not binary (Enter only 0 and 1)"); return; }

            System.out.println(Util.binaryToString(binary));
        }

        else if(args[0].equals("-h2b")) {
            if(args.length < 2) { help("[-h2b]: Please enter the <hex>"); return; }

            String hex = remainArgs(args, 1);
            if(!Util.checkHex(hex)) { help("[-h2b]: <hex> is not hex (Enter only numbers and A to F(a ~ f))"); return; }

            System.out.println(Util.hexToBinary(hex));
        } else if(args[0].equals("-b2h")) {
            if(args.length < 2) { help("[-b2h]: Please enter the <binary>"); return; }

            String binary = remainArgs(args, 1);
            if(!Util.checkBinary(binary)) { help("[-b2h]: <binary> is not binary (Enter only 0 and 1)"); return; }

            System.out.println(Util.binaryToHex(binary));
        } else if(args[0].equals("-h2s")) {
            if(args.length < 2) { help("[-h2s]: Please enter the <hex>"); return; }

            String hex = remainArgs(args, 1);
            if(!Util.checkHex(hex)) { help("[-h2s]: <hex> is not hex (Enter only numbers and A to F(a ~ f))"); return; }

            System.out.println(Util.binaryToString(Util.hexToBinary(hex)));
        } else if(args[0].equals("-s2h")) {
            if(args.length < 2) { help("[-s2h]: Please enter the <string>"); return; }
            System.out.println(Util.binaryToHex(Util.stringToBinary(remainArgs(args, 1), "utf-8")));
        } else if(args[0].equals("-h2s-ascii")) {
            if(args.length < 2) { help("[-h2s-ascii]: Please enter the <hex>"); return; }

            String hex = remainArgs(args, 1);
            if(!Util.checkHex(hex)) { help("[-h2s-ascii]: <hex> is not hex (Enter only numbers and A to F(a ~ f))"); return; }

            System.out.println(Util.binaryToString(Util.hexToBinary(hex)));
        } else if(args[0].equals("-s2h-ascii")) {
            if(args.length < 2) { help("[-s2h-ascii]: Please enter the <string>"); return; }
            System.out.println(Util.binaryToHex(Util.stringToBinary(remainArgs(args, 1), "ascii")));
        }

        else if(args[0].equals("-xor")) {
            if(args.length < 3) { help("[-xor]: Please enter the <binary1> and <binary2>"); return; }

            String binary1 = args[1], binary2 = args[2];
            if(!Util.checkBinary(binary1) || !Util.checkBinary(binary2)) { help("[-xor]: <binary1> and <binary2> are not binary (Enter only 0 and 1)"); return; }

            System.out.println(Util.xor(binary1, binary2));
        } else if(args[0].equals("-xor-hex")) {
            if(args.length < 3) { help("[-xor-hex]: Please enter the <hex1> and <hex2>"); return; }

            String hex1 = args[1], hex2 = args[2];
            if(!Util.checkHex(hex1) || !Util.checkHex(hex2)) { help("[-xor-hex]: <hex1> and <hex2> are not hex (Enter only numbers and A to F(a ~ f))"); return; }

            System.out.println(Util.binaryToHex(Util.xor(Util.hexToBinary(hex1), Util.hexToBinary(hex2))));
        }

        else if(args[0].equals("-otp-e")) {
            if(args.length < 2) { help("[-otp-e]: Please enter the <string>"); return; }

            OTP otp = new OTP(remainArgs(args, 1));
            System.out.println(otp.getEValue());
            System.out.println("(Key: " + otp.getKey() + ")");
        } else if(args[0].equals("-otp-d")) {
            if(args.length != 3) { help("[-otp-d]: Please enter the <encryption value> and <key>"); return; }

            String binary1 = args[1], binary2 = args[2];
            if(!Util.checkBinary(binary1) || !Util.checkBinary(binary2)) { help("[-otp-d]: <encryption value> and <key> are not binary (Enter only 0 and 1)"); return; }

            OTP otp = new OTP(binary1, binary2);
            System.out.println(otp.getDValue());
        } else if(args[0].equals("-otp-e-hex")) {
            if(args.length < 2) { help("[-otp-e-hex]: Please enter the <string>"); return; }

            OTP otp = new OTP(remainArgs(args, 1));
            System.out.println(Util.binaryToHex(otp.getEValue()));
            System.out.println("(Key: " + Util.binaryToHex(otp.getKey()) + ")");
        } else if(args[0].equals("-otp-d-hex")) {
            if(args.length != 3) { help("[-otp-d-hex]: Please enter the <encryption value> and <key>"); return; }

            String hex1 = args[1], hex2 = args[2];
            if(!Util.checkHex(hex1) || !Util.checkHex(hex2)) { help("[-otp-d-hex]: <encryption value> and <key> are not hex (Enter only numbers and A to F(a ~ f))"); return; }

            OTP otp = new OTP(Util.hexToBinary(hex1), Util.hexToBinary(hex2));
            System.out.println(otp.getDValue());
        }

        else if(args[0].equals("-md2")) {
            if(args.length < 2) { help("[-md2]: Please enter the <message>"); return; }
            
            Hash hash = new Hash(remainArgs(args, 1));
            System.out.println(hash.getMD2());
        } else if(args[0].equals("-md5")) {
            if(args.length < 2) { help("[-md5]: Please enter the <message>"); return; }
            
            Hash hash = new Hash(remainArgs(args, 1));
            System.out.println(hash.getMD5());
        } else if(args[0].equals("-sha1")) {
            if(args.length < 2) { help("[-sha1]: Please enter the <message>"); return; }
            
            Hash hash = new Hash(remainArgs(args, 1));
            System.out.println(hash.getSHA1());
        } else if(args[0].equals("-sha256")) {
            if(args.length < 2) { help("[-sha256]: Please enter the <message>"); return; }
            
            Hash hash = new Hash(remainArgs(args, 1));
            System.out.println(hash.getSHA256());
        } else if(args[0].equals("-sha384")) {
            if(args.length < 2) { help("[-sha384]: Please enter the <message>"); return; }
            
            Hash hash = new Hash(remainArgs(args, 1));
            System.out.println(hash.getSHA384());
        } else if(args[0].equals("-sha512")) {
            if(args.length < 2) { help("[-sha512]: Please enter the <message>"); return; }
            
            Hash hash = new Hash(remainArgs(args, 1));
            System.out.println(hash.getSHA512());
        }

        else if(args[0].equals("-b64-e")) {
            if(args.length < 2) { help("[-b64-e]: Please enter the <message>"); return; }

            Base base = new Base(remainArgs(args, 1));
            System.out.println(base.getEncodedMsg());
        } else if(args[0].equals("-b64-d")) {
            if(args.length < 2) { help("[-b64-d]: Please enter the <encoded message>"); return; }

            Base base = new Base(remainArgs(args, 1));
            System.out.println(base.getDecodedMsg());
        }
        
        else if(args[0].equals("-help")) { help("java -jar cryptools.jar [FALG]"); }
        else { if(!FileManager.checkAndDoFileFlag(args)) help("This [FLAG] does not exist"); }
    }
}
