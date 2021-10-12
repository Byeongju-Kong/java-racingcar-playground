package model.car;

import model.vo.CarName;
import model.vo.Distance;

import java.util.List;

public class Car {
    private static final int INITIAL_DISTANCE = 0;
    private final CarName carName;
    private final Distance distance;

    public Car(final CarName carName, final Distance distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public Car(final String carName, final Integer distance) {
        this(new CarName(carName), new Distance(distance));
    }

    public Car(final String carName) {
        this(carName, INITIAL_DISTANCE);
    }

    public CarName getCarName() {
        return carName;
    }

    public Distance getDistance() {
        return distance;
    }

    public Car moveOn(final boolean movement) {
        if(movement) {
            return new Car(carName, distance.getIncreased());
        }
        return this;
    }

    public boolean hasLongestDistance(final List<Car> otherCars) {
        return otherCars.stream()
                .allMatch(otherCar -> distance.isLonger(otherCar.distance));
    }
}
