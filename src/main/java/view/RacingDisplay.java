package view;

import model.car.Car;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RacingDisplay implements Display {
    private final Scanner scanner;
    private static final String DISTANCE_SYMBOL = "-";
    private static final String DELIMITER = ",";

    public RacingDisplay(Scanner scanner) {
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

    @Override
    public void showRoundResult(List<Car> cars) {
        IntStream.range(0, cars.size())
                .forEach(index -> System.out.println(cars.get(index).getCarName() + " : "
                        + DISTANCE_SYMBOL.repeat(cars.get(index).getDistance())));
    }

    @Override
    public void showWinners(String[] winners) {
        StringBuilder result = new StringBuilder();
        String lastWords = "가 최종 우승했습니다.";
        IntStream.range(0, winners.length)
                .forEach(index -> result.append(winners[index]).append(DELIMITER));
        result.deleteCharAt(result.lastIndexOf(DELIMITER));
        System.out.print(result.append(lastWords));
    }
}