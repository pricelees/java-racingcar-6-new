package racingcar.domain;

import java.util.Objects;
import racingcar.constants.Constants;

public class CarLocation {
    private static final String NEGATIVE_LOCATION = "[ERROR] 차량의 위치는 음수일 수 없습니다.";
    private int location;

    public CarLocation(int location) {
        validate(location);
        this.location = location;
    }

    private void validate(int location) {
        if (location < Constants.ZERO) {
            throw new IllegalArgumentException(NEGATIVE_LOCATION);
        }
    }

    public void increaseLocation() {
        location++;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarLocation that = (CarLocation) o;
        return getLocation() == that.getLocation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation());
    }
}
