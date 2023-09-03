import java.util.*;
import java.util.Random;

public class PruefungsApplikation {
    public static void main(String[] args) {
        LinkedList<Point> points = new LinkedList<>();
        Random ran = new Random();
        for (int i = 0; i < 25; i++) {
            points.add(new Point(ran.nextInt(-10, 10), ran.nextInt(-10, 10)));
        }
        LinkedList<Point> list = points;
        Collections.reverse(list);
        System.out.println("List before getting sorted: ");
        for (Point i : points) {
            System.out.println(i.toString() + " Distance: " + i.manhattanDistanceFromZero());
        }
        sortiere(points);
        System.out.println("List after getting sorted: ");
        for (Point i : points) {
            System.out.println(i.toString() + " " + i.manhattanDistanceFromZero());
        }
    }

    public static void sortiere(List<Point> list) {
        list.sort(Comparator.comparing(Point::manhattanDistanceFromZero));
    }
}
