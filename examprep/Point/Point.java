
public class Point {
    int x;
    int y;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int manhattanDistanceFromZero() {
        return (Math.abs(0 - this.x) + Math.abs(0 - this.y));
    }

    boolean isMoreEastMoreNorth(Point o) {
        if (this.getX() > o.getX()) {
            return true;
        } else if (this.getX() == o.getX() && this.getY() > this.getY()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(this.x);
        sb.append(",");
        sb.append(this.y);
        sb.append(")");
        return sb.toString();
    }

}