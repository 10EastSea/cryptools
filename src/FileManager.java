import java.io.*;

public class FileManager {
    public static final String OUTPUT_FILE_PATH = "./output.txt";
    public static final String ENCRYPTION_FILE_PATH = "./encryption.txt";
    public static final String KEY_FILE_PATH = "./key.txt";

    public static String readFile(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        int c;
        while((c = br.read()) != -1) sb.append((char)c);
        br.close();

        return sb.toString();
    }

    public static void writeFile(String contents) throws IOException {
        File file = new File(OUTPUT_FILE_PATH);
        file.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(contents);
        bw.flush();
        bw.close();
    }



    public static void writeKeyFile(String contents) throws IOException {
        File file = new File(KEY_FILE_PATH);
        file.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(contents);
        bw.flush();
        bw.close();
    }

    public static void writeEncryptionFile(String contents) throws IOException {
        File file = new File(ENCRYPTION_FILE_PATH);
        file.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(contents);
        bw.flush();
        bw.close();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static boolean checkAndDoFileFlag(String[] args) {
        if(args[0].equals("-s2b-f")) {
            if(args.length < 2) { Cryptool.help("[-s2b-f]: Please enter the <file path>"); return true; }

            try {
                String str = FileManager.readFile(args[1]);
                FileManager.writeFile(Util.stringToBinary(str, "UTF-8"));
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-s2h-f")) {
            if(args.length < 2) { Cryptool.help("[-s2h-f]: Please enter the <file path>"); return true; }

            try {
                String str = FileManager.readFile(args[1]);
                FileManager.writeFile(Util.binaryToHex(Util.stringToBinary(str, "UTF-8")));
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-b2s-f")) {
            if(args.length < 2) { Cryptool.help("[-b2s-f]: Please enter the <file path>"); return true; }

            try {
                String binary = FileManager.readFile(args[1]);
                if(!Util.checkBinary(binary)) { Cryptool.help("[-b2s-f]: The contents of the file are not binary (Enter only 0 and 1)"); return true; }
                FileManager.writeFile(Util.binaryToString(binary));
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-b2h-f")) {
            if(args.length < 2) { Cryptool.help("[-b2h-f]: Please enter the <file path>"); return true; }

            try {
                String binary = FileManager.readFile(args[1]);
                if(!Util.checkBinary(binary)) { Cryptool.help("[-b2h-f]: The contents of the file are not binary (Enter only 0 and 1)"); return true; }
                FileManager.writeFile(Util.binaryToHex(binary));
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-h2s-f")) {
            if(args.length < 2) { Cryptool.help("[-h2s-f]: Please enter the <file path>"); return true; }

            try {
                String hex = FileManager.readFile(args[1]);
                if(!Util.checkHex(hex)) { Cryptool.help("[-h2s-f]: The contents of the file are not hex (Enter only numbers and A to F(a ~ f))"); return true; }
                FileManager.writeFile(Util.binaryToString(Util.hexToBinary(hex)));
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-h2b-f")) {
            if(args.length < 2) { Cryptool.help("[-h2b-f]: Please enter the <file path>"); return true; }

            try {
                String hex = FileManager.readFile(args[1]);
                if(!Util.checkHex(hex)) { Cryptool.help("[-h2b-f]: The contents of the file are not hex (Enter only numbers and A to F(a ~ f))"); return true; }
                FileManager.writeFile(Util.hexToBinary(hex));
            } catch(IOException e) { System.out.println("File is not found"); }
        } 

        else if(args[0].equals("-xor-f")) {
            if(args.length < 3) { Cryptool.help("[-xor-f]: Please enter the <file path1> and <file path2>"); return true; }

            try {
                String binary1 = FileManager.readFile(args[1]), binary2 = FileManager.readFile(args[2]);;
                if(!Util.checkBinary(binary1) || !Util.checkBinary(binary2)) { Cryptool.help("[-xor-f]: The contents of the files are not binary (Enter only 0 and 1)"); return true; }
                FileManager.writeFile(Util.xor(binary1, binary2));
            } catch(IOException e) { System.out.println("Files are not found"); }
        } else if(args[0].equals("-xor-hex-f")) {
            if(args.length < 3) { Cryptool.help("[-xor-hex-f]: Please enter the <file path1> and <file path2>"); return true; }

            try {
                String hex1 = FileManager.readFile(args[1]), hex2 = FileManager.readFile(args[2]);
                if(!Util.checkHex(hex1) || !Util.checkHex(hex2)) { Cryptool.help("[-xor-hex-f]: The contents of the files are not hex (Enter only numbers and A to F(a ~ f))"); return true; }
                FileManager.writeFile(Util.binaryToHex(Util.xor(Util.hexToBinary(hex1), Util.hexToBinary(hex2))));
            } catch(IOException e) { System.out.println("Files are not found"); }
        }

        else if(args[0].equals("-otp-e-f")) {
            if(args.length < 2) { Cryptool.help("[-otp-e-f]: Please enter the <file path>"); return true; }

            try {
                OTP otp = new OTP(FileManager.readFile(args[1]));
                FileManager.writeEncryptionFile(otp.getEValue());
                FileManager.writeKeyFile(otp.getKey());
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-otp-d-f")) {
            if(args.length != 3) { Cryptool.help("[-otp-d-f]: Please enter the <file path1> and <file path2>"); return true; }

            try {
                String binary1 = FileManager.readFile(args[1]), binary2 = FileManager.readFile(args[2]);
                if(!Util.checkBinary(binary1) || !Util.checkBinary(binary2)) { Cryptool.help("[-otp-d-f]: The contents of the files are not binary (Enter only 0 and 1)"); return true; }
    
                OTP otp = new OTP(binary1, binary2);
                FileManager.writeFile(otp.getDValue());
            } catch(IOException e) { System.out.println("Files are not found"); }
        } else if(args[0].equals("-otp-e-hex-f")) {
            if(args.length < 2) { Cryptool.help("[-otp-e-hex-f]: Please enter the <file path>"); return true; }

            try {
                OTP otp = new OTP(FileManager.readFile(args[1]));
                FileManager.writeEncryptionFile(Util.binaryToHex(otp.getEValue()));
                FileManager.writeKeyFile(Util.binaryToHex(otp.getKey()));
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-otp-d-hex-f")) {
            if(args.length != 3) { Cryptool.help("[-otp-d-hex-f]: Please enter the <file path1> and <file path2>"); return true; }

            try{
                String hex1 = FileManager.readFile(args[1]), hex2 = FileManager.readFile(args[2]);
                if(!Util.checkHex(hex1) || !Util.checkHex(hex2)) { Cryptool.help("[-otp-d-hex-f]: The contents of the files are not hex (Enter only numbers and A to F(a ~ f))"); return true; }
    
                OTP otp = new OTP(Util.hexToBinary(hex1), Util.hexToBinary(hex2));
                FileManager.writeFile(otp.getDValue());
            } catch(IOException e) { System.out.println("Files are not found"); }
        }

        else if(args[0].equals("-md2-f")) {
            if(args.length < 2) { Cryptool.help("[-md2-f]: Please enter the <file path>"); return true; }
            
            try {
                Hash hash = new Hash(FileManager.readFile(args[1]));
                FileManager.writeFile(hash.getMD2());
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-md5-f")) {
            if(args.length < 2) { Cryptool.help("[-md5-f]: Please enter the <file path>"); return true; }
            
            try {
                Hash hash = new Hash(FileManager.readFile(args[1]));
                FileManager.writeFile(hash.getMD5());
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-sha1-f")) {
            if(args.length < 2) { Cryptool.help("[-sha1-f]: Please enter the <file path>"); return true; }
            
            try {
                Hash hash = new Hash(FileManager.readFile(args[1]));
                FileManager.writeFile(hash.getSHA1());
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-sha256-f")) {
            if(args.length < 2) { Cryptool.help("[-sha256-f]: Please enter the <file path>"); return true; }
            
            try {
                Hash hash = new Hash(FileManager.readFile(args[1]));
                FileManager.writeFile(hash.getSHA256());
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-sha384-f")) {
            if(args.length < 2) { Cryptool.help("[-sha384-f]: Please enter the <file path>"); return true; }
            
            try {
                Hash hash = new Hash(FileManager.readFile(args[1]));
                FileManager.writeFile(hash.getSHA384());
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-sha512-f")) {
            if(args.length < 2) { Cryptool.help("[-sha512-f]: Please enter the <file path>"); return true; }
            
            try {
                Hash hash = new Hash(FileManager.readFile(args[1]));
                FileManager.writeFile(hash.getSHA512());
            } catch(IOException e) { System.out.println("File is not found"); }
        }

        else if(args[0].equals("-b64-e-f")) {
            if(args.length < 2) { Cryptool.help("[-b64-e-f]: Please enter the <file path>"); return true; }

            try {
                Base base = new Base(FileManager.readFile(args[1]));
                FileManager.writeFile(base.getEncodedMsg());
            } catch(IOException e) { System.out.println("File is not found"); }
        } else if(args[0].equals("-b64-d-f")) {
            if(args.length < 2) { Cryptool.help("[-b64-d-f]: Please enter the <file path>"); return true; }

            try {
                Base base = new Base(FileManager.readFile(args[1]));
                FileManager.writeFile(base.getDecodedMsg());
            } catch(IOException e) { System.out.println("File is not found"); }
        }

        else return false;
        return true;
    }
}
