package model.car;

import model.vo.CarName;
import model.vo.Distance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Audi", 0);
    }

    @Test
    @DisplayName("차 이름을 반환한다.")
    void getCarName() {
        CarName actual = car.getCarName();
        CarName expect = new CarName("Audi");
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("차의 이동 거리를 반환한다.")
    void geDistance() {
        Distance actual = car.getDistance();
        Distance expect = new Distance(0);
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({"true, 1", "false, 0"})
    @DisplayName("차를 달리게 하면 distatnce가 1 증가한다.")
    void GetCarNameAndDistance(boolean movement, int expectedDistance) {
        Car movedCar = car.moveOn(movement);
        Distance actualMovedDistance = movedCar.getDistance();
        Distance expectedMovedDistance = new Distance(expectedDistance);
        assertThat(actualMovedDistance).isEqualTo(expectedMovedDistance);
    }

    @ParameterizedTest
    @DisplayName("가장 먼 거리를 간 차 이름(들)을 반환한다")
    @CsvSource({"3, true", "2, true", "1, false"})
    void hasLongestDistance(int distance, boolean expectedMovingLongestDistance) {
        Car audi = new Car("Audi", distance);
        Car bmw = new Car("BMW", 2);
        Car benz = new Car("Benz", 2);
        boolean actualMovingLongestDistance = audi.hasLongestDistance(Arrays.asList(audi, bmw, benz));
        assertThat(actualMovingLongestDistance).isEqualTo(expectedMovingLongestDistance);
    }
}
