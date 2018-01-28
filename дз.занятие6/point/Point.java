package дз.занятие6.point;

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
        int dx = this.x - pointSecond.getX();
        int dy = this.y - pointSecond.getY();
        return Math.sqrt(Math.abs(dx * dx - dy * dy));
    }
}
