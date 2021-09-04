package model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @ParameterizedTest
    @DisplayName("5자를 넘는 문자열로 CarName을 생성하면 오류를 발생시킨다")
    @ValueSource(strings = {"Carnival", "Sonata"})
    void create_ExceptionByLongerNameThanFive(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 5글자보다 길 수 없습니다");
    }

    @ParameterizedTest
    @DisplayName("getCarName()으로 차 이름을 반환한다.")
    @CsvSource({"Audi, Audi", "BMW, BMW"})
    void getCarName(String givenCarName, String expect) {
        CarName carName = new CarName(givenCarName);
        String actual = carName.getCarName();
        assertThat(actual).isEqualTo(expect);
    }
}
