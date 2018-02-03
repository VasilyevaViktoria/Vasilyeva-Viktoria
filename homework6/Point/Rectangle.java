package homework6.Point;

public class Rectangle {

    private Point leftUp;
    private Point rightDown;

    public Rectangle(Point leftUp, Point rightDown) {
        this.leftUp = leftUp;
        this.rightDown = rightDown;
    }

    public double diagonalOfRectangle() {
        return rightDown.distanceBetweenPoints(leftUp);
    }

    public void print() {
        System.out.println("Диагональ равна: " + diagonalOfRectangle());
    }

    public double squareOfRectangle() {
        return Math.abs((leftUp.getY() - rightDown.getY()) * (leftUp.getX() - rightDown.getX()));
    }
}
