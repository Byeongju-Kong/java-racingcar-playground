package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingRoundTest {
    @Test
    @DisplayName("음수로 경주 횟수 객체를 생성하면 예외를 발생시킨다.")
    void create_ExceptionByNegativeNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingRound(-1))
                .withMessage("경주 횟수는 양수여야합니다.");
    }

    @ParameterizedTest
    @CsvSource({"2, true", "1, false"})
    @DisplayName("decreaseLeftRound로 남은 경주 횟수를 1씩 줄이고 isOver 메서드는 남은 경주횟수가 0이면 true를 반환한다.")
    void isOver(int racingTimes, boolean expect) {
        RacingRound racingRound = new RacingRound(2);
        for (int times = 0; times < racingTimes; times++) {
            racingRound.decreaseLeftRound();
        }
        assertThat(racingRound.isOver()).isEqualTo(expect);
    }

}