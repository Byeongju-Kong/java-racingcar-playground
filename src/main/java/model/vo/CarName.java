package model.vo;

import java.util.Objects;

public class CarName {
    private static final Integer CAR_NAME_LENGTH_BOUNDARY = 5;
    private static final String EMPTY = " ";
    private final String value;

    public CarName(final String carName) {
        validateCarName(carName);
        this.value = carName.trim();
    }

    private void validateCarName(final String carName) {
        if (carName.trim().length() > CAR_NAME_LENGTH_BOUNDARY) {
            throw new IllegalArgumentException("차 이름은 5글자보다 길 수 없습니다");
        }
        if (carName.trim().contains(EMPTY)) {
            throw new IllegalArgumentException("차 이름엔 공백이 포함될 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
