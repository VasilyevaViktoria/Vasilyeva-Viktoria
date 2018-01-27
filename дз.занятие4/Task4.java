package дз.занятие4;

import java.util.Arrays;
import java.util.Random;

public class Task4 {

    public static void main(String[] args) {
        int[][] arrayDimension2 = new int[3][];
        arrayDimension2[0] = new int[3];
        arrayDimension2[1] = new int[5];
        arrayDimension2[2] = new int[2];

        System.out.println("Двумерный массив: ");
        generateArray(arrayDimension2);
        for (int i = 0; i < arrayDimension2.length; i++) {
            for (int j = 0; j < arrayDimension2[i].length; j++) {
                System.out.print(arrayDimension2[i][j] + " ");
            }
            System.out.println();
        }

        int count = getElementCount(arrayDimension2);

        int [] arrayDimension1 = linearize(arrayDimension2, count);
        System.out.println();
        System.out.println("Одномерный массив: ");
        System.out.println(Arrays.toString(arrayDimension1));
    }

    public static int[][] generateArray(int[][] arrayDimension2) {
        Random random = new Random();

        for (int i = 0; i < arrayDimension2.length; i++) {
            for (int j = 0; j < arrayDimension2[i].length; j++) {
                arrayDimension2[i][j] = random.nextInt(100) + 1;
            }
        }
        return arrayDimension2;
    }

    public static int getElementCount(int[][] arrayDimension2) {
        int count = 0;

        for (int i = 0; i < arrayDimension2.length; i++) {
            for (int j = 0; j < arrayDimension2[i].length; j++) {
                count++;
            }
        }
        return count;
    }

    public static int[] linearize(int[][] arrayDimension2, int count) {
        int[] arrayDimension1 = new int[count];
        int k = 0;

        for (int i = 0; i < arrayDimension2.length; i++) {
            for (int j = 0; j < arrayDimension2[i].length; j++) {
                arrayDimension1[k++] = arrayDimension2[i][j];
            }
        }
        return arrayDimension1;

    }
}
