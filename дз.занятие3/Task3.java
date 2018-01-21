package дз.занятие3;

import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество дней: ");
        int N = scanner.nextInt();

        int sumRainfall=0;
        int maxValue=0;
        Random random=new Random();
        for(int i=0;i<N;i++)
        {
            int randomValues= random.nextInt(100)+1;
            System.out.print(randomValues + " ");
            sumRainfall+=randomValues;
            if(maxValue<randomValues){
                maxValue=randomValues;
            }
        }
        System.out.println(" ");
        System.out.printf("Сумма осадков за %s дней составляет %s.", N, sumRainfall);

        System.out.println(" ");
        double middleRainfall=sumRainfall/N;
        System.out.printf("Среднее количество осадков за %s дней составляет %s.", N, middleRainfall);

        System.out.println(" ");
        System.out.println("Максимальное количество осадков составляет " + maxValue);
    }
}
