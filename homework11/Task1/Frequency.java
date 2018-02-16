package homework11.Task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public final class Frequency {

    private Frequency() {
    }

    public static Map<Character, Integer> countOfRepeat(File file) throws IOException {
        Map<Character, Integer> listOfFrequency = new HashMap<>();
        int element;

        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                while ((element = bufferedReader.read()) != -1) {
                    char strToArray = Character.toLowerCase((char) element);

                    if (Character.isLetter(strToArray)) {
                        listOfFrequency.put(strToArray, listOfFrequency.getOrDefault(strToArray, 0) + 1);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return listOfFrequency;
    }
}
