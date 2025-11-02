package lotto.domain.generator;

import java.util.Arrays;
import java.util.List;

import static lotto.common.Constants.NUMBER_DELIMITER;

public class ManualNumberGenerator implements NumberGenerator {
    private List<Integer> numbers;

    public ManualNumberGenerator(String numbers) {
        this.numbers = validateNumbers(numbers);
    }

    public List<Integer> generateNumbers() {
        return numbers;
    }

    private List<Integer> validateNumbers(String numbers) {
        if (numbers.isEmpty()) { throw new IllegalArgumentException("빈 값은 입력할 수 없습니다."); }
        List<Integer> numberList;
        try {
            numberList = Arrays.stream(numbers.split(NUMBER_DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("쉽표 이외의 문자는 입력할 수 없습니다.");
        }
        return numberList;
    }
}
