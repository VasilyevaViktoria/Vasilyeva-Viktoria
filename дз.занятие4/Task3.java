package дз.занятие4;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int [] values1 = {1, 2, 3, 4, 5};
        System.out.println("Первый массив: " + Arrays.toString(values1));

        int [] values2 = {5, 6, 7};
        System.out.println("Второй массив: " + Arrays.toString(values2));
//        int z = 2 * values2.length;
//        System.out.println(z);

        int [] values3 = new int [8];

        getConcatenation(values1, values2, values3);
    }

    public static void getConcatenation(int[] values1, int[] values2, int[] values3) {
        int z = 2 * values2.length;
        for (int i = 0; i < values3.length; i++) {
           if(i % 2 == 0){
               for (int j = i; j < values3.length; j++) {
                   if(i == 0){
                       values3[i] = values1[j];
                       break;
                   }
                   values3[i] = values1[j/2];
                   break;
               }
           }
           else{
               for (int k = i; k < values3.length; k++) {
                       if(i == 1){
                       values3[i] = values2[k-1];
                       break;
                   }
                   else if(k >= z && k < values3.length){
                           for (int f = k+1; f <= values3.length; f++){
                               values3[i] = values1[f / 2];
                               break;
                           }
                   }
                   else {
                           values3[i] = values2[k / 2];
                           break;
                       }
               }
           }
        }
        System.out.println();
        System.out.println("Третий массив: " + Arrays.toString(values3));
    }
}
