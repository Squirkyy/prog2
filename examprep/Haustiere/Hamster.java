public class Hamster extends Haustier {
    double speed;

    public Hamster(String name, double speed) {
        super(name);
        this.speed = speed;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Der Hamster heißt ");
        sb.append(this.name);
        sb.append(" und hat eine Geschwindigkeit von ");
        sb.append(this.speed);
        sb.append(" km/h.");
        return sb.toString();
    }
}
