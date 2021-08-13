package util;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomMovement {
    private static final Random random = new Random();
    private static final int MOVEMENT_TIMES_LIMITS = 2;
    private static final int START_ENTRY = 0;
    private static final int NUMBER_OF_CARS = 3;

    private RandomMovement() {
    }

    private static int generateRandomMovement() {
        return random.nextInt(MOVEMENT_TIMES_LIMITS);
    }

    public static int[] generateRandomMovements() {
        int[] randomMovements = new int[3];
        IntStream.range(START_ENTRY, NUMBER_OF_CARS)
                .forEach(index -> randomMovements[index] = generateRandomMovement());
        return randomMovements;
    }
}
