package racingcar.view;

import java.util.List;
import racingcar.dto.CarResponse;
import racingcar.dto.RacingWinnerResponse;

public class CarOutputView {
    private static final String RESULT = "실행 결과";
    private static final String COLON_WITH_SPACE = " : ";
    private static final String DASH = "-";
    private static final String WINNER = "최종 우승자";
    private static final String WINNER_DELIMITER = ", ";

    public void printWinners(RacingWinnerResponse racingWinnerResponse) {
        String winners = String.join(WINNER_DELIMITER, racingWinnerResponse.carNames());
        System.out.println(WINNER + COLON_WITH_SPACE + winners);
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT);
    }

    public void printEachRoundResult(List<CarResponse> carResponses) {
        carResponses.forEach(this::printOneCarStatus);
        System.out.println();
    }

    private void printOneCarStatus(CarResponse carResponse) {
        System.out.println(carResponse.name() + COLON_WITH_SPACE + DASH.repeat(carResponse.location()));
    }
}
