package homework11.Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateDigitals {

    public static final int BOUND = 100;

    public List<Integer> generateDigitalsToFile(int countOfDigits) {
        Random random = new Random();
        List<Integer> digitalsRandom = new ArrayList<>();

        for (int i = 0; i < countOfDigits; i++) {
            digitalsRandom.add(random.nextInt(BOUND));
        }

        return digitalsRandom;
    }

    public List<Integer> generateDigitalsToFile(int countOfDigits, int bound) {
        Random random = new Random();
        List<Integer> digitalsRandom = new ArrayList<>();

        for (int i = 0; i < countOfDigits; i++) {
            digitalsRandom.add(random.nextInt(bound));
        }

        return digitalsRandom;
    }
}
