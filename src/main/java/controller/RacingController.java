package controller;

import model.Racing;
import model.RacingRound;
import model.Referee;
import model.movement.MovementStrategy;
import model.movement.RandomMovement;
import view.Display;
import view.RacingDisplay;

import java.util.List;
import java.util.Scanner;

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
        List<String> winners = new Referee().findWinners(racing.getRacedResult());
        display.showWinners(winners);
    }

    private void race() {
        racing.race(movement);
        display.showRoundResult(racing.getRacedResult());
        racingRound.decreaseLeftRound();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new RacingDisplay(scanner);
        MovementStrategy movement = new RandomMovement();
        RacingController racingGameController = new RacingController(display, movement);
        racingGameController.run();
        scanner.close();
    }
}