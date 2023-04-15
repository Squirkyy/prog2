class Debug {
    // Methode that checks whether a given number is prime
    public static boolean isPrime(int n) {
        // Return false if number is one, zero or negative
        if (n < 2) {
            return false;
        }
        // Check for all factors smaller and equal to n/2 whether it is a prime factor.
        // If it is a prime factor, return false.
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        // If no prime factor was found, return true.
        return true;
    }

    // Method that prints all numbers in an array that are prime
    public static void printPrime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        printPrime(arr);
    }

    // output should be as follows:
    // 2
    // 3
    // 5
    // 7
}

/*
 * Error 1: Class falsch geschrieben
 * Debug.java:1: error: class, interface, enum, or record expected
 * 
 * Error 2: main function missing
 * Debug.java:30: error: invalid method declaration; return type required
 * Debug.java:30: error: <identifier> expected
 * printPrime(arr);
 * 
 * Error 3: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
 * Index 10 out of bounds for length 10
 * Zurückzuführen zu Zeile 21, die Stop Condition sollte i < arr.length sein
 * 
 * Error 4: Falsche Logik in Zeile 5
 * n < 2 nicht n <= 2
 * 
 * Error 5: wrong for loop incrementation Zeile 10
 * i++ statt i--
 * 
 * Error 6: wrong return Boolean
 * return false statt true in Zeile 12
 */
