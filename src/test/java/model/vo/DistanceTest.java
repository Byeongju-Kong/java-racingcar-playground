package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {
    @Test
    @DisplayName("거리를 반환한다")
    void increaseAndGetDistance() {
        Distance distance = new Distance(3);
        int actual = distance.getDistance();
        int expect = 3;
        assertThat(actual).isEqualTo(expect);
    }
}
