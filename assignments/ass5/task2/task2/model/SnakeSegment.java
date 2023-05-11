package task2.model;

public class SnakeSegment {
    int x, y;

    public SnakeSegment(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public SnakeSegment getMoved(Direction dir) {
        return new SnakeSegment(x + dir.getXDiff(), y + dir.getYDiff());
    }
}
