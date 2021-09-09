package model.movement;

import java.util.Random;
import java.util.stream.Stream;

public class RandomMovement implements Movement {
    private final Random random = new Random();

    public Boolean[] generateRandomMovements(int numberOfCars) {
        return Stream.generate(this::generateRandom)
                .limit(numberOfCars)
                .toArray(Boolean[]::new);
    }

    protected Boolean generateRandom() {
        return random.nextBoolean();
    }
}
