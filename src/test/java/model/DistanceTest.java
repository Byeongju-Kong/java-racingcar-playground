package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {
    private Distance distance;

    @BeforeEach
    void setUp() {
        distance = new Distance();
    }

    @Test
    @DisplayName("차가 움직이면 거리가 늘어나고 움직인 거리를 반환할 수 있다")
    void increaseAndGetDistance() {
        distance.increase();
        int actual = distance.getDistance();
        assertThat(actual).isEqualTo(1);
        distance.increase();
        actual = distance.getDistance();
        assertThat(actual).isEqualTo(2);
    }
}
