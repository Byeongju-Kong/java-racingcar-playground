package model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("차를 달리게 하고 달린 거리를 반환한다")
    void driveAndGetDistance() {
        Car audi = new Car("Audi");
        audi.drive();
        int expectedDistance = 1;
        int actualDistance = audi.getDistance();
        assertThat(actualDistance).isEqualTo(expectedDistance);
    }

    @Test
    @DisplayName("차 이름을 반환한다")
    void getCarName() {
        String actualCarNameOfFirstCar = firstCar.getCarName();
        String actualCarNameOfSecondCar = secondCar.getCarName();
        String actualCarNameOfThirdCar = thirdCar.getCarName();
        assertAll(
                () -> assertThat(actualCarNameOfFirstCar).isEqualTo("Audi"),
                () -> assertThat(actualCarNameOfSecondCar).isEqualTo("BMW"),
                () -> assertThat(actualCarNameOfThirdCar).isEqualTo("Benz")
        );
    }

    @Test
    @DisplayName("가장 먼 거리를 간 차 이름(들)을 반환한다")
    void hasSameDistance() {
        Car audi = new Car("Audi");
        Car bmw = new Car("BMW");
        Car benz = new Car("Benz");
        audi.drive();
        assertThat(audi.hasLongestDistance(Arrays.asList(audi, bmw, benz))).isTrue();
    }
}
