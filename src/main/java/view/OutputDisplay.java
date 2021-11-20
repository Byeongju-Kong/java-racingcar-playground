package view;

import model.car.Car;

import java.util.List;
import java.util.stream.IntStream;

public class OutputDisplay implements Output {
    private static final String DISTANCE_SYMBOL = "-";
    private static final String DELIMITER = ",";

    @Override
    public void showRoundResult(List<Car> cars) {
        IntStream.range(0, cars.size())
                .forEach(index -> System.out.println(cars.get(index).getCarName().getValue() + " : "
                        + DISTANCE_SYMBOL.repeat(cars.get(index).getDistance().getValue())));
    }

    @Override
    public void showWinners(List<String> winners) {
        StringBuilder result = new StringBuilder();
        IntStream.range(0, winners.size())
                .forEach(index -> result.append(winners.get(index)).append(DELIMITER));
        result.deleteCharAt(result.lastIndexOf(DELIMITER));
        System.out.print(result.append("가 최종 우승했습니다."));
    }
}
