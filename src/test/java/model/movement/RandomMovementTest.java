package model.movement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovementTest{
    @ParameterizedTest
    @DisplayName("랜덤한 boolean 값들을 생성한다.")
    @CsvSource({"true, true", "false, false"})
    void generateRandomMovements(boolean given, boolean taken) {
        Movement randomMovement = new RandomMovement() {
            @Override
            protected Boolean generateRandom() {
                return given;
            }
        };
        assertThat(randomMovement.generateRandomMovements(3)).isEqualTo(new boolean[]{taken, taken, taken});
    }
}