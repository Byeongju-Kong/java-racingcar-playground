package model;

import model.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    @Test
    @DisplayName("경주한 차들을 받아 가장 먼 거리를 달린 차들의 이름을 반환한다")
    void findWinners() {
        Referee referee = new Referee();
        Car firstCar = new Car("a", 1);
        Car secondCar = new Car("b", 2);
        Car thirdCar = new Car("c", 2);

        List<String> actualWinners = referee.findWinners(Arrays.asList(firstCar, secondCar, thirdCar));
        List<String> expectedWinners = Arrays.asList("b", "c");

        assertThat(actualWinners).isEqualTo(expectedWinners);
    }
}