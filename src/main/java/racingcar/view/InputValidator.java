package racingcar.view;

public class InputValidator {
    public static class NameValidator {
        private static final String INVALID_FORMAT = "[ERROR] 입력 형식이 올바르지 않습니다.";
        private static final String NAMES_REGEX = "([A-Za-z0-9]{1,5})(,[A-Za-z0-9]{1,5})*";

        public static void validateFormat(String input) {
            if (isInvalidFormat(input)) {
                throw new IllegalArgumentException(INVALID_FORMAT);
            }
        }

        private static boolean isInvalidFormat(String input) {
            return !input.matches(NAMES_REGEX);
        }
    }

    public static class CountValidator {
        private static final String COUNT_REGEX = "[0-9]+";
        private static final String NOT_NUMBER_ERROR = "[ERROR] 회수는 숫자만 가능합니다.";

        public static void validateFormat(String input) {
            if (isInvalidFormat(input)) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR);
            }
        }

        private static boolean isInvalidFormat(String input) {
            return !input.matches(COUNT_REGEX);
        }
    }
}
