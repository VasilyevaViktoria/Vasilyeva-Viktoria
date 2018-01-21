package дз.занятие2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите a: ");
        int a = scanner.nextInt();

        System.out.print("Введите b: ");
        int b = scanner.nextInt();

        System.out.print("Введите b: ");
        int c = scanner.nextInt();

        double discriminant = getDiscriminant(a, b, c);
        System.out.println("Дискриминант = " + discriminant);

        boolean discrPositive = isPositive(discriminant);
        boolean discrZero = isZero(discriminant);
        findRoots(a, b, discrPositive, discrZero, discriminant);

    }

    public static void findRoots(int a, int b, boolean discrPositive, boolean discrZero, double discriminant) {
        double x1=0;
        double x2=0;
        if(discrPositive){
            x1=(-b+Math.sqrt(discriminant))/(2*a);
            x2=(-b-Math.sqrt(discriminant))/(2*a);
            System.out.printf("Корни уравнения: %s, %s", x1, x2);
        }
        else if(discrZero){
            x1 = (-b)/(2*a);
            System.out.printf("Корни уравнения: %s", x1);
        }
        else{
            System.out.println("Ошибка");
        }
    }

    public static boolean isZero(double discriminant) {
        return discriminant== 0 ? true: false;
    }

    public static boolean isPositive(double discriminant) {
        return discriminant > 0 ? true: false;
    }

    public static double getDiscriminant(int a, int b, int c) {
        double discr = Math.pow(b, 2) - 4*a*c;
        return discr;
//        if (discr >= 0)
//        return discr;
//        else
//            System.out.println("Ошибка");
    }
}
