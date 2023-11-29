package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("0부터 9까지의 모든 수를 이용하여 전진 여부를 확인")
    @Test
    void moveForward() {
        Car car = Car.valueOf("pobi", 0);
        for (int i = 0; i <= 9; i++) {
            car.moveForward(i);
        }
        // 0부터 9까지의 모든 수를 넣고 전진시키면 6번 전진 해야함.
        Car expected = Car.valueOf("pobi", 6);

        assertThat(car).isEqualTo(expected);
    }
}