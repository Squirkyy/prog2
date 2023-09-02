import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Applikation {

    public static void main(String[] args) {
        LinkedList<Haustier> haustiere = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.println("Geben Sie ein Haustier ein");
            input = sc.nextLine();
            if (input.toLowerCase().equals("sort")) {
                break;
            }
            String[] haustier = input.split(" ");
            switch (haustier[0].toLowerCase()) {
                case "hamster":
                    haustiere.add(new Hamster(haustier[1], Double.parseDouble(haustier[2])));
                    break;

                case "hund": {
                    haustiere.add(new Hund(haustier[1], Double.parseDouble(haustier[2])));
                    break;
                }
            }

        }
        LinkedList<Hamster> hamsters = new LinkedList<>();
        LinkedList<Hund> hunde = new LinkedList<>();
        for (Haustier h : haustiere) {
            if (h instanceof Hund) {
                hunde.add((Hund) h);
            } else {
                hamsters.add((Hamster) h);
            }
        }
        hamsters.sort(Comparator.comparing(Hamster::getName));
        hunde.sort(Comparator.comparing(Hund::getName));
        System.out.println("Hunde:");
        for (Hund h : hunde) {
            System.out.println(h.toString());
        }
        System.out.println("Hamster:");
        for (Hamster h : hamsters) {
            System.out.println(h.toString());
        }
    }
}
