package homework11.Task1;

import java.io.*;
import java.util.List;
import java.util.Map;

import static java.lang.String.join;

public class FrequencyDemo {

    public static void main(String[] args) throws IOException {
        File file = new File(join(File.separator, "src", "homework11", "Task1", "Pushkin.txt"));
        Map<Character, Integer> digitals = new Frequency().countOfRepeat(file);

        for (Map.Entry<Character, Integer> entry : digitals.entrySet()) {
            System.out.printf("Буква '%s' - %s раз ", entry.getKey(), entry.getValue());
            System.out.println();
        }
    }
}

