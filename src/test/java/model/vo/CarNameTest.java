package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("5자를 넘는 문자열로 CarName을 생성하면 오류를 발생시킨다")
    void create_ExceptionByLongerNameThanFive() {
        assertThatThrownBy(() -> new CarName("Sonata"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 5글자보다 길 수 없습니다");
    }

    @Test
    @DisplayName("앞뒤 공백을 제외하고 차 이름에 공백이 있으면 예외를 발생시킨다.")
    void create_ExceptionByFirstSpaceOrWholeSpace() {
        assertThatThrownBy(() -> new CarName("Ben z"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름엔 공백이 포함될 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("getCarName()으로 차 이름을 반환한다.")
    @CsvSource({"Audi, Audi", "BMW, BMW"})
    void getCarName(String givenCarName, String expect) {
        CarName carName = new CarName(givenCarName);
        String actual = carName.getValue();
        assertThat(actual).isEqualTo(expect);
    }
}
