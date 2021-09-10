package model.vo;

public class CarName {
    private static final Integer CAR_NAME_LENGTH_BOUNDARY = 5;
    private static final char EMPTY = ' ';
    private final String name;

    public CarName(final String carName) {
        validateCarName(carName);
        this.name = carName;
    }

    private void validateCarName(final String carName) {
        if (carName.length() > CAR_NAME_LENGTH_BOUNDARY) {
            throw new IllegalArgumentException("차 이름은 5글자보다 길 수 없습니다");
        }
        if (carName.charAt(0) == EMPTY) {
            throw new IllegalArgumentException("차 이름은 공백으로 시작할 수 없고, 차 이름을 공백으로 생성할 수 없습니다.");
        }
    }

    public String getCarName() {
        return name;
    }
}
