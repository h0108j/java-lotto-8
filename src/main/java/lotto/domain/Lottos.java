package lotto.domain;

import lotto.domain.factory.LottoFactory;
import lotto.domain.generator.RandomNumberGenerator;
import lotto.validation.BonusNumberValidator;
import lotto.validation.Validator;

import java.util.*;

import static lotto.common.Constants.LOTTO_UNIT_PRICE;

public class Lottos {
    private static int purchasePrice;
    private static List<Lotto> lottos;
    private static Map<LottoRank, Integer> rankCounts;
    private Lotto winningNumber;
    private int bonusNumber;

    private LottoFactory lottoFactory;

    public Lottos(int purchasePrice) {
        this.lottoFactory = new LottoFactory(new RandomNumberGenerator());
        this.purchasePrice = purchasePrice;
    }

    public void generateLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < calculatePurchaseCount(); i++) {
            lottos.add(lottoFactory.createLotto());
        }
    }

    public void addWinningNumbers(Lotto winningNumbers) {
        this.winningNumber = winningNumbers;
    }

    public void addBonusNumber(String bonusNumber) {
        Validator validator = new BonusNumberValidator(winningNumber);
        validator.validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public Map<LottoRank, Integer> calculateEachResult() {
        lottos.stream()
                .forEach(lotto -> lotto.calulateMatchResult(winningNumber.getSortedNumbers(), bonusNumber));

        List<LottoRank> results = lottos.stream()
                .map(Lotto::calculateRanking)
                .toList();

        rankCounts = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            int count = (int) results.stream()
                    .filter(result -> result == rank)
                    .count();
            rankCounts.put(rank, count);
        }

        return rankCounts;
    }

    public double calculateReturnRate() {
        double totalPrize = 0;
        for (LottoRank rankCount : rankCounts.keySet()) {
            totalPrize += rankCounts.get(rankCount) * rankCount.getPrize();
        }
        return (totalPrize / purchasePrice) * 100;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int calculatePurchaseCount() {
        return purchasePrice / LOTTO_UNIT_PRICE;
    }
}
