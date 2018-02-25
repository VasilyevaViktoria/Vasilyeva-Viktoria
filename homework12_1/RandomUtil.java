package homework12_1;

import java.util.Random;

public class RandomUtil {

    private final static Random RANDOM = new Random();
    private static final int DEFAULT_BOUND = 4;

    private RandomUtil() {
    }

    public static int generateDetails(int n) {
        return RANDOM.nextInt(n);
    }

    public static int generateDetailsFromOneToFour() {
        return RANDOM.nextInt(DEFAULT_BOUND) + 1;
    }
}
