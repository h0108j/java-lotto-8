package lotto.domain;

import lotto.domain.factory.LottoFactory;
import lotto.domain.generator.RandomNumberGenerator;
import lotto.validation.BonusNumberValidator;
import lotto.validation.Validator;

import java.util.*;

import static lotto.common.Constants.LOTTO_UNIT_PRICE;

public class Lottos {
    private LottoFactory lottoFactory;

    private static int purchasePrice;
    private static int purchaseCount;

    private static List<Lotto> lottos;
    private static List<Integer> rankCounts;
    private Lotto winningNumber;
    private int bonusNumber;

    public Lottos(int purchasePrice) {
        this.lottoFactory = new LottoFactory(new RandomNumberGenerator());
        this.purchasePrice = purchasePrice;
        this.purchaseCount = purchasePrice / LOTTO_UNIT_PRICE;
        this.bonusNumber = 0;
        this.rankCounts = new ArrayList<>();
    }

    public void generateLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(lottoFactory.createLotto());
        }
    }

    public void addWinningNumber(Lotto winningNumber, String bonusNumber) {
        this.winningNumber = winningNumber;
        Validator validator = new BonusNumberValidator(winningNumber);
        validator.validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> calculateEachResult() {
        lottos.stream()
                .forEach(lotto -> lotto.calulateMatchResult(winningNumber.getSortedNumbers(), bonusNumber));

        List<LottoRank> results = lottos.stream()
                .map(Lotto::calculateRanking)
                .toList();

        for (LottoRank rank : LottoRank.values()) {
            int count = (int) results.stream()
                    .filter(result -> result == rank)
                    .count();
            rankCounts.add(count);
        }

        return rankCounts;
    }

    public double calculateReturnRate() {
        double totalPrize = (LottoRank.FIRST.getPrize() * rankCounts.get(0)
                + LottoRank.SECOND.getPrize() * rankCounts.get(1)
                + LottoRank.THIRD.getPrize() * rankCounts.get(2)
                + LottoRank.FOURTH.getPrize() * rankCounts.get(3)
                + LottoRank.FIFTH.getPrize() * rankCounts.get(4));
        return (totalPrize / purchasePrice) * 100;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
