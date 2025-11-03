package lotto.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDTO {
    private List<Integer> numbers;

    public LottoDTO(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
