package homework10.Task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Polinom {

    public static void sumOfPolinoms(Map<Integer, Integer> polinomFirst, Map<Integer, Integer> polinomSecond) {

        //-----------------------Определям какой полином имеет большую степень-------------
        Map<Integer, Integer> longerPolinom = polinomFirst.size() > polinomSecond.size() ? polinomFirst : polinomSecond;
        Map<Integer, Integer> shorterPolinom = polinomFirst.size() > polinomSecond.size() ? polinomSecond : polinomFirst;
        // ----------------------Сумма полиномов-------------------------------------------
        Map<Integer, Integer> sum = new HashMap<>();
        sum.put(0, polinomFirst.get(0) + polinomSecond.get(0));
        System.out.print(sum.get(0));
        for (int i = 1; i < longerPolinom.size(); i++) {
            sum.put(i, i < shorterPolinom.size() ? polinomFirst.get(i) + polinomSecond.get(i) : longerPolinom.get(i));
            System.out.print( " + " + sum.get(i) + "x^" + i);
        }
    }
}
