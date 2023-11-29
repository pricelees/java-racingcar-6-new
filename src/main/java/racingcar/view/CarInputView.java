package racingcar.view;

import java.util.List;
import racingcar.view.InputValidator.CountValidator;
import racingcar.view.InputValidator.NameValidator;

public class CarInputView {
    private final Reader reader;
    private static final String NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,)를 기준으로 구분)";
    private static final String COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

    public CarInputView(Reader reader) {
        this.reader = reader;
    }

    public List<String> receiveCarNames() {
        System.out.println(NAME_REQUEST_MESSAGE);
        String input = reader.readLine();
        NameValidator.validateFormat(input);

        return NamesConverter.convert(input);
    }

    public int receiveMoveCount() {
        System.out.println(COUNT_REQUEST_MESSAGE);
        String input = reader.readLine();
        CountValidator.validateFormat(input);

        return Integer.parseInt(input);
    }
}
