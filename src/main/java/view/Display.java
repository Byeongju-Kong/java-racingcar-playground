package view;

import model.car.Car;

import java.util.List;
import java.util.stream.IntStream;

public class Display {
    private static final String DISTANCE_SYMBOL = "-";
    private static final String COMMA = ",";

    private Display() {
    }

    public static void alertInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void alertInputRacingRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void showStart() {
        System.out.println("\n실행결과\n");
    }

    public static void showRoundResult(List<Car> cars) {
        IntStream.range(0, cars.size())
                .forEach(index -> System.out.println(cars.get(index).getCarName() + " : " +
                        DISTANCE_SYMBOL.repeat(cars.get(index).getDistance())));
        System.out.println();
    }

    public static void showFinalResult(List<Car> winner) {
        StringBuilder result = new StringBuilder();
        String lastWords = "가 최종 우승했습니다.";
        IntStream.range(0, winner.size())
                .forEach(index -> result.append(winner.get(index).getCarName()).append(COMMA));
        result.deleteCharAt(result.lastIndexOf(COMMA));
        System.out.print(result.append(lastWords));
    }
}
