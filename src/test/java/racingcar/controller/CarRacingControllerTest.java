package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import racingcar.config.Configuration;

class CarRacingControllerTest {
    @DisplayName("게임을 정확하게 실행하는지 확인")
    @Test
    void run_test() {
        command("pobi,woni,jun", "3");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // 1라운드에선 woni만 전진
        // 2라운드에선 jun만 전진
        // 3라운드에선 모두 전진
        run(
                0, 9, 1,
                2, 3, 5,
                4, 6, 7
        );

        assertThat(out.toString()).contains(
                "pobi : ",
                "woni : -",
                "jun : ",

                "pobi : ",
                "woni : -",
                "jun : -",

                "pobi : -",
                "woni : --",
                "jun : --",
                "최종 우승자 : woni, jun"
        );
    }

    @DisplayName("이름에 대한 예외 처리 확인")
    @ParameterizedTest(name = "{0}")
    @CsvSource(value = {
            "구분자가 쉼표가 아닌경우/pobi:woni:jun",
            "이름이 빈 값인경우/pobi,woni,",
            "이름의 길이가 초과인경우/pobi123,woni,jun"
    }, delimiter = '/')
    void run_WithInvalidNames_ThrowsException(String testName, String input) {
        command(input, "3");
        assertThatThrownBy(this::run)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진 횟수에 대한 예외 처리 확인")
    @ParameterizedTest(name = "{0}")
    @CsvSource(value = {
            "음수가 입력된 경우/-1",
            "문자가 입력된 경우/a",
    }, delimiter = '/')
    void run_WithInvalidCount_ThrowsException(String testName, String input) {
        command("pobi,woni,jun", input);
        assertThatThrownBy(this::run)
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        Console.close();
    }

    private void run(Integer value, Integer... values) {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(value, Arrays.stream(values).toArray());
            CarRacingController carRacingController = Configuration.carRacingController();
            carRacingController.run();
        }
    }

    private void run() {
        CarRacingController carRacingController = Configuration.carRacingController();
        carRacingController.run();
    }
}