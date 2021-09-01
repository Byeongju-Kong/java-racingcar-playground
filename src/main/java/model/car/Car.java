package model.car;

import java.util.List;

public class Car {
    private final CarName carName;
    private final Distance distance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        distance = new Distance();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public Integer getDistance() {
        return distance.getDistance();
    }

    public void drive() {
        distance.increase();
    }

    public boolean hasLongestDistance(List<Car> otherCars) {
        return otherCars.stream()
                .allMatch(otherCar -> otherCar.hasLongerDistance(this.getDistance()));
    }

    private boolean hasLongerDistance(final int distance) {
        return this.getDistance() >= distance;
    }
}
