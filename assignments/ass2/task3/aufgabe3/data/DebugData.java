package aufgabe3.data;

import java.lang.Math;

// This class is representing a cartesian coordinate in a 2d space with double coordinates.
public class DebugData {
    private double x;
    private double y;

    public DebugData(double x, double y) { // must be double not int
        this.x = x;
        this.y = y;
    }

    public double distance(DebugData other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2)); // Math.pow -> Math.sqrt(...,
                                                                                         // 2) cause Phytagoras
    }

    public double getX() {
        return this.x;
    }

    public double getY() { // this.x -> this.y
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String str() {
        return String.format("(%f, %f)", this.x, this.y); // Muss f sein statt g weil man sonst nicht auf die sozial
                                                          // konstruierten 6 Fehler kommt
    }
}