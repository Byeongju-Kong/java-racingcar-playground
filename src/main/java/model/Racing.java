package model;

import model.car.Car;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

import static java.lang.Math.max;

public class Racing {
    private final Car[] cars = new Car[3];
    private static final int NUMBER_OF_CARS = 3;

    public Racing(String[] carNames) {
        validateCarNames(carNames);
        IntStream.range(0, NUMBER_OF_CARS)
                .forEach(index -> cars[index] = new Car(carNames[index]));
    }

    private void validateCarNames(String[] carNames) {
        if (carNames.length != 3) {
            throw new IllegalArgumentException("경주차의 개수가 잘못되었습니다.");
        }
        if (Arrays.stream(carNames).distinct().count() != NUMBER_OF_CARS) {
            throw new IllegalArgumentException("경주차의 이름에 중복이 있습니다.");
        }
    }

    public Car[] getRoundResult() {
        return new Car[]{cars[0], cars[1], cars[2]};
    }

    public void race(boolean[] randomMovements) {
        IntStream.range(0, NUMBER_OF_CARS)
                .filter(index -> randomMovements[index])
                .forEach(index -> cars[index].drive());
    }

    public List<Car> findLongestDistanceCar() {
        List<Car> result = new ArrayList<>();
        int maxDistance = max(max(cars[0].getDistance(), cars[1].getDistance()), cars[2].getDistance());
        Arrays.stream(cars)
                .filter(car -> car.hasSameDistance(maxDistance))
                .forEach(result::add);
        return result;
    }
}
