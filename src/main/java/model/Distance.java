package model;

public class Distance {
    private static final String DISTANCE_SYMBOL = "-";
    private int movementTimes;

    public Distance() {
        movementTimes = 0;
    }

    public void increase() {
        movementTimes++;
    }

    public String getDistance() {
        return DISTANCE_SYMBOL.repeat(movementTimes);
    }
}
