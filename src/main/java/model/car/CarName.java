package model.car;

public class CarName {
    private static final Integer CAR_NAME_LENGTH_BOUNDARY = 5;
    private final String name;

    public CarName(String carName) {
        validateCarName(carName);
        this.name = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_BOUNDARY) {
            throw new IllegalArgumentException("차 이름은 5글자보다 길 수 없습니다");
        }
    }

    public String getCarName() {
        return name;
    }
}
