package homework6;

import homework6.Point.Point;
import homework6.Point.Rectangle;

public class PointDemo {

    public static void main(String[] args) {
        Point pointFirst = new Point(1, 0);
        Point pointSecond = new Point(3, 0);
        Point pointThird = new Point(0, 6);
        Point pointFourth = new Point(3, 2);

        Rectangle newRectangle = new Rectangle(pointThird, pointFourth);

        double distance = pointFirst.distanceBetweenPoints(pointSecond);
        System.out.println("Расстояние между двумя точками: " + distance);

        newRectangle.print();

        double square = newRectangle.squareOfRectangle();
        System.out.println("Площадь прямоугольника равна: " + square);
    }
}
