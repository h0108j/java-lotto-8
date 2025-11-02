package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int matchCount;
    private boolean isBonusMatched;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void calculateMatchResult(List<Integer> winningNumbers, int bonusNumber) {
        matchCount = (int)numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        isBonusMatched = numbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }

    public LottoRank calculateRanking() {
        return LottoRank.from(matchCount, isBonusMatched);
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
