package lotto.DTO;

public class LottoWinningResult {
    private int matchCount;
    private int prize;
    private int winningCount;
    private boolean bonusMatched;

    public LottoWinningResult(int matchCount, int prize, int winningCount,  boolean bonusMatched) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.winningCount = winningCount;
        this.bonusMatched = bonusMatched;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }
}
