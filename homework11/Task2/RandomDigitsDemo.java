package homework11.Task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static java.lang.String.join;

public class RandomDigitsDemo {

    public static void main(String[] args) throws IOException {
        File file = new File(join(File.separator, "src", "homework11", "Task2", "RandomDigits.txt"));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            List<Integer> digitals = new DigitsGenerator().generateDigitalsToFile(35,150);

            bufferedWriter.write("Заполним файл случайными числами: " + "\n");
            for (Integer digital : digitals) {
                bufferedWriter.write( digital + "\n");
            }

            bufferedWriter.write("Отсортируем файл: " + "\n");
            Collections.sort(digitals);
            for (Integer digital : digitals) {
                bufferedWriter.write(digital + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
