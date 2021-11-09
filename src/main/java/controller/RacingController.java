package controller;

import model.Racing;
import model.RacingRound;
import model.car.Car;
import model.movement.MovementStrategy;
import model.vo.CarName;
import view.Display;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final Racing racing;
    private final Display display;
    private final MovementStrategy movement;
    private final RacingRound racingRound;

    public RacingController(final Display display, final MovementStrategy movement) {
        this.display = display;
        this.movement = movement;
        racing = new Racing(display.inputCarNames());
        racingRound = new RacingRound(display.inputRacingRound());
    }

    public void run() {
        while (!racingRound.isOver()) {
            race();
        }
        List<String> winners = racing.getWinners().stream()
                .map(Car::getCarName)
                .map(CarName::getValue)
                .collect(Collectors.toUnmodifiableList());
        display.showWinners(winners);
    }

    private void race() {
        racing.race(movement);
        display.showRoundResult(racing.getRacedResult());
        racingRound.decreaseLeftRound();
    }
}