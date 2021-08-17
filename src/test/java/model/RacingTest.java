package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingTest {
    @Test
    @DisplayName("자동차 이름의 개수가 3이 아니라면 예외를 발생시킨다.")
    void create_ExceptionByNotThreeCars() {
        assertThatThrownBy(() -> new Racing(new String[]{"Audi", "BMW", "Benz", "Volvo"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주차의 개수가 잘못되었습니다.");
    }

    @Test
    @DisplayName("자동차 이름의 개수가 3이 아니라면 예외를 발생시킨다.")
    void create_ExceptionByOverlappedCarNames() {
        assertThatThrownBy(() -> new Racing(new String[]{"Audi", "BMW", "Audi"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주차의 이름에 중복이 있습니다.");
    }

    @ParameterizedTest
    @DisplayName("랜덤")
    @MethodSource("provideMovementAndResult")
    void race(boolean[] randomMovement, int expectDistanceOfFirstCar, int expectDistanceOfSecondCar, int expectDistanceOfThirdCar) {
        Racing racing = new Racing(new String[]{"Audi", "BMW", "Benz"});
        racing.race(randomMovement);
        int actualDistanceOfFirstCar = racing.getRoundResult().get(0).getDistance();
        int actualDistanceOfSecondCar = racing.getRoundResult().get(1).getDistance();
        int actualDistanceOfThirdCar = racing.getRoundResult().get(2).getDistance();
        assertAll(
                () -> assertThat(actualDistanceOfFirstCar).isEqualTo(expectDistanceOfFirstCar),
                () -> assertThat(actualDistanceOfSecondCar).isEqualTo(expectDistanceOfSecondCar),
                () -> assertThat(actualDistanceOfThirdCar).isEqualTo(expectDistanceOfThirdCar)
        );
    }

    private static Stream<Arguments> provideMovementAndResult() {
        return Stream.of(
                Arguments.of(new boolean[]{true, true, true}, 1, 1, 1),
                Arguments.of(new boolean[]{true, false, true}, 1, 0, 1),
                Arguments.of(new boolean[]{false, true, false}, 0, 1, 0),
                Arguments.of(new boolean[]{false, false, false}, 0, 0, 0)
        );
    }

    @Test
    @DisplayName("세 개의 경주차 중 가장 먼 거리를 간 차를 찾는다.")
    void findLongestDistanceCar() {
        Racing racing = new Racing(new String[]{"Audi", "BMW", "Benz"});
        racing.race(new boolean[]{true, false, true});
        assertAll(
                () -> assertThat(racing.findLongestDistanceCar().get(0).getCarName()).isEqualTo("Audi"),
                () -> assertThat(racing.findLongestDistanceCar().get(1).getCarName()).isEqualTo("Benz")
        );
        racing.race(new boolean[]{true, false, false});
        assertThat(racing.findLongestDistanceCar().get(0).getCarName()).isEqualTo("Audi");
    }
}