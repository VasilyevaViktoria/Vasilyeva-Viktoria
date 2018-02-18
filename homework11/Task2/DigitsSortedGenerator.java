package homework11.Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.join;

public class DigitsSortedGenerator {

    public static File sortedDigitalsToFile(File file) {
        File fileWithSortedDigitals = new File(join(File.separator, "src", "homework11", "Task2", "RandomSortedDigits.txt"));

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
             BufferedWriter bufferedWriterForSortedDigitals = new BufferedWriter(new FileWriter(fileWithSortedDigitals));) {
            List<Integer> digitalsSorted = new ArrayList<>();

            while (scanner.hasNextInt()) {
                digitalsSorted.add(scanner.nextInt());
            }

            Collections.sort(digitalsSorted);
            for (Integer digital : digitalsSorted) {
                bufferedWriterForSortedDigitals.write(digital + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return fileWithSortedDigitals;
    }
}
