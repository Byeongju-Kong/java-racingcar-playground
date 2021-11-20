package controller;

import model.Racing;
import model.RacingRound;
import model.movement.MovementStrategy;
import view.Input;
import view.Output;

import java.util.List;

public class RacingController {
    private final Racing racing;
    private final Output outputDisplay;
    private final MovementStrategy movement;
    private final RacingRound racingRound;

    public RacingController(final Input inputDisplay, final Output outputDisplay, final MovementStrategy movement) {
        this.outputDisplay = outputDisplay;
        this.movement = movement;
        racing = new Racing(inputDisplay.inputCarNames());
        racingRound = new RacingRound(inputDisplay.inputRacingRound());
    }

    public void run() {
        while (!racingRound.isOver()) {
            race();
        }
        List<String> winners = racing.getWinnersName();
        outputDisplay.showWinners(winners);
    }

    private void race() {
        racing.race(movement);
        outputDisplay.showRoundResult(racing.getRacedResult());
        racingRound.decreaseLeftRound();
    }
}