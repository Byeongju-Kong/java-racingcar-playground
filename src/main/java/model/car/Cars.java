package model.car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    public List<Car> race(final boolean[] randomMovements) {
        return IntStream.range(0, carValues.size())
                .mapToObj(index -> carValues.get(index).moveOn(randomMovements[index]))
                .collect(Collectors.toList());
    }

    public List<Car> findLongestDistanceCars() {
        return carValues.stream().filter(car -> car.hasLongestDistance(carValues))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return carValues;
    }
}
