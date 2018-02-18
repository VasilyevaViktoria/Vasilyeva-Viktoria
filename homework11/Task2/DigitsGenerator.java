package homework11.Task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class DigitsGenerator {

    private static final int BOUND = 100;
    Random random = new Random();

    public List<Integer> generateDigitalsToFile(int countOfDigits) {
        List<Integer> digitalsRandom = new ArrayList<>(countOfDigits);

        for (int i = 0; i < countOfDigits; i++) {
            digitalsRandom.add(random.nextInt(BOUND));
        }

        return digitalsRandom;
    }

    public List<Integer> generateDigitalsToFile(int countOfDigits, int bound) {
        List<Integer> digitalsRandom = new ArrayList<>(countOfDigits);

        for (int i = 0; i < countOfDigits; i++) {
            digitalsRandom.add(random.nextInt(bound));
        }

        return digitalsRandom;
    }
}
