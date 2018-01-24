package дз.занятие4;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Random random = new Random();

        int n = 4;
        int m = 5;
        int [] [] arrayDimension2 = new int [n][m];
        System.out.println("Двумерный массив: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrayDimension2[i][j] = random.nextInt(100) + 1;
                System.out.print(arrayDimension2[i][j] + " ");
            }
            System.out.println();
        }


        int [] arrayDimension1 = new int[n*m];

        linearize(arrayDimension2, arrayDimension1);
    }

    public static void linearize(int[][] arrayDimension2, int[] arrayDimension1) {
        int k =0;
        for(int i = 0; i < arrayDimension2.length; i++){
            for (int j = 0; j < arrayDimension2[i].length; j++) {
                    arrayDimension1[k++] = arrayDimension2[i][j];
            }
        }
        System.out.println();
        System.out.println("Одномерный массив: ");
        System.out.println(Arrays.toString(arrayDimension1));
    }
}
