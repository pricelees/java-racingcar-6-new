package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @DisplayName("가장 많이 전진한 자동차의 위치값을 정확히 찾아내는지 확인")
    @Test
    void calculateMaxLocation() {
        Cars cars = new Cars(List.of(
                Car.valueOf("pobi", 3),
                Car.valueOf("woni", 2),
                Car.valueOf("jun", 1)
        ));

        int expected = 3;
        assertThat(cars.calculateMaxLocation()).isEqualTo(expected);
    }
}