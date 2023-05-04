package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HalfAdder ha = new HalfAdder();
        boolean[] test = ha.add(true, true);
        for (boolean test1 : test) {
            System.out.println(test1);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie den ersten boolean Wert an: ");
        String first = scanner.nextLine();
        System.out.print("Geben Sie den zweiten boolean Wert an: ");
        String second = scanner.next();
        boolean[] adderResult = ha.add((first.equals("false") ? false : true), (second.equals("false") ? false : true));
        int sum = adderResult[0] ? 1 : 0;
        int carry = adderResult[1] ? 1 : 0;
        scanner.close();
        System.out.println("Die Summe lautet: " + sum + ", der Übertrag beträgt: " + carry);
    }
}
