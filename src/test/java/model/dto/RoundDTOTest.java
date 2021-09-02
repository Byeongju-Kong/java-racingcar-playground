package model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundDTOTest {
    private RoundDTO roundDTO;
    @BeforeEach
    void setUp() {
        List<String> carNames = Arrays.asList("Audi", "Benz", "BMW");
        List<Integer> distances = Arrays.asList(1, 2, 3);
        roundDTO = new RoundDTO(carNames, distances);
    }

    @Test
    @DisplayName("RoundDTO 객체에 담긴 carNames를 반환한다.")
    void getCarNames() {
        List<String> expectedCarNames = Arrays.asList("Audi", "Benz", "BMW");
        List<String> actualCarNames = roundDTO.getCarNames();
        assertThat(expectedCarNames).isEqualTo(actualCarNames);
    }

    @Test
    @DisplayName("RoundDTO 객체에 담긴 distances를 반환한다")
    void getDistances() {
        List<Integer> expectedCarNames = Arrays.asList(1, 2, 3);
        List<Integer> actualCarNames = roundDTO.getDistances();
        assertThat(expectedCarNames).isEqualTo(actualCarNames);
    }
}