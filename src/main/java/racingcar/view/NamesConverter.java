package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class NamesConverter {
    private static final String NAME_DELIMITER = ",";

    public static List<String> convert(String input) {
        return Arrays.stream(input.split(NAME_DELIMITER))
                .toList();
    }
}
