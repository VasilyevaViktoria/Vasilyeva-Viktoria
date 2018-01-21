package дз.занятие2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1-ый дом: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println("2-ой дом: ");
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        System.out.println("Участок: ");
        int e = scanner.nextInt();
        int f = scanner.nextInt();

        isPlaceTrue(a, b, c, d, e, f);

    }

    public static void isPlaceTrue(int a, int b, int c, int d, int e, int f) {
        if ((e >= (d + a)) && (f >= b && f >= c))
        {
            System.out.println("Дома помещаются на участке");
        }
        else if ((e >= (d + b))&& (f >= a && f >= c))
        {
            System.out.println("Дома помещаются на участке");
        }
        else if ((e >= (a + c))&& (f >= b && f >= d))
        {
            System.out.println("Дома помещаются на участке");
        }
        else if ((e >= (c + b))&& (f >= a && f >= d))
        {
            System.out.println("Дома помещаются на участке");
        }
        else
            System.out.println("Дома не помещаются на участке");
    }
}
