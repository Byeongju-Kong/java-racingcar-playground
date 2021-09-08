package model.movement;

import java.util.Arrays;
import java.util.Random;

public class RandomMovement implements Movement {
    private final Random random = new Random();

    public boolean[] generateRandomMovements(int numberOfCars) {
        boolean[] randomMovements = new boolean[numberOfCars];
        Arrays.fill(randomMovements, generateRandom());
        return randomMovements;
    }

    protected Boolean generateRandom() {
        return random.nextBoolean();
    }
}
