package controller;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String[] inputCarNames() {
        return scanner.nextLine().split(",");
    }

    public Integer inputRacingRound() {
        return Integer.parseInt(scanner.nextLine());
    }
}
