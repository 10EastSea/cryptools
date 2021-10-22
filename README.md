# Cryptools

1. Binary, Hexadecimal, String Converter
2. XOR Calculator
3. One-Time Pad
4. Hash Function
5. Base64 Encode & Decode

> This program provides various calculations used for crypto.

# Usage

```Bash
# java version: openjdk 11.0.11
java -jar cryptools.jar [FLAG]
```

<br />

## 1. Binary, Hexadecimal, String Converter

- `-s2b <string>` :  string to binary
```Bash
# You can enter it without double quotes
>> java -jar cryptools.jar -s2b "apple"
0110000101110000011100000110110001100101
```

- `-b2s <binary>` :  binary to string
```Bash
>> java -jar cryptools.jar -b2s "0110000101110000011100000110110001100101"
apple
```

- `-s2h <string>` :  string to hex
```Bash
>> java -jar cryptools.jar -s2h "banana"
62616e616e61
```

- `-h2s <hex>` :  hex to string
```Bash
>> java -jar cryptools.jar -h2s "62616e616e61"
banana
```

- `-h2b <hex>` :  hex to binary
```Bash
>> java -jar cryptools.jar -h2b "68656c6c6f"
0110100001100101011011000110110001101111
```

- `-b2h <binary>` :  binary to hex
```Bash
>> java -jar cryptools.jar -b2h "0110100001100101011011000110110001101111"
68656c6c6f
```

<br />

## 2. XOR Calculator

- `-xor <binary1> <binary2>` :  binary1 XOR binary2
```Bash
>> java -jar cryptools.jar -xor "01101011" "11001001"
10100010

# To match the length, it calculates by concatenating zero to the front of the shorter binary
>> java -jar cryptools.jar -xor "01101011" "1001"    
01100010
```

- `-xor-hex <hex1> <hex2>` :  hex1 XOR hex2
```Bash
>> java -jar cryptools.jar -xor-hex "6170706c65" "62616e616e61"
62001e110204
```

<br />

## 3. One-Time Pad

- `-otp-e <string>` :  encryption of string using One-Time Pad (return encryption value and key)
```Bash
>> java -jar cryptools.jar -otp-e "secret"
100010000001011011011001001111111010100010011101
(Key: 111110110111001110111010010011011100110111101001)
```

- `-otp-d <encryption value> <key>` :  decryption of encryption value using One Time Pad
```Bash
>> java -jar cryptools.jar -otp-d "100010000001011011011001001111111010100010011101" "111110110111001110111010010011011100110111101001"
secret
```

- `-otp-e-hex <string>` :  encryption of string using One-Time Pad (return encryption value and key)
```Bash
>> java -jar cryptools.jar -otp-e-hex "10EastSea"
59f74da37a42841558
(Key: 68c708c20936d77039)
```

- `-otp-d-hex <encryption value> <key>` :  decryption of encryption value using One Time Pad
```Bash
>> java -jar cryptools.jar -otp-d-hex "59f74da37a42841558" "68c708c20936d77039"
10EastSea
```

Reference: [One-time pad in Wikipedia](https://en.wikipedia.org/wiki/One-time_pad)

<br />

## 4. Hash Function

- `-md2 <message>` :  hash to message using MD2
```Bash
>> java -jar cryptools.jar -md2 "Message Digest"
ed59e3b00ef50f82cc80fe4023bbf98f
```

- `-md5 <message>` :  hash to message using MD5
```Bash
>> java -jar cryptools.jar -md5 "Message Digest"
bbd9d8cc4ad8ad2599dbf623e7e5282e
```

- `-sha1 <message>` :  hash to message using SHA-1
```Bash
>> java -jar cryptools.jar -sha1 "Secure Hash Algorithm"
d3517cbe39e304a3988dc773fa6f1e71f6ff965e
```

- `-sha256 <message>` :  hash to message using SHA-256
```Bash
>> java -jar cryptools.jar -sha256 "Secure Hash Algorithm"
42cf1ce9880d7f211c3d30d3bd376d20b26aaf6a929471108025c8e99b751c89
```

- `-sha384 <message>` :  hash to message using SHA-384
```Bash
>> java -jar cryptools.jar -sha384 "Secure Hash Algorithm"
33cbb9d78800bc3e6ee3fcb19103946c2fe12027c53cdeae4b1f8e7c1b0cdddf60acc323a3dd17d44eea1bf6bd14fff9
```

- `-sha512 <message>` :  hash to message using SHA-512
```Bash
>> java -jar cryptools.jar -sha512 "Secure Hash Algorithm"
f1ddc74427b792477be3939e2f3c1102edb297ba817b1427b86a68f459926488a7d51df4db609dcfd801671fc25230e9889cf0ba6ea00c88d8b184001589188c
```

<br />

## 5. Base64 Encode & Decode

- `-b64-e <message>` :  encode the message using Base64 Encode
```Bash
>> java -jar cryptools.jar -b64-e "Base64 Encode"
QmFzZTY0IEVuY29kZQ==
```

- `-b64-d <encoded message>` :  decode the encoded message using Base64 Decode
```Bash
>> java -jar cryptools.jar -b64-d "QmFzZTY0IERlY29kZQ=="
Base64 Decode
```
