package lotto.domain;

import java.util.Arrays;

import static lotto.common.Constants.LOTTO_UNIT_COUNT;

public enum LottoRank {
    FIRST(LOTTO_UNIT_COUNT, false, 2_000_000_000),
    SECOND(LOTTO_UNIT_COUNT - 1, true, 30_000_000),
    THIRD(LOTTO_UNIT_COUNT - 1, false, 1_500_000),
    FOURTH(LOTTO_UNIT_COUNT - 2, false, 50_000),
    FIFTH(LOTTO_UNIT_COUNT - 3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean bonus;
    private final int prize;

    LottoRank(int matchCount, boolean bonus, int prize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static LottoRank from(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> isMatch(rank, matchCount, bonus))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isMatch(LottoRank rank, int matchCount, boolean bonus) {
        if (matchCount == LOTTO_UNIT_COUNT - 1) {
            return rank.matchCount == matchCount && rank.bonus == bonus;
        }
        return rank.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonus() {
        return bonus;
    }

    public int getPrize() {
        return prize;
    }
}
