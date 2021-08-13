package model;

public class Car {
    private final CarName carName;
    private Distance distance;

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

    public boolean hasLongestDistance(Car otherCarA, Car otherCarB) {
        return distance.getDistance() >= otherCarA.getDistance()
                && distance.getDistance() >= otherCarB.getDistance();
    }
}
