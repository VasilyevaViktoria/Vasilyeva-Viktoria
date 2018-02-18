package homework11.Task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.String.join;

public final class DigitalsGenerator {

    private static final int BOUND = 100;

    public DigitalsGenerator() {
    }

    public static File generateDigitalsToFile(int countOfDigits) throws IOException {
        File file = new File(join(File.separator, "src", "homework11", "Task2", "RandomDigits.txt"));
        Random random = new Random();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));) {
            for (int i = 0; i < countOfDigits; i++) {
                bufferedWriter.write(random.nextInt(BOUND) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
