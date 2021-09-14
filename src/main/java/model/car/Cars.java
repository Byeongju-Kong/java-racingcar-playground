package model.car;

import model.movement.Movement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> carValues;

    public Cars(final String[] carNames) {
        carValues = Stream.of(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(final List<Car> cars) {
        carValues = cars;
    }

    public List<Car> race(final Movement movement) {
        return carValues.stream()
                .map(car -> car.moveOn(movement.generateRandom()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> findLongestDistanceCars() {
        return carValues.stream().filter(car -> car.hasLongestDistance(carValues))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return carValues;
    }
}
