package model.car;

import model.vo.CarName;
import model.vo.Distance;

import java.util.List;

public class Car {
    private final CarName carName;
    private final Distance distance;
    private static final int DISTANCE_UNIT = 1;
    private static final int INITIAL_DISTANCE = 0;

    public Car(String carName, Integer distance) {
        this.carName = new CarName(carName);
        this.distance = new Distance(distance);
    }

    public Car(final String carName) {
        this(carName, INITIAL_DISTANCE);
    }

    public String getCarName() {
        return carName.getValue();
    }

    public Integer getDistance() {
        return distance.getValue();
    }

    public Car moveOn(final boolean movement) {
        if (movement) {
            return new Car(carName.getValue(), distance.getValue() + DISTANCE_UNIT);
        }
        return this;
    }

    public boolean hasLongestDistance(final List<Car> otherCars) {
        return otherCars.stream()
                .allMatch(otherCar -> otherCar.hasShorterDistance(this.getDistance()));
    }

    private boolean hasShorterDistance(final int distance) {
        return this.getDistance() <= distance;
    }
}
