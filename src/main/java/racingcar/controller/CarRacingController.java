package racingcar.controller;

import java.util.List;
import racingcar.constants.Constants;
import racingcar.domain.Cars;
import racingcar.dto.CarResponse;
import racingcar.dto.NamesRequest;
import racingcar.dto.RacingWinnerResponse;
import racingcar.service.CarRacingService;
import racingcar.view.CarInputView;
import racingcar.view.CarOutputView;

public class CarRacingController {
    private final CarRacingService carRacingService;
    private final CarInputView carInputView;
    private final CarOutputView carOutputView;

    public CarRacingController(
            CarRacingService carRacingService,
            CarInputView carInputView,
            CarOutputView carOutputView
    ) {
        this.carRacingService = carRacingService;
        this.carInputView = carInputView;
        this.carOutputView = carOutputView;
    }

    public void run() {
        Cars cars = initializeCars();
        int moveCount = carInputView.receiveMoveCount();
        startRace(cars, moveCount);
        announceWinners(cars);
    }

    private void startRace(Cars cars, int moveCount) {
        carOutputView.printResultMessage();
        for (int i = Constants.ZERO; i < moveCount; i++) {
            List<CarResponse> result = carRacingService.moveAllCarOnce(cars);
            carOutputView.printEachRoundResult(result);
        }
    }

    private Cars initializeCars() {
        NamesRequest namesRequest = new NamesRequest(carInputView.receiveCarNames());

        return carRacingService.createCars(namesRequest);
    }

    private void announceWinners(Cars cars) {
        RacingWinnerResponse racingWinnerResponse = carRacingService.findWinners(cars);
        carOutputView.printWinners(racingWinnerResponse);
    }
}
