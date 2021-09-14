package model.vo;

public class CarName {
    private static final Integer CAR_NAME_LENGTH_BOUNDARY = 5;
    private static final String EMPTY = " ";
    private final String name;

    public CarName(final String carName) {
        validateCarName(carName);
        this.name = carName;
    }

    private void validateCarName(final String carName) {
        if (carName.length() > CAR_NAME_LENGTH_BOUNDARY) {
            throw new IllegalArgumentException("차 이름은 5글자보다 길 수 없습니다");
        }
        if (carName.contains(EMPTY)) {
            throw new IllegalArgumentException("차 이름엔 공백이 포함될 수 없습니다.");
        }
    }

    public String getCarName() {
        return name;
    }
}
