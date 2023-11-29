package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class CarsConverter {
    public static List<Car> convert(List<String> carNames) {
        return carNames.stream()
                .map(name -> Car.valueOf(name, 0))
                .toList();
    }
}