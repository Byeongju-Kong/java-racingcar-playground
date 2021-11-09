package controller;

import model.Racing;
import model.RacingRound;
import model.movement.MovementStrategy;
import view.Display;

import java.util.List;

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
        List<String> winners = racing.getWinnersName();
        display.showWinners(winners);
    }

    private void race() {
        racing.race(movement);
        display.showRoundResult(racing.getRacedResult());
        racingRound.decreaseLeftRound();
    }
}