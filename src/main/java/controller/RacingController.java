package controller;

import model.Racing;
import model.Referee;
import model.movement.Movement;
import model.movement.RandomMovement;
import view.Display;
import view.RacingDisplay;

import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new RacingDisplay(scanner);
        Movement movement = new RandomMovement();
        RacingController racingGameController = new RacingController(display, movement);
        racingGameController.run();
        scanner.close();
    }
}