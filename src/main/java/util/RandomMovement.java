package util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomMovement {
    private static final Random RANDOM = new Random();

    private RandomMovement() {
    }

    public static List<Boolean> generateRandomMovements(int number) {
        return Stream.generate(RANDOM::nextBoolean)
                .limit(number)
                .collect(Collectors.toList());
    }
}
