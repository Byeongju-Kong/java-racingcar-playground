package controller;

import model.Racing;
import model.car.Car;
import model.movement.Movement;
import view.Display;

import java.util.List;

public class RacingGameController {
    private final Racing racing;
    private final Integer numberOfCars;
    private final Display display;
    private final Movement movement;
    private static final int ENDING_ROUND = 0;

    public RacingGameController(Display display, Movement movement) {
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
        display.showFinalResult(racing.findLongestDistanceCars());
    }

    private void race() {
        List<Car> racedCars = racing.race(movement.generateRandomMovements(numberOfCars));
        display.showRoundResult(racedCars);
    }
}