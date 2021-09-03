package controller;

import model.Racing;
import view.Display;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static controller.Input.inputCarNames;
import static controller.Input.inputRacingRound;

public class RacingController {
    private final Racing racing;
    private final Integer numberOfCars;

    public RacingController() {
        Display.alertInputCarNames();
        String[] carNames = inputCarNames();
        numberOfCars = carNames.length;
        racing = new Racing(carNames);
    }

    public void run() {
        Display.alertInputRacingRound();
        int racingRound = inputRacingRound();
        Display.showStart();
        while (racingRound-- > 0) {
            race();
        }
        Display.showFinalResult(racing.findLongestDistanceCar());
    }

    private void race() {
        racing.race(generateRandomMovements(numberOfCars));
        Display.showRoundResult(racing.getRoundResult());
    }

    private List<Boolean> generateRandomMovements(final int numberOfCars) {
        Random random = new Random();
        return Stream.generate(random::nextBoolean)
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }
}
