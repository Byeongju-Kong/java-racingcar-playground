package controller;

import model.Racing;
import model.Referee;
import model.movement.Movement;
import view.Display;

public class RacingController {
    private final Racing racing;
    private final Integer numberOfCars;
    private final Display display;
    private final Movement movement;
    private static final int ENDING_ROUND = 0;

    public RacingController(Display display, Movement movement) {
        this.display = display;
        this.movement = movement;
        String[] carNames = display.inputCarNames();
        numberOfCars = carNames.length;
        racing = new Racing(carNames);
    }

    public void run() {
        int racingRound = display.inputRacingRound();
        while (racingRound-- > ENDING_ROUND) {
            race();
        }
        String[] winners = new Referee().findLongestCars(racing.getRacedResult());
        display.showFinalResult(winners);
    }

    private void race() {
        racing.race(movement.generateRandomMovements(numberOfCars));
        display.showRoundResult(racing.getRacedResult());
    }
}