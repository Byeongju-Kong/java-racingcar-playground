package controller;

import model.Racing;
import model.Referee;
import model.movement.Movement;
import view.Display;

public class RacingController {
    private static final int ENDING_ROUND = 0;
    private final Racing racing;
    private final Display display;
    private final Movement movement;

    public RacingController(final Display display, final Movement movement) {
        this.display = display;
        this.movement = movement;
        racing = new Racing(display.inputCarNames());
    }

    public void run() {
        int racingRound = display.inputRacingRound();
        while (racingRound-- > ENDING_ROUND) {
            race();
        }
        String[] winners = new Referee().findWinners(racing.getRacedResult());
        display.showWinners(winners);
    }

    private void race() {
        racing.race(movement);
        display.showRoundResult(racing.getRacedResult());
    }
}