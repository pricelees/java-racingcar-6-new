package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarLocationTest {
    @DisplayName("생성자에서의 음수값 입력에 대한 예외 발생 확인")
    @Test
    void constructor_WithNegativeInput_ThrowsException() {
        assertThatThrownBy(() -> new CarLocation(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수");
    }

    @DisplayName("위치값을 기준으로 동등성을 판단하는지 확인")
    @Test
    void equalsAndHashCode() {
        CarLocation carLocation = new CarLocation(1);
        CarLocation carLocation1 = new CarLocation(1);
        assertEquals(carLocation, carLocation1);
        assertEquals(carLocation.hashCode(), carLocation1.hashCode());
    }

}