package дз.занятие5;

public class Task2_1 {

    public static void main(String[] args) {
        String[] romeFormat = {"M", "D", "C", "L", "X", "V", "I"};
        int[] arabFormat = {1000, 500, 100, 50, 10, 5, 1};

        String numberInRomeFormat = "MMMCXLIV";

        convertFromRomeToArab(romeFormat, arabFormat, numberInRomeFormat);
        System.out.println(convertFromRomeToArab(romeFormat, arabFormat, numberInRomeFormat));
    }

    public static int convertFromRomeToArab(String[] romeFormat, int[] arabFormat, String numberInRomeFormat) {
        int numberInArabFormat = 0;
        int currentElementArabFormat = 0, nextElementArabFormat = 0;
        String currentElement = "";
        String nextElement = "";
        StringBuffer romeNumber = new StringBuffer(numberInRomeFormat);

        for (int j = 0; j < romeNumber.length(); j++) {
            currentElement = romeNumber.substring(j, j + 1);

            if (j < romeNumber.length() - 1) {
                nextElement = romeNumber.substring(j + 1, j + 2);
            }

            for (int i = 0; i < romeFormat.length; i++) {
                if (romeFormat[i].equals(currentElement)) {
                    currentElementArabFormat = arabFormat[i];
                }
                if (romeFormat[i].equals(nextElement)) {
                    nextElementArabFormat = arabFormat[i];
                }
            }
            if (currentElementArabFormat < nextElementArabFormat) {
                numberInArabFormat = numberInArabFormat + (nextElementArabFormat - currentElementArabFormat);
//                    romeNumber.delete(0, 1);
                j++;
            } else {
                numberInArabFormat = numberInArabFormat + currentElementArabFormat;
            }
        }
        return numberInArabFormat;
    }
}
