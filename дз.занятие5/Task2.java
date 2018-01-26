package дз.занятие5;

public class Task2 {

    public static void main(String[] args) {

        String[] romeFormat = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] arabFormat = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        String numberInRomeFormat = "MMMCMXCIX";

        convertFromRomeToArab(romeFormat, arabFormat, numberInRomeFormat);
        System.out.println(convertFromRomeToArab(romeFormat, arabFormat, numberInRomeFormat));
    }

    public static int convertFromRomeToArab(String[] romeFormat, int[] arabFormat, String numberInRomeFormat) {

        int numberInArabFormat = 0;
        StringBuffer romeNumber = new StringBuffer(numberInRomeFormat);

            for (int j = 0, number = 2; j < romeNumber.length(); j++, number = j + 2) {
                for (int i = 0; i < romeFormat.length; i++) {

                String currentElement = romeNumber.substring(j, j+1);

                if(number<=romeNumber.length()) {
                    String k = romeNumber.substring(j, number);

                    if (romeFormat[i].equals(k)) {
                        numberInArabFormat = numberInArabFormat + arabFormat[i];
                        romeNumber.delete(0, 1);
                        break;
                    }

                    if (romeFormat[i].equals(currentElement)) {
                        numberInArabFormat = numberInArabFormat + arabFormat[i];
                        break;
                    }
                }
                else {
                    if (romeFormat[i].equals(currentElement)) {
                        numberInArabFormat = numberInArabFormat + arabFormat[i];
                        break;
                    }
                }
            }
        }
        return numberInArabFormat;
    }
}
