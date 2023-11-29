package racingcar.config;

import racingcar.controller.CarRacingController;
import racingcar.service.CarRacingService;
import racingcar.view.CarInputView;
import racingcar.view.CarOutputView;
import racingcar.view.Reader;

public class Configuration {
    public static CarRacingController carRacingController() {
        return new CarRacingController(carRacingService(), carInputView(), carOutputView());
    }

    private static CarRacingService carRacingService() {
        return new CarRacingService();
    }

    private static CarInputView carInputView() {
        return new CarInputView(reader());
    }

    private static CarOutputView carOutputView() {
        return new CarOutputView();
    }

    private static Reader reader() {
        return new Reader();
    }
}
