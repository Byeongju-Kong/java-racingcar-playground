package controller;

import model.movement.MovementStrategy;
import model.movement.RandomMovement;
import view.Input;
import view.InputDisplay;
import view.Output;
import view.OutputDisplay;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input inputDisplay = new InputDisplay(scanner);
        Output outputDisplay = new OutputDisplay();
        MovementStrategy movement = new RandomMovement();
        RacingController racingGameController = new RacingController(inputDisplay, outputDisplay, movement);
        racingGameController.run();
        scanner.close();
    }
}
