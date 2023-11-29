package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarResponse;
import racingcar.dto.RacingWinnerResponse;

class CarRacingServiceTest {
    CarRacingService carRacingService = new CarRacingService();

    @DisplayName("모든 차량을 정확하게 전진하는지 확인")
    @Test
    void moveAllCarOnce() {
        Cars cars = Cars.valueOf(List.of("pobi", "woni", "jun"));

        // pobi는 정지, woni, jun은 1칸 전진하도록 설정
        List<CarResponse> actual = run(cars, 1, 4, 9);

        List<CarResponse> expected = List.of(
                new CarResponse("pobi", 0),
                new CarResponse("woni", 1),
                new CarResponse("jun", 1)
        );

        assertThat(actual).isEqualTo(expected);
    }

    private List<CarResponse> run(Cars cars, Integer value, Integer... values) {
        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(0, 9))
                .thenReturn(value, Arrays.stream(values).toArray());

        return carRacingService.moveAllCarOnce(cars);
    }

    @DisplayName("우승자를 정확히 찾아내는지 확인")
    @Test
    void findWinners() {
        Cars cars = new Cars(List.of(
                Car.valueOf("pobi", 3),
                Car.valueOf("woni", 3),
                Car.valueOf("jun", 2)
        ));

        assertThat(carRacingService.findWinners(cars))
                .isEqualTo(new RacingWinnerResponse(List.of("pobi", "woni")));
    }
}