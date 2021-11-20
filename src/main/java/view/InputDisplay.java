package view;

import java.util.Scanner;

public class InputDisplay implements Input {
    private final Scanner scanner;

    public InputDisplay(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().split(",");
    }

    @Override
    public int inputRacingRound() {
        System.out.print("시도할 횟수는 몇회인가요? ");
        return Integer.parseInt(scanner.nextLine());
    }
}