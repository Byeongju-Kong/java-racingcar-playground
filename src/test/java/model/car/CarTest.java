package model.car;

import model.vo.CarName;
import model.vo.Distance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {
    @ParameterizedTest
    @CsvSource({"true, 1", "false, 0"})
    @DisplayName("차를 달리게 하면 distatnce가 1 증가한다.")
    void GetCarNameAndDistance(boolean movement, int expectedDistance) {
        Car car = new Car("Audi", 0);
        car = car.moveOn(movement);
        CarName actualCarName = car.getCarName();
        Distance actualDistance = car.getDistance();

        assertAll(
                () -> assertThat(actualCarName).isEqualTo(new CarName("Audi")),
                () -> assertThat(actualDistance).isEqualTo(new Distance(expectedDistance))
        );
    }

    @ParameterizedTest
    @DisplayName("가장 먼 거리를 간 차 이름(들)을 반환한다")
    @CsvSource({"3, true", "2, true", "1, false"})
    void hasLongestDistance(int distance, boolean expect) {
        Car audi = new Car("Audi", distance);
        Car bmw = new Car("BMW", 2);
        Car benz = new Car("Benz", 2);
        assertThat(audi.hasLongestDistance(Arrays.asList(audi, bmw, benz))).isEqualTo(expect);
    }
}
