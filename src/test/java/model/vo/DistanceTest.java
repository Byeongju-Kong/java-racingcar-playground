package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DistanceTest {
    @Test
    @DisplayName("거리를 반환한다")
    void increaseAndGetDistance() {
        Distance distance = new Distance(3);
        int actual = distance.getValue();
        int expect = 3;
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("0보다 작은 값으로 객체를 생성하면 예외를 발생시킨다.")
    void create_ExceptionByLessThanZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Distance(-1))
                .withMessage("이동 거리는 0보다 작을 수 없습니다.");
    }
}
