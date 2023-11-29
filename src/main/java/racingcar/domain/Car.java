package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int THRESHOLD_FOR_MOVE = 4;
    private final CarName name;
    private final CarLocation location;

    private Car(CarName name, CarLocation location) {
        this.name = name;
        this.location = location;
    }

    public static Car valueOf(String name, int location) {
        return new Car(new CarName(name), new CarLocation(location));
    }

    public void moveForward(int number) {
        if (number >= THRESHOLD_FOR_MOVE) {
            location.increaseLocation();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location.getLocation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) && Objects.equals(getLocation(),
                car.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation());
    }
}
