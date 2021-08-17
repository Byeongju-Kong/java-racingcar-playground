package model;

import model.car.Car;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.max;

public class Racing {
    private final List<Car> cars;
    private int numberOfCars;
    private static final int MIN_NUMBER_OF_CARS = 2;

    public Racing(String[] carNames) {
        validateCarNames(carNames);
        cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateCarNames(String[] carNames) {
        numberOfCars = carNames.length;
        if (carNames.length < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("경주차는 적어도 2개가 필요합니다.");
        }
        if (Arrays.stream(carNames).distinct().count() != numberOfCars) {
            throw new IllegalArgumentException("경주차의 이름에 중복이 있습니다.");
        }
    }

    public List<Car> getRoundResult() {
        return cars;
    }

    public void race(List<Boolean> randomMovements) {
        IntStream.range(0, numberOfCars)
                .filter(randomMovements::get)
                .forEach(index -> cars.get(index).drive());
    }

    public List<Car> findLongestDistanceCar() {
        List<Car> result = new ArrayList<>();
        int maxDistance = max(max(cars.get(0).getDistance(), cars.get(1).getDistance()), cars.get(2).getDistance());
        cars.stream().filter(car -> car.hasSameDistance(maxDistance))
                .forEach(result::add);
        return result;
    }
}
