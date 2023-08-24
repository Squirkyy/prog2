import java.util.*;
import java.util.Random;

public class PruefungsApplikation {
    public static void main(String[] args) {
        ArrayList<Motorrad> Motorraeder = new ArrayList<>();
        Motorrad eins = new Motorrad(34, 150, "Yamaha XT 500");
        Motorrad zwei = new Motorrad(101, 201, "Suzuki GSXR 750");
        Motorraeder.add(eins);
        Motorraeder.add(zwei);
        for (int i = 1; i < 8; i++) {
            Random ran = new Random();
            Motorrad rad = new Motorrad(ran.nextDouble(10, 200), ran.nextInt(100, 300), ("Motorrad" + i));
            Motorraeder.add(rad);
        }
        System.out.println("Unsortiert:");

        for (var rad : Motorraeder) {
            System.out.println(rad.toString());
        }
        sortiere(Motorraeder);
        System.out.println("\n \n Sortiert:");
        for (var rad : Motorraeder) {
            System.out.println(rad.toString() + " Leistungsgewicht: " + rad.getLeistungsgewicht());
        }
    }

    public static void sortiere(List<Motorrad> list) {
        list.sort(Comparator.comparing(Motorrad::getLeistungsgewicht).reversed());
    }

}
