# Cryptools

1. Binary, Hexadecimal, String Converter
2. XOR Calculator
3. One-Time Pad
4. Hash (Preparing ..)

> This program provides various calculations used for crypto.

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
