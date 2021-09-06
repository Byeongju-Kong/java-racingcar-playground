package model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("차를 달리게 하고 달린 거리를 반환한다")
    void driveAndGetDistance() {
        Car audi = new Car("Audi");
        audi.moveOn();
        int expectedDistance = 1;
        int actualDistance = audi.getDistance();
        assertThat(actualDistance).isEqualTo(expectedDistance);
    }

    @ParameterizedTest
    @CsvSource("audi,audi")
    @DisplayName("Car 객체의 이름을 반환한다.")
    void driveAndGetDistance(String actualCarName, String expectedCarName) {
        Car car = new Car(actualCarName);
        String actual = car.getCarName();
        assertThat(actual).isEqualTo(expectedCarName);
    }

    @Test
    @DisplayName("가장 먼 거리를 간 차 이름(들)을 반환한다")
    void hasSameDistance() {
        Car audi = new Car("Audi");
        Car bmw = new Car("BMW");
        Car benz = new Car("Benz");
        audi.moveOn();
        assertThat(audi.hasLongestDistance(Arrays.asList(audi, bmw, benz))).isTrue();
    }
}
