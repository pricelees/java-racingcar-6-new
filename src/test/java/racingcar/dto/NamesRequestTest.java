package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NamesRequestTest {
    @DisplayName("입력된 이름 리스트에 대한 예외 발생 확인")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideArguments")
    void constructor_WithInvalidName_ThrowsException(String testName, List<String> input) {
        assertThatThrownBy(() -> new NamesRequest(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름");
    }

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                arguments("이름이 5글자를 초과하는 경우", Arrays.asList("abcdef", "pobi", "woni")),
                arguments("이름에 null이 있는 경우", Arrays.asList(null, "pobi", "woni")),
                arguments("이름이 빈 값인 경우", Arrays.asList("", "pobi", "woni"))
        );
    }
}