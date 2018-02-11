package homework10.Task1;

import java.util.Map;

public class TextPrint {

    public static void print(Map<String, Integer> listOfFrequency) {
        for (Map.Entry<String, Integer> entry : listOfFrequency.entrySet()) {
            System.out.printf("Слово '%s' в тексте встречается %s раз ", entry.getKey(), entry.getValue());
            System.out.println();
        }
    }
}
