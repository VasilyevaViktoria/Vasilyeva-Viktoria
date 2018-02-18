package homework11.Task2;

import java.io.File;
import java.io.IOException;

public class RandomDigitalsDemo {

    public static void main(String[] args) throws IOException {
        File unsortedDigitals = DigitalsGenerator.generateDigitalsToFile(15);
        DigitsSortedGenerator.sortedDigitalsToFile(unsortedDigitals);
    }
}
