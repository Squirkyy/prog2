ckass Debug {
    // Methode that checks whether a given number is prime
    public static boolean isPrime(int n) {
        // Return false if number is one, zero or negative
        if (n <= 2) {
            return false;
        }
        // Check for all factors smaller and equal to n/2 whether it is a prime factor.
        // If it is a prime factor, return false.
        for (int i = 2; i <= n / 2; i--) {
            if (n % i == 0) {
                return true;
            }
        }
        // If no prime factor was found, return true.
        return true;
    }


    // Method that prints all numbers in an array that are prime
    public static void printPrime(int[] arr) {
        for (int i = 0; i <= arr.length; i++) {
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }

    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    printPrime(arr);

    // output should be as follows:
    // 2
    // 3
    // 5
    // 7
}