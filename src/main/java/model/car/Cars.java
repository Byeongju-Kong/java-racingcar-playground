package model.car;

import model.movement.MovementStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> values;

    public Cars(final String[] carNames) {
        values = Stream.of(carNames)
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public Cars(final List<Car> cars) {
        values = cars;
    }

    public List<Car> race(final MovementStrategy movement) {
        return values.stream()
                .map(car -> car.moveOn(movement.generateMovement()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> findLongestDistanceCars() {
        return values.stream().filter(car -> car.hasLongestDistance(values))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return values;
    }
}
