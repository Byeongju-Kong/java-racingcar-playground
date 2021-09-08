package model;

import model.car.Car;
import model.car.Cars;

import java.util.Arrays;
import java.util.List;

public class Racing {
    private Cars cars;
    private static final Integer MIN_NUMBER_OF_CARS = 2;

    public Racing(final String[] carNames) {
        validateCarNames(carNames);
        cars = new Cars(carNames);
    }

    private void validateCarNames(final String[] carNames) {
        if (carNames.length < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("경주차는 적어도 2개가 필요합니다.");
        }
        if (Arrays.stream(carNames).distinct().count() != carNames.length) {
            throw new IllegalArgumentException("경주차의 이름에 중복이 있습니다.");
        }
    }

    public List<Car> race(final boolean[] randomMovements) {
        cars = new Cars(cars.race(randomMovements));
        return cars.getCars();
    }

    public List<Car> findLongestDistanceCars() {
        return cars.findLongestDistanceCars();
    }
}
