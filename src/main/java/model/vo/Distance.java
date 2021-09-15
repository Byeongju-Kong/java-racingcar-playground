package model.vo;

public class Distance {
    private final int movementTimes;

    public Distance(final int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("이동 거리는 0보다 작을 수 없습니다.");
        }
        movementTimes = distance;
    }

    public int getDistance() {
        return movementTimes;
    }
}
