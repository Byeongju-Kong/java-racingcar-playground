package controller;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() {
    }

    public static String[] inputCarNames() {
        return SCANNER.nextLine().split(",");
    }

    public static Integer inputRacingRound() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
