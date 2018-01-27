package дз.занятие4;

import java.util.Arrays;

public class Task3_1 {

    public static void main(String[] args) {
        int[] values1 = {1, 2, 3, 4, 5};
        System.out.println("Первый массив: " + Arrays.toString(values1));

        int[] values2 = {5, 6, 7};
        System.out.println("Второй массив: " + Arrays.toString(values2));

        int [] values3 = getConcatenation(values1, values2);
        System.out.println("Объединенный массив: " + Arrays.toString(values3));
    }

    public static int[] longerArray(int[] values1, int[] values2) {
        if (values2.length > values1.length) {
            return values2;
        } else {
            return values1;
        }
    }

    public static int[] shorterArray(int[] values1, int[] values2) {
        if (values2.length < values1.length) {
            return values2;
        } else {
            return values1;
        }
    }

    public static int[] getConcatenation(int[] values1, int[] values2) {
        int[] values3 = new int[values1.length + values2.length];
        int diffrent = Math.abs(values1.length - values2.length);

        for (int i = 0; i < 2 * shorterArray(values1, values2).length; i = i + 2) {
            values3[i] = values1[i / 2];
            values3[i + 1] = values2[i / 2];
        }

        for (int j = 0; j < diffrent; j++) {
            values3[2 * shorterArray(values1, values2).length+j] =
                    longerArray(values1, values2)[shorterArray(values1, values2).length+j];
        }
        return values3;
    }
}
