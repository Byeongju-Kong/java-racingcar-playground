package model.car;

public class Distance {
    private Integer movementTimes;

    public Distance() {
        movementTimes = 0;
    }

    public void increase() {
        movementTimes++;
    }

    public int getDistance() {
        return movementTimes;
    }
}
