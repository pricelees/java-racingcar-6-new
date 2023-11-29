package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarNameTest {
    @DisplayName("유효하지 않은 이름 길이에 대한 예외 발생 확인")
    @ParameterizedTest(name = "{0}")
    @CsvSource(value = {"이름이 5글자를 초과하는 경우/abcdef", "이름의 입력값이 없는 경우/ "}, delimiter = '/')
    void constructor_WithInvalidNameLength_ThrowsException(String testName, String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 이름");
    }
}