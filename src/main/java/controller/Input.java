package controller;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public static String[] inputCarNames() {
        return SCANNER.nextLine().split(",");
    }

    public static Integer inputRacingRound() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
