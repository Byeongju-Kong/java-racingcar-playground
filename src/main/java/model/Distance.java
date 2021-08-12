package model;

public class Distance {
    private static final String DISTANCE_SYMBOL = "-";
    private int increaseTimes;

    public Distance() {
        increaseTimes = 0;
    }

    public void increase() {
        increaseTimes++;
    }

    public String getDistance() {
        return DISTANCE_SYMBOL.repeat(increaseTimes);
    }
}
