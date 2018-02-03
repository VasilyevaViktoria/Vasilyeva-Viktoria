package homework7temp2.Figure;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distanceBetweenPoints(Point pointSecond) {
        int dx = Math.abs(this.getX() - pointSecond.getX());
        int dy = Math.abs(this.getY() - pointSecond.getY());
        return Math.sqrt(dx * dx + dy * dy);
    }
}
