package model;

import model.car.Car;
import model.vo.CarName;

import java.util.List;

public class Referee {
    public String[] findWinners(final List<Car> cars) {
        return cars.stream()
                .filter(car -> car.hasLongestDistance(cars))
                .map(Car::getCarName)
                .map(CarName::getValue)
                .toArray(String[]::new);
    }
}
