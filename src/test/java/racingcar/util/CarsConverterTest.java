package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarsConverterTest {

    @DisplayName("차량의 이름을 받아 모두 위치가 0인 차량 리스트로 정확히 변환하는지 확인")
    @Test
    void convert() {
        List<String> names = List.of("pobi", "woni", "jun");
        List<Car> expected = List.of(
                Car.valueOf("pobi", 0),
                Car.valueOf("woni", 0),
                Car.valueOf("jun", 0)
        );

        assertThat(CarsConverter.convert(names)).isEqualTo(expected);
    }
}