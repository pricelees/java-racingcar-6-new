package racingcar.domain;

import java.util.Objects;
import racingcar.constants.Constants;

public class CarName {
    private static final String INVALID_LENGTH = "[ERROR] 유효하지 않은 이름 길이입니다.";
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank() || name.length() > Constants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(getName(), carName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
