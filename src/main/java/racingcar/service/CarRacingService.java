package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.constants.Constants;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarResponse;
import racingcar.dto.NamesRequest;
import racingcar.dto.RacingWinnerResponse;

public class CarRacingService {
    public Cars createCars(NamesRequest namesRequest) {
        return Cars.valueOf(namesRequest.carNames());
    }

    public List<CarResponse> moveAllCarOnce(Cars cars) {
        return cars.racingCars().stream()
                .map(car -> {
                    car.moveForward(Randoms.pickNumberInRange(Constants.MIN_MOVE_NUMBER, Constants.MAX_MOVE_NUMBER));
                    return new CarResponse(car.getName(), car.getLocation());
                })
                .toList();
    }

    public RacingWinnerResponse findWinners(Cars cars) {
        int maxLocation = cars.calculateMaxLocation();
        List<String> winnerNames = cars.racingCars().stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();

        return new RacingWinnerResponse(winnerNames);
    }
}
