package controller;

import model.Racing;
import view.Display;

import static controller.Input.inputCarNames;
import static controller.Input.inputRacingRound;
import static util.RandomMovement.generateRandomMovements;

public class RacingController {
    private Racing racing;

    public RacingController() {
        Display.alertInputCarNames();
        racing = new Racing(inputCarNames());
    }

    public void run() {
        Display.alertInputRacingRound();
        int racingRound = inputRacingRound();
        Display.showStart();
        while (racingRound-- > 0) {
            racing.race(generateRandomMovements());
            Display.showRoundResult(racing.getRoundResult());
        }
        Display.showFinalResult(racing.findLongestDistanceCar());
    }
}
