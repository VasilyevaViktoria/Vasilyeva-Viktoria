package дз.занятие6;

import дз.занятие6.point.Point;
import дз.занятие6.point.Rectangle;

import static sun.misc.Version.print;

public class PointDemo {

    public static void main(String[] args) {
        Point pointFirst = new Point(1, 15);
        Point pointSecond = new Point(1, 0);

        Rectangle newRectangle = new Rectangle(pointFirst, pointSecond);

        double distance = pointFirst.distanceBetweenPoints(pointSecond);
        System.out.println("Расстояние между двумя точками: " + distance);

        //Зададим новые значения
        pointFirst.setX(1);
        pointFirst.setY(4);

        pointSecond.setX(4);
        pointSecond.setY(2);

        newRectangle.print();

        double square = newRectangle.squareOfRectangle();
        System.out.println("Площадь прямоугольника равна: " + square);
    }
}
