package model.car;

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

    public boolean hasSameDistance(int maxDistance) {
        return maxDistance == distance.getDistance();
    }
}
