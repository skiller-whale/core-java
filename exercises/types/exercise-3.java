// ========================================== //
// HAIL CAESAR                                //
// ========================================== //
/*
 * The code below should print encrypted and decrypted strings.
 *
 * However, the 'Caesar.encrypt' and 'Caesar.decrypt' methods do not work.
 * Fix them according to the instructions.
 *
 * You can use 'variable.toCharArray()' to convert a String variable to an array of characters.
 *
 */

 class Cipher {
    public static void main(String[] args) {
        String m1 = "clamazon prime";
        String m2 = "wzkia izm ug nidwczqbm iycibqk axmkqma";
        System.out.println("Encrypted message: " + Caesar.encrypt(m1));
        System.out.println("Decrypted message: " + Caesar.decrypt(m2));
    }
}

 class Caesar {
    static int shift = 8;

    static String encrypt(String message) {
        // 1. Create an array of characters called 'chars' out of the message String
        // 2. Create a new String called 'encrypted'; this will be returned by the method
        for (char c : chars) {
            char encryptedChar = Alphabet.up(c);
            // 3. Append encryptedChar to the 'encrypted' String
            }
        return encrypted;
    }

    static String decrypt(String message) {
        // 1. Create an array of characters called 'chars' out of the message String
        // 2. Create a new String called 'decrypted'; this will be returned by the method
        for (char c : chars) {
            char decryptedChar = Alphabet.down(c);
            // 3. Append decryptedChar to the 'decrypted' String
            }
        return decrypted;
    }
}



// Ignore the code here
class Alphabet {
    static char up(char c) {
        if (c == ' ') {
            return c;
        } else {
            return (char)((((c - 97) + (Caesar.shift)) % 26) + 97);
        }
    }
    static char down(char c) {
        if (c == ' ') {
            return c;
        } else {
            return (char)((((c - 97) + (26 - Caesar.shift)) % 26) + 97);
        }
    }
}
