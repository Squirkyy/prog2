public class Hund extends Haustier {
    double height;

    public Hund(String name, double height) {
        super(name);
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Der Hund heißt ");
        sb.append(this.name);
        sb.append(" und ist ");
        sb.append(this.height);
        sb.append(" groß.");
        return sb.toString();
    }
}
