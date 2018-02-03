package homework7temp2.Figure;

public class Triangle extends Figure {

    private Point pointFirst;
    private Point pointSecond;
    private Point pointThird;

    private double a;
    private double b;
    private double c;

    public Triangle(String name, Point pointFirst, Point pointSecond, Point pointThird) {
        super(name);
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
        this.pointThird = pointThird;
        this.a = pointFirst.distanceBetweenPoints(pointSecond);
        this.b = pointSecond.distanceBetweenPoints(pointThird);
        this.c = pointThird.distanceBetweenPoints(pointFirst);
    }

    @Override
    public double areaOfFigure() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public TypeOfTriangle typeOfTriangle() {
        if (a == 0 || b == 0 || c == 0) {
            return TypeOfTriangle.NOTEXIST;
        } else if ((Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2) || Math.pow(b, 2) == Math.pow(a, 2) +
                Math.pow(c, 2) || Math.pow(c, 2) == Math.pow(b, 2) + Math.pow(a, 2))) {
            return TypeOfTriangle.RECTANGULAR;
        } else if (Math.pow(a, 2) > Math.pow(b, 2) + Math.pow(c, 2) || Math.pow(b, 2) > Math.pow(a, 2) + Math.pow(c, 2)
                || Math.pow(c, 2) > Math.pow(b, 2) + Math.pow(a, 2)) {
            return TypeOfTriangle.OBTUSE;
        } else if (Math.pow(a, 2) < Math.pow(b, 2) + Math.pow(c, 2) || Math.pow(b, 2) < Math.pow(a, 2) + Math.pow(c, 2)
                || Math.pow(c, 2) < Math.pow(b, 2) + Math.pow(a, 2)) {
            return TypeOfTriangle.ACUTEANGLED;
        }
        return TypeOfTriangle.NOTEXIST;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
