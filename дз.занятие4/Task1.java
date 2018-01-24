package дз.занятие4;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();

        int[] values = new int[10];
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(100) + 1;
        }
        System.out.println("Исходный массив: " + Arrays.toString(values));

        boolean digitalsNotRepeat = isDigitalsNotRepeat(values);
//        System.out.println(digitalsNotRepeat);
        shiftArray(values, digitalsNotRepeat);
    }

    public static boolean isDigitalsNotRepeat(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i+1; j < values.length; j++) {
                if(values[i]==values[j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void shiftArray(int[] values, boolean digitalsNotRepeat) {
        if(digitalsNotRepeat==true){
            for (int i = 0; i < values.length-1; i++) {
            int firstValue = values[0];
            for (int j = 0; j < values.length; j++) {
                if(values[j]==values[values.length-1]){
                    values[values.length-1]=firstValue;
                }
                else {
                    values[j] = values[j+1];
                }
            }
            System.out.println("Полученный массив: " + Arrays.toString(values));
            }
        }
        else{
            System.out.println("Сгенерируйте другой массив");
        }
    }
}
