package homework7temp2;

import homework7temp2.Figure.*;

import java.util.Scanner;

public class FigureDemo {

    public static void main(String[] args) {
        Point firstPoint = new Point(1, 1);
        Point secondPoint = new Point(2, 4);
        Point thirdPoint = new Point(3, -2);

        Figure circle = new Circle("окружность", firstPoint, secondPoint);
        Figure circleNew = new Circle("окружность", firstPoint, thirdPoint);
        double areaOfCircle = circle.areaOfFigure();
        System.out.println("Площадь " + circle.getName() + " равна: " + areaOfCircle);

        Rectangle rectangle = new Rectangle("прямоугольник", firstPoint, secondPoint);
        double areaOfRectangle = rectangle.areaOfFigure();
        System.out.println("Площадь " + rectangle.getName() + " равна: " + areaOfRectangle);

        Triangle triangle = new Triangle("треугольник", firstPoint, secondPoint, thirdPoint);
        double areaOfTriangle = triangle.areaOfFigure();
        if (triangle.typeOfTriangle() != TypeOfTriangle.NOTEXIST) {
            System.out.println("Площадь " + triangle.getName() +
                    " равна: " + areaOfTriangle);
            System.out.println("Тип треугольника: " + triangle.typeOfTriangle().getDescription());
        } else {
            System.out.println("Ошибка. Такого треугольника не существует.");
        }

        System.out.println("");
        System.out.println("Равны ли площади окружностей: " + circle.isAreasEquals(circleNew));
        System.out.println("Равны ли площади окружности и треугольника: " + circle.isAreasEquals(triangle));

        System.out.println("");
        System.out.println(ShapeUtils.typeRectangle(firstPoint, secondPoint, areaOfRectangle).getDescription());

        if (ShapeUtils.isRectangle((Rectangle) rectangle)) {
            System.out.println("Данная фигура - прямоугольник");
        } else {
            System.out.println("Данная фигура - не прямоугольник");
        }

        if (ShapeUtils.isTriangle(triangle)) {
            System.out.println("Такой треугольник существует");
        } else {
            System.out.println("Такого треугольника не существует");
        }

        System.out.println("");
        System.out.println("Координаты прямоугольника до сдвига: " + rectangle.toString());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение, на которое хотите сдвинуть фигуру по координате X: ");
        int x = scanner.nextInt();
        rectangle.shiftCoordinate(x);
        System.out.println("Координаты прямоугольника после сдвига: " + rectangle.toString());
    }
}
