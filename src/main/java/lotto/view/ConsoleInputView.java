package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInputView implements InputView {
    @Override
    public String read() {
        return readLine();
    }
}
