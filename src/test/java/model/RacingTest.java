package model;

import model.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingTest {
    @Test
    @DisplayName("자동차 이름의 개수에 중복이 있다면 예외를 발생시킨다.")
    void create_ExceptionByOneCar() {
        assertThatThrownBy(() -> new Racing(new String[]{"Audi"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주차는 적어도 2개가 필요합니다.");
    }

    @Test
    @DisplayName("자동차 이름의 개수에 중복이 있다면 예외를 발생시킨다.")
    void create_ExceptionByOverlappedCarNames() {
        assertThatThrownBy(() -> new Racing(new String[]{"Audi", "BMW", "Audi"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주차의 이름에 중복이 있습니다.");
    }

    @Test
    @DisplayName("랜덤한 이동여부를 받아 경주차들을 전진시킨다.")
    void race() {
        Racing racing = new Racing(new String[]{"Audi", "BMW", "Benz"});
        racing.race(new boolean[]{true, false, true});
        List<Car> racedCars = racing.getRacedResult();
        assertAll(
                () -> assertThat(racedCars.get(0).getDistance()).isEqualTo(1),
                () -> assertThat(racedCars.get(1).getDistance()).isZero(),
                () -> assertThat(racedCars.get(2).getDistance()).isEqualTo(1)
        );
    }
}