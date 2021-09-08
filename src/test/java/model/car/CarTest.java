package model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {
    @Test
    @DisplayName("차를 달리게 하고 달린 거리를 반환한다")
    void GetCarNameAndDistance() {
        Car car = new Car("Audi", 1);
        String actualCarName = car.getCarName();
        int actualDistance = car.getDistance();

        assertAll(
                () -> assertThat(actualCarName).isEqualTo("Audi"),
                () -> assertThat(actualDistance).isEqualTo(1)
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
