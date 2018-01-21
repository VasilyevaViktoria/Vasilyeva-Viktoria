package дз.занятие3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int Number = scanner.nextInt();

        getSumDigits(Number);
    }

    public static void getSumDigits(int number) {
        int sum=0;
        while(number!=0){
            int digits=number%10;
            number=number/10;
            sum+=digits;
        }
        System.out.println(sum);
    }
}
