package model.vo;

import java.util.Objects;

public class Distance {
    private static final int DISTANCE_UNIT = 1;
    private final int value;

    public Distance(final int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("이동 거리는 0보다 작을 수 없습니다.");
        }
        value = distance;
    }

    public int getValue() {
        return value;
    }

    public boolean isLonger(final Distance another) {
        return value >= another.value;
    }

    public Distance getIncreased() {
        return new Distance(value + DISTANCE_UNIT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
