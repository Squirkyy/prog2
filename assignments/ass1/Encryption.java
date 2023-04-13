public class Encryption {
    public static void main (String[] args) {
        System.out.println("der nächste int lautet: " + nextInt(3, 7, 28, 256));
        
        char test[] = {'H', 'A', 'L', 'L', 'O'};
        printCharArray(test);
    }
    public static int nextInt(int a, int b, int m, int x) {
        return (a * x + b) % m;
    }

    public static void printCharArray (char[] letter) {
        for (char c : letter) {
            System.out.print(c);
        }
        System.out.println("");
    }

    public static int[] encrypt(char[] letters, int[] keys) {
        
    }

}