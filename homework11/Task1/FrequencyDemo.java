package homework11.Task1;

import java.io.*;
import java.util.Map;

import static java.lang.String.join;

public class FrequencyDemo {

    public static void main(String[] args) throws IOException {
        File file = new File(join(File.separator, "src", "homework11", "Task1", "Pushkin.txt"));

        for (Map.Entry<Character, Integer> entry : Frequency.countOfRepeat(file).entrySet()) {
            System.out.printf("Буква '%s' - %s раз ", entry.getKey(), entry.getValue());
            System.out.println();
        }
    }
}

