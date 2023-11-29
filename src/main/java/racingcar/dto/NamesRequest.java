package racingcar.dto;

import java.util.List;
import racingcar.constants.Constants;

public record NamesRequest(List<String> carNames) {
    private static final String CONTAINS_INVALID_LENGTH = "[ERROR] 유효하지 않은 길이의 이름이 포함되어 있습니다.";
    public NamesRequest {
        validate(carNames);
    }

    private void validate(List<String> carNames) {
        if (hasInvalidNameLength(carNames)) {
            throw new IllegalArgumentException(CONTAINS_INVALID_LENGTH);
        }
    }

    private boolean hasInvalidNameLength(List<String> carNames) {
        return carNames.stream()
                .anyMatch(name -> name == null
                        || name.length() > Constants.MAX_CAR_NAME_LENGTH
                        || name.isBlank());
    }
}
