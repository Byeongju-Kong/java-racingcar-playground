package model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(new String[]{"Audi", "Benz", "BMW"});
    }

    @Test
    @DisplayName("랜덤 이동 여부를 받아 차들을 이동시킨다.")
    void race() {
        List<Car> movedCars = cars.race(new boolean[]{true, true, false});
        assertAll(
                () -> assertThat(movedCars.get(0).getDistance()).isEqualTo(1),
                () -> assertThat(movedCars.get(1).getDistance()).isEqualTo(1),
                () -> assertThat(movedCars.get(2).getDistance()).isZero()
        );
    }

    @Test
    @DisplayName("가장 멀리 이동한 차들을 반환한다.")
    void findLongestDistanceCars() {
        Cars racedCars = new Cars(cars.race(new boolean[]{true, true, false}));
        List<Car> LongestCars = racedCars.findLongestDistanceCars();
        assertAll(
                () -> assertThat(LongestCars.get(0).getCarName()).isEqualTo("Audi"),
                () -> assertThat(LongestCars.get(1).getCarName()).isEqualTo("Benz")
        );
    }
}