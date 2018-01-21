package дз.занятие2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите день: ");
        int day = scanner.nextInt();

        System.out.print("Введите месяц: ");
        int month = scanner.nextInt();

        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        boolean trueYM = isTrueYM(month, year);

        int countDay = 0;
        int trueDay = isTrueDay(countDay, month, year);

//        System.out.println(trueDay);
//        System.out.println(trueYM);

        getFormattingData(day, trueYM, trueDay, month, year);

        getNextDay(day, month, year, trueDay, trueYM);
    }

    private static void getFormattingData(int day, boolean k, int d, int month, int year) {
        if (k == true && day <= d) {
            System.out.println(day + ". " + month + ". " + year);
        } else {
            System.out.println("Ошибка");
        }

    }

    private static int isTrueDay(int countDay, int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                countDay = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                countDay = 30;
                break;
            case 2:
                if (((year % 4 == 0) &&
                        !(year % 100 == 0))
                        || (year % 400 == 0))
                    countDay = 29;
                else
                    countDay = 28;
            default:
                System.out.println("Несуществующий месяц");
                break;
        }

        return countDay;
    }

    private static boolean isTrueYM(int month, int year) {
        return (year > 1918 && (month >= 1 && month <= 12));
    }

    private static void getNextDay(int day, int month, int year, int d, boolean k) {
        if (k == true && day <= d) {
            if (month == 12 && day == 31) System.out.println("1. 1. " + year + 1);
            else if (day == d && month != 12)
                System.out.println((day + 1) + ". " + (month + 1) + ". " + year);
            else
                System.out.println((day + 1) + ". " + month + ". " + year);
        }
    }
}
