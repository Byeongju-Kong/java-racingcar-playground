package model;

import model.car.Car;
import model.dto.RoundDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {
    private final List<Car> cars;
    private final Integer numberOfCars;
    private static final Integer MIN_NUMBER_OF_CARS = 2;

    public Racing(final String[] carNames) {
        numberOfCars = carNames.length;
        validateCarNames(carNames);
        cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateCarNames(final String[] carNames) {
        if (carNames.length < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("경주차는 적어도 2개가 필요합니다.");
        }
        if (Arrays.stream(carNames).distinct().count() != numberOfCars) {
            throw new IllegalArgumentException("경주차의 이름에 중복이 있습니다.");
        }
    }

    public RoundDTO getRoundResult() {
        List<String> carNames = cars.stream().map(Car::getCarName).collect(Collectors.toList());
        List<Integer> distances = cars.stream().map(Car::getDistance).collect(Collectors.toList());
        return new RoundDTO(carNames, distances);
    }

    public void race(final List<Boolean> randomMovements) {
        IntStream.range(0, numberOfCars)
                .filter(randomMovements::get)
                .forEach(index -> cars.get(index).moveOn());
    }

    public List<Car> findLongestDistanceCars() {
        return cars.stream().filter(car -> car.hasLongestDistance(cars))
                .collect(Collectors.toList());
    }
}
