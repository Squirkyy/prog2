import java.util.Scanner;

public class TextInput {
    /**
     * \
     * Reads the current line and returns it as a string
     */
    public static String readLine() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}