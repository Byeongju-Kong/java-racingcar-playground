package main;

import controller.RacingController;
import model.movement.Movement;
import model.movement.RandomMovement;
import view.Display;
import view.RacingDisplay;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display display = new RacingDisplay(scanner);
        Movement movement = new RandomMovement();
        RacingController racingGameController = new RacingController(display, movement);
        racingGameController.run();
        scanner.close();
    }
}
