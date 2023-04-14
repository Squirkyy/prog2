public class Encryption {
    public static void main(String[] args) {
        testFunction();
    }

    private static void testFunction() {
        char[] test = { 'H', 'E', 'L', 'L', 'O', ' ', 'W', 'O', 'R', 'L', 'D' };
        char[] test2 = { 'P', 'R', 'O', 'G', ' ', 'I', 'I' };
        int[] keys = generateKeys(test.length, 256);
        printCharArray(test);
        int[] encrypt = encrypt(test, keys);
        for (int i : encrypt) {
            System.out.print(i + " ");
        }
        System.out.println("");
        char[] decrypt = decrypt(encrypt, keys);
        printCharArray(decrypt);
        System.out.println("");

        int[] keys2 = generateKeys(test2.length, 256);
        printCharArray(test2);
        int[] encrypt2 = encrypt(test2, keys2);
        for (int i : encrypt2) {
            System.out.print(i + " ");
        }
        System.out.println("");
        char[] decrypt2 = decrypt(encrypt2, keys2);
        printCharArray(decrypt2);
    }

    public static int nextInt(int a, int b, int m, int x) {
        return (a * x + b) % m;
    }

    public static int[] generateKeys(int size, int start) {
        int[] keys = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                keys[i] = nextInt(3, 7, 28, start);
            } else {
                keys[i] = nextInt(3, 7, 28, keys[i - 1]);
            }
        }
        return keys;
    }

    public static void printCharArray(char[] letter) {
        for (char c : letter) {
            System.out.print(c);
        }
        System.out.println("");
    }

    public static int[] encrypt(char[] letters, int[] keys) {
        int[] encryptArr = new int[letters.length];
        for (int i = 0; i < letters.length; i++) {
            encryptArr[i] = (((int) letters[i]) ^ keys[i]);
        }
        return encryptArr;
    }

    public static char[] decrypt(int[] letters, int[] keys) {
        char[] encryptArr = new char[letters.length];
        for (int i = 0; i < letters.length; i++) {
            encryptArr[i] = (char) (letters[i] ^ keys[i]);
        }
        return encryptArr;
    }
}