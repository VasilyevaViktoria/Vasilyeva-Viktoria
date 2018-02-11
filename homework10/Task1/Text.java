package homework10.Task1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Text {

    public static Map<String, Integer> frequencyOfOccurrence(String str) {
        List<String> words = Arrays.asList(str.split(" "));
        Map<String, Integer> listOfFrequency = new HashMap<>();

        for (String word : words) {
            listOfFrequency.put(word, listOfFrequency.containsKey(word) ? listOfFrequency.get(word) + 1: 1);
        }

        return listOfFrequency;
    }
}
