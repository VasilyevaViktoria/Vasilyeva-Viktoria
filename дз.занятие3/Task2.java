package дз.занятие3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите n: ");
        int Count = scanner.nextInt();

//        С помощью цикла
        int a1=1;
        int a2=1;
        System.out.print(a1 + " " + a2 + " ");
        while(a1<=Count) {
            int sum1 = a1 + a2;
            a1 = a2;
            a2 = sum1;
            System.out.print(sum1 + " ");
        }

//        С помощью рекурсии
//        Fibonachi(Count);
//        System.out.println(Fibonachi(Count));

    }

//    public static int Fibonachi(int Count) {
//        if (Count == 1) {
//            return 1;
//        } else if (Count == 2) {
//            return 1;
//        } else {
//            int k =  Fibonachi(Count - 1) + Fibonachi(Count - 2);
//            return k;
//        }
//    }
}
