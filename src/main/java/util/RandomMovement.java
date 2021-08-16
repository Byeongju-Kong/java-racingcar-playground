package util;

import java.util.Random;

public class RandomMovement {
    private static final Random random = new Random();

    private RandomMovement() {
    }

    public static boolean[] generateRandomMovements() {
        return new boolean[]{random.nextBoolean(), random.nextBoolean(), random.nextBoolean()};
    }
}
