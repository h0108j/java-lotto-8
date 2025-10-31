package lotto.validation;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.common.Constants.*;

public class LottoValidator implements Validator<List<Integer>> {
    @Override
    public void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_UNIT_COUNT) {
            throw new InvalidParameterException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> seen = new HashSet<>(numbers);
        if (seen.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복 입력할 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number > LOTTO_END_INCLUSIVE || number < LOTTO_START_INCLUSIVE) {
                throw new IllegalArgumentException("로또 숫자의 범위는 " + LOTTO_START_INCLUSIVE + "에서 " +  LOTTO_END_INCLUSIVE + " 사이입니다.");
            }
        });
    }
}
