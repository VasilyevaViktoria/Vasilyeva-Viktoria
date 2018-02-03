package homework6.Point;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceBetweenPoints(Point pointSecond) {
        int dx = x - pointSecond.getX();
        int dy = y - pointSecond.getY();
        return Math.sqrt(Math.abs(dx * dx - dy * dy));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
