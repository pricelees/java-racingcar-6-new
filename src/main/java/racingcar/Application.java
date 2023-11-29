package racingcar;

import racingcar.config.Configuration;
import racingcar.controller.CarRacingController;

public class Application {
    public static void main(String[] args) {
        CarRacingController carRacingController = Configuration.carRacingController();
        carRacingController.run();
    }
}
