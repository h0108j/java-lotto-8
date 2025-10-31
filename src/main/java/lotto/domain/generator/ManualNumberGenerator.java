package lotto.domain.generator;

import java.util.List;

public class ManualNumberGenerator implements NumberGenerator {
    private List<Integer> numbers;

    public ManualNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> generateNumbers() {
        return numbers;
    }
}
