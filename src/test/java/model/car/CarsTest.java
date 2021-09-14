package model.car;

import model.movement.Movement;
import model.movement.RandomMovement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsTest {
    private Cars cars;
    private Movement movement;
    private int randomIndex = 0;
    boolean[] randomMovements = new boolean[]{true, false, true};

    @BeforeEach
    void setUp() {
        cars = new Cars(new String[]{"Audi", "Benz", "BMW"});
        movement = new RandomMovement() {
            @Override
            public boolean generateRandom() {
                return randomMovements[randomIndex++];
            }
        };
    }

    @Test
    @DisplayName("랜덤 이동 여부를 받아 차들을 이동시킨다.")
    void race() {
        List<Car> movedCars = cars.race(movement);
        assertAll(
                () -> assertThat(movedCars.get(0).getDistance()).isEqualTo(1),
                () -> assertThat(movedCars.get(1).getDistance()).isZero(),
                () -> assertThat(movedCars.get(2).getDistance()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("가장 멀리 이동한 차들을 반환한다.")
    void findLongestDistanceCars() {
        randomIndex = 0;
        Cars racedCars = new Cars(cars.race(movement));
        List<Car> LongestCars = racedCars.findLongestDistanceCars();
        assertAll(
                () -> assertThat(LongestCars.get(0).getCarName()).isEqualTo("Audi"),
                () -> assertThat(LongestCars.get(1).getCarName()).isEqualTo("BMW")
        );
    }
}