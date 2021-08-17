package controller;

import model.Racing;
import view.Display;

import static controller.Input.inputCarNames;
import static controller.Input.inputRacingRound;
import static util.RandomMovement.generateRandomMovements;

public class RacingController {
    private final Racing racing;
    private final int numberOfCars;

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
}
