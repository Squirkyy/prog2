public class Encryption {
    public static void main(String[] args) {
        char[] test = { 'H', 'A', 'L', 'L', 'O' };
        int[] keys = generateKeys(5, 256);
        printCharArray(test);
        int[] encrypt = encrypt(test, keys);
        for (int i : encrypt) {
            System.out.print(i + " ");
        }
        System.out.println("");
        char[] decrypt = decrypt(encrypt, keys);
        printCharArray(decrypt);

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