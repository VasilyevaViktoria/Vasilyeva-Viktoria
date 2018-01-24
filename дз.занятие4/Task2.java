package дз.занятие4;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int [] values = {3, 5, 9, 3, 8, 17, 45, 3, 17, 48, 0, 17};
//        for (int i = 0; i < values.length; i++) {
//            int value = values[i];
//           System.out.print(value + " ");
//        }
        System.out.println("Исходный массив: " + Arrays.toString(values));

        deleteRepeats(values);
    }

    public static void deleteRepeats(int[] values) {
        for (int i = 0; i < values.length; i++) {
            int start = values[i];
            for (int j = i+1; j < values.length; j++) {
                if(start==values[j]){
                    values[j]=0;
                }
            }
        }
        System.out.println(" ");
        System.out.println("Полученный массив: " + Arrays.toString(values));
    }
}
