package homework7temp2.Figure;

public class Rectangle extends Figure implements ShiftFigure {

    private Point leftUp;
    private Point rightDown;
    private Point leftDown;
    private Point rightUp;

    public Rectangle(String name, Point leftUp, Point rightDown) {
        super(name);
        this.leftUp = leftUp;
        this.rightDown = rightDown;
        this.leftDown = new Point(leftUp.getX(), rightDown.getY());
        this.rightUp = new Point(rightDown.getX(), leftUp.getY());
    }

    public Rectangle(String name, Point leftUp, Point rightDown, Point leftDown, Point rightUp) {
        super(name);
        this.leftUp = leftUp;
        this.rightDown = rightDown;
        this.leftDown = leftDown;
        this.rightUp = rightUp;
    }

    @Override
    public double areaOfFigure() {
        return Math.abs((leftUp.getY() - rightDown.getY()) * (leftUp.getX() - rightDown.getX()));
    }

    @Override
    public void shiftCoordinate(int x) {
        Point[] arr = {leftDown, leftUp, rightUp, rightDown};

        for (int i = 0; i < arr.length; i++) {
            int newX = arr[i].getX() + x;
            arr[i].setX(newX);
        }
    }

    @Override
    public String toString() {
        return "point1 (" + leftDown.getX() + ", " + leftDown.getY() + ") " +
                ", point2 (" + leftUp.getX() + ", " + leftUp.getY() + ") " +
                ", point3 (" + rightUp.getX() + ", " + rightUp.getY() + ") " +
                ", point4 (" + rightDown.getX() + ", " + rightDown.getY() + ")";
    }

    public Point getLeftUp() {
        return leftUp;
    }

    public Point getRightDown() {
        return rightDown;
    }

    public Point getLeftDown() {
        return leftDown;
    }

    public Point getRightUp() {
        return rightUp;
    }
}
