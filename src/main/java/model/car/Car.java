package model.car;

import java.util.List;

public class Car {
    private final CarName carName;
    private Distance distance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        distance = new Distance(0);
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public Integer getDistance() {
        return distance.getDistance();
    }

    public void moveOn() {
        distance = new Distance(getDistance() + 1);
    }

    public boolean hasLongestDistance(final List<Car> otherCars) {
        return otherCars.stream()
                .allMatch(otherCar -> otherCar.hasShorterDistance(this.getDistance()));
    }

    private boolean hasShorterDistance(final int distance) {
        return this.getDistance() <= distance;
    }
}
