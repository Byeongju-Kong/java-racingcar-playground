package util;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomMovement {
    private static final Random random = new Random();
    private static final int START_ENTRY = 0;
    private static final int NUMBER_OF_CARS = 3;

    private RandomMovement() {
    }

    private static boolean generateRandomMovement() {
        return random.nextBoolean();
    }

    public static boolean[] generateRandomMovements() {
        boolean[] randomMovements = new boolean[3];
        IntStream.range(START_ENTRY, NUMBER_OF_CARS)
                .forEach(index -> randomMovements[index] = generateRandomMovement());
        return randomMovements;
    }
}
