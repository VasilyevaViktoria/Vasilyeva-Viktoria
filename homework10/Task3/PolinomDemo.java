package homework10.Task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static homework10.Task3.Polinom.sumOfPolinoms;

public class PolinomDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ----------------------Первый полином------------------------------
        Map<Integer, Integer> polinomFirst = new HashMap<>();
        System.out.print("Maximum degree of the first polynomial: ");
        int maxDegreeOfPolinomFirst = scanner.nextInt();

        for (int j = 0; j < maxDegreeOfPolinomFirst; j++) {
            System.out.print("a" + j + " = ");
            polinomFirst.put(j, scanner.nextInt());
        }
        System.out.print("PolinomFirst" + " = " + polinomFirst.get(0));
        for (int j = 1; j < maxDegreeOfPolinomFirst; j++) {
            System.out.print(" + " + polinomFirst.get(j) + "x^" + j);
        }
        System.out.println();
        // ----------------------Второй полином------------------------------
        Map<Integer, Integer> polinomSecond = new HashMap<>();
        System.out.print("Maximum degree of the second polynomial: ");
        int maxDegreeOfPolinomSecond = scanner.nextInt();

        for (int j = 0; j < maxDegreeOfPolinomSecond; j++) {
            System.out.print("a" + j + " = ");
            polinomSecond.put(j, scanner.nextInt());
        }
        System.out.print("PolinomSecond" + " = " + polinomSecond.get(0));
        for (int j = 1; j < maxDegreeOfPolinomSecond; j++) {
            System.out.print(" + " + polinomSecond.get(j) + "x^" + j);
        }
        System.out.println();

        System.out.print("Sum of polinoms = ");
        sumOfPolinoms(polinomFirst, polinomSecond);
    }


}
