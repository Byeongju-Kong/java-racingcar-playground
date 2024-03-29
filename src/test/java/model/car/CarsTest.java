package model.car;

import model.movement.MovementStrategy;
import model.movement.RandomMovement;
import model.vo.CarName;
import model.vo.Distance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsTest {
    private MovementStrategy movement;
    private int randomIndex = 0;
    boolean[] randomMovements = new boolean[]{true, false, true};

    @BeforeEach
    void setUp() {
        movement = new RandomMovement() {
            @Override
            public boolean generateMovement() {
                return randomMovements[randomIndex++];
            }
        };
    }

    @Test
    @DisplayName("랜덤 이동 여부를 받아 차들을 이동시킨다.")
    void race() {
        Cars cars = new Cars(new String[]{"Audi", "Benz", "BMW"});
        List<Car> movedCars = cars.race(movement);
        assertAll(
                () -> assertThat(movedCars.get(0).getDistance()).isEqualTo(new Distance(1)),
                () -> assertThat(movedCars.get(1).getDistance()).isEqualTo(new Distance(0)),
                () -> assertThat(movedCars.get(2).getDistance()).isEqualTo(new Distance(1))
        );
    }

    @Test
    @DisplayName("가장 멀리 이동한 차들을 반환한다.")
    void findLongestDistanceCars() {
        randomIndex = 0;
        Cars cars = new Cars(new String[]{"Audi", "Benz", "BMW"});
        Cars movedCars = new Cars(cars.race(movement));
        List<Car> LongestCars = movedCars.findLongestDistanceCars();
        assertAll(
                () -> assertThat(LongestCars.get(0).getCarName()).isEqualTo(new CarName("Audi")),
                () -> assertThat(LongestCars.get(1).getCarName()).isEqualTo(new CarName("BMW"))
        );
    }
}