//задание с классной работы, которое мы пропустили
package дз.занятие5;

import java.util.Arrays;

public class Task7FromClassWork {

    public static void main(String[] args) {

        String str = "dfghjkllkjn fghjklk fghjklkj dfgjkj fg fgkjhg fghj ";
        System.out.println("Исходная строка: " + str);

        int length = str.length();
//        System.out.println("Длина строки: " + length);

        int number = numberOfParts(str);
//        System.out.println("Количество символов в каждой части: " + number);

//        divideString(str, number);
        divideStringMassiv(str, number);
    }

    public static void divideStringMassiv(String str, int number) {

        int startNumber = number;
        String[] result = new String[str.length()];

        System.out.print("Полученная строка: ");
        for (int i = 0; i < str.length(); i = i + number, number = number *2) {
            result[i] = str.substring(i, number);
            System.out.print(result[i]);

            if(number != str.length() - startNumber){
                System.out.print(", ");
            }

        }
    }

//    public static void divideString(String str, int number) {
//
//        int startNumber = number;
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < str.length(); i = i + number, number = number *2) {
//            result.append(str.substring(i, number));
//            if(number != str.length() - startNumber){
//                result.append(", ");
//            }
//        }
//        System.out.println();
//        System.out.println("Полученная строка: " + result.toString());
//    }

    private static int numberOfParts(String str) {

        int i;

        for (i = 2; i < 6; i++) {
            if (str.length() % i == 0) {
//                int a = i;
//                System.out.println(i);
                break;
            }
        }
        return i;
    }
}
