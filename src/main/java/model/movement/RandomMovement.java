package model.movement;

import java.util.Random;

public class RandomMovement implements Movement {
    private final Random random = new Random();

    public boolean generateMovement() {
        return random.nextBoolean();
    }
}
