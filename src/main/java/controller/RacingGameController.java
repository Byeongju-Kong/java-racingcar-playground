package controller;

import model.Racing;
import view.Display;
import view.Displayable;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static controller.Input.inputCarNames;
import static controller.Input.inputRacingRound;

public class RacingGameController {
    private final Racing racing;
    private final Integer numberOfCars;
    private final Displayable display = new Display();
    private static final int ENDING_ROUND = 0;

    public RacingGameController() {
        display.alertInputCarNames();
        String[] carNames = inputCarNames();
        numberOfCars = carNames.length;
        racing = new Racing(carNames);
    }

    public void run() {
        display.alertInputRacingRound();
        int racingRound = inputRacingRound();
        display.showStart();
        while (racingRound-- > ENDING_ROUND) {
            race();
        }
        display.showFinalResult(racing.findLongestDistanceCars());
    }

    private void race() {
        racing.race(generateRandomMovements(numberOfCars));
        display.showRoundResult(racing.getRoundResult());
    }

    private List<Boolean> generateRandomMovements(final int numberOfCars) {
        Random random = new Random();
        return Stream.generate(random::nextBoolean)
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }
}
