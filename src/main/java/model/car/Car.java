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

    public int getDistance() {
        return distance.getDistance();
    }

    public void drive() {
        distance.increase();
    }

    public boolean hasLongestDistance(List<Car> otherCars) {
        return otherCars.stream()
                .allMatch(otherCar -> otherCar.getDistance() <= this.getDistance());
    }
}
