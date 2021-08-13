package model;

public class Distance {
    private int movementTimes;

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
