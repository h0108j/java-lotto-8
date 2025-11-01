package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int matchCount;
    private boolean isBonusMatched;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.matchCount = 0;
        this.isBonusMatched = false;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public void calulateMatchResult(List<Integer> winningNumbers, int bonusNumber) {
        matchCount = (int)numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        isBonusMatched = numbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }

    public LottoRank calculateRanking() {
        return LottoRank.from(matchCount, isBonusMatched);
    }
}
