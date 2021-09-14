package model.movement;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomMovement implements Movement {
    private final Random random = new Random();

    public boolean[] generateRandomMovements(final int numberOfCars) {
        boolean[] randomMovements = new boolean[numberOfCars];
        IntStream.range(0, numberOfCars)
                .forEach(index -> randomMovements[index] = generateRandom());
        return randomMovements;
    }

    protected boolean generateRandom() {
        return random.nextBoolean();
    }
}
