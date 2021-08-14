package model;

import model.car.Car;

import java.util.ArrayList;
import java.util.List;
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
    }

    public int[] getDistances() {
        return new int[]{cars[0].getDistance(), cars[1].getDistance(), cars[2].getDistance()};
    }

    public void race(boolean[] randomMovements) { //getDistance 메서드 안으로 private하게 들어가면 되는데 테스트를 위해 굳이 public으로 분리해야하나?
        IntStream.range(0, NUMBER_OF_CARS)
                .filter(index -> randomMovements[index])
                .forEach(index -> cars[index].drive());
    }

    public List<Car> findLongestDistanceCar() {
        List<Car> result = new ArrayList<>();
        int maxDistance = max(max(cars[0].getDistance(), cars[1].getDistance()), cars[2].getDistance());
        IntStream.range(0, NUMBER_OF_CARS)
                .filter(index -> maxDistance == cars[index].getDistance())
                .forEach(index -> result.add(cars[index]));
        return result;
    }
}