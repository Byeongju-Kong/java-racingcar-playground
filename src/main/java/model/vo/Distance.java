package model.vo;

import java.util.Objects;

public class Distance {
    private final int movementTimes;

    public Distance(final int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("이동 거리는 0보다 작을 수 없습니다.");
        }
        movementTimes = distance;
    }

    public int getValue() {
        return movementTimes;
    }

    public boolean isShorter(Distance another) {
        return movementTimes <= another.movementTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return movementTimes == distance.movementTimes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movementTimes);
    }
}
