package lotto.domain;

import java.util.Arrays;

import static lotto.common.Constants.LOTTO_UNIT_COUNT;

public enum LottoRank {
    FIRST(LOTTO_UNIT_COUNT, false),
    SECOND(LOTTO_UNIT_COUNT - 1, true),
    THIRD(LOTTO_UNIT_COUNT - 1, false),
    FOURTH(LOTTO_UNIT_COUNT - 2, false),
    FIFTH(LOTTO_UNIT_COUNT - 3, false),
    MISS(0, false);

    private final int matchCount;
    private final boolean bonus;

    LottoRank(int matchCount, boolean bonus) {
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public static LottoRank from(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.bonus == bonus)
                .findFirst()
                .orElse(MISS);
    }
}
