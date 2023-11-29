package racingcar.domain;

import java.util.List;
import racingcar.util.CarsConverter;

public record Cars(List<Car> racingCars) {
    public static Cars valueOf(List<String> carNames) {
        return new Cars(CarsConverter.convert(carNames));
    }

    public int calculateMaxLocation() {
        return racingCars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }
}
