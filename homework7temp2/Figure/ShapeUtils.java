package homework7temp2.Figure;

public class ShapeUtils {
    public static boolean isRectangle(Rectangle rectangle) {

        double diagonal = rectangle.getLeftDown().distanceBetweenPoints(rectangle.getRightUp());
        double a = rectangle.getLeftDown().distanceBetweenPoints(rectangle.getLeftUp());
        double b = rectangle.getLeftUp().distanceBetweenPoints(rectangle.getRightUp());
        return Math.pow(diagonal, 2) == Math.pow(a, 2) + Math.pow(b, 2) && rectangle.areaOfFigure() != 0;
    }

    public static boolean isTriangle(Triangle triangle) {
        return (triangle.getA() + triangle.getB()) > triangle.getC() &&
                (triangle.getB() + triangle.getC()) > triangle.getA() &&
                triangle.getC() + triangle.getA() > triangle.getB();
    }

    public static TypeOfRectangle typeRectangle(Point firstPoint, Point secondPoint, double areaOfRectangle) {
        if (areaOfRectangle != 0) {
            if (firstPoint.getX() - secondPoint.getX() == firstPoint.getY() - secondPoint.getY()) {
                return TypeOfRectangle.SQUARE;
            }
            return TypeOfRectangle.RECTANGLE;
        }
        return TypeOfRectangle.NOTQUADRANGLE;
    }
}

