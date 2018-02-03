package homework7temp2.Figure;

public class Circle extends Figure {

    private Point pointFirst;
    private Point pointSecond;

    public Circle(String name, Point pointFirst, Point pointSecond) {
        super(name);
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
    }

    @Override
    public double areaOfFigure() {
        return Math.PI * Math.pow(pointFirst.distanceBetweenPoints(pointSecond), 2);
    }
}
