package model;

import model.car.Car;

import java.util.List;

public class Referee {
    public String[] findWinners(List<Car> cars) {
        return cars.stream()
                .filter(car -> car.hasLongestDistance(cars))
                .map(Car::getCarName)
                .toArray(String[]::new);
    }
}
