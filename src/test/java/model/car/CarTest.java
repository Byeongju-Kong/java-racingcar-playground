package model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {
    private Car firstCar;
    private Car secondCar;
    private Car thirdCar;

    @BeforeEach
    void setUp() {
        firstCar = new Car("Audi");
        secondCar = new Car("BMW");
        thirdCar = new Car("Benz");
        firstCar.drive();
        firstCar.drive();
        secondCar.drive();
        thirdCar.drive();
        thirdCar.drive();
    }

    @Test
    @DisplayName("차를 달리게 하고 달린 거리를 반환한다")
    void driveAndGetDistance() {
        int actualDistanceOfFirstCar = firstCar.getDistance();
        int actualDistanceOfSecondCar = secondCar.getDistance();
        int actualDistanceOfThirdCar = thirdCar.getDistance();
        assertAll(
                () -> assertThat(actualDistanceOfFirstCar).isEqualTo(2),
                () -> assertThat(actualDistanceOfSecondCar).isEqualTo(1),
                () -> assertThat(actualDistanceOfThirdCar).isEqualTo(2)
        );
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
        audi.drive();
        audi.drive();

        bmw.drive();
        bmw.drive();

        benz.drive();
        benz.drive();
        assertAll(
                () -> assertThat(audi.hasLongestDistance(Arrays.asList(audi, bmw, benz))).isTrue(),
                () -> assertThat(bmw.hasLongestDistance(Arrays.asList(audi, bmw, benz))).isFalse(),
                () -> assertThat(benz.hasLongestDistance(Arrays.asList(audi, bmw, benz))).isFalse()
        );
        benz.drive();
        assertAll(
                () -> assertThat(audi.hasLongestDistance(Arrays.asList(audi, bmw, benz))).isTrue(),
                () -> assertThat(bmw.hasLongestDistance(Arrays.asList(audi, bmw, benz))).isFalse(),
                () -> assertThat(benz.hasLongestDistance(Arrays.asList(audi, bmw, benz))).isTrue()
        );

    }
}
