package controller;

import model.Racing;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static controller.Input.inputCarNames;
import static controller.Input.inputRacingRound;
import static view.Display.*;

public class RacingGameController implements GameController {
    private final Racing racing;
    private final Integer numberOfCars;

    public RacingGameController() {
        alertInputCarNames();
        String[] carNames = inputCarNames();
        numberOfCars = carNames.length;
        racing = new Racing(carNames);
    }

    public void run() {
        alertInputRacingRound();
        int racingRound = inputRacingRound();
        showStart();
        while (racingRound-- > 0) {
            race();
        }
        showFinalResult(racing.findLongestDistanceCar());
    }

    private void race() {
        racing.race(generateRandomMovements(numberOfCars));
        showRoundResult(racing.getRoundResult());
    }

    private List<Boolean> generateRandomMovements(final int numberOfCars) {
        Random random = new Random();
        return Stream.generate(random::nextBoolean)
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }
}
