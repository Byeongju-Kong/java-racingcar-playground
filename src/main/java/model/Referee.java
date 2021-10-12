package model;

import model.car.Car;
import model.vo.CarName;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    public List<String> findWinners(final List<Car> cars) {
        return cars.stream()
                .filter(car -> car.hasLongestDistance(cars))
                .map(Car::getCarName)
                .map(CarName::getValue)
                .collect(Collectors.toUnmodifiableList());
    }
}