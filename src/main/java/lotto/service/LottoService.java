package lotto.service;

import lotto.DTO.LottoDTO;
import lotto.DTO.LottoGenerateResult;
import lotto.DTO.LottoWinningResult;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.factory.LottoFactory;
import lotto.domain.factory.LottosFactory;
import lotto.domain.generator.ManualNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.MISS;

public class LottoService {
    public Lottos createLottos(String purchasePrice) {
        LottosFactory lottosFactory = new LottosFactory();
        return lottosFactory.createLottos(purchasePrice);
    }

    public LottoGenerateResult buildLottoGenerateResult(Lottos lottos) {
        List<LottoDTO> lottoDTOs = lottos.getLottos().stream()
                .map(lotto -> new LottoDTO(lotto.getSortedNumbers()))
                .toList();
        return new LottoGenerateResult(lottos.calculatePurchaseCount(), lottoDTOs);
    }

    public boolean createWinningNumbers(String winningNumbers, Lottos lottos) {
        LottoFactory lottoFactory = new LottoFactory(new ManualNumberGenerator(winningNumbers));
        lottos.addWinningNumbers(lottoFactory.createLotto());
        return true;
    }

    public boolean createBonusNumber(String bonusNumber, Lottos lottos) {
        lottos.addBonusNumber(bonusNumber);
        return true;
    }

    public List<LottoWinningResult> calculateLottoWinningResult(Lottos lottos) {
        Map<LottoRank, Integer> rankCounts = lottos.calculateEachResult();
        List<LottoWinningResult> lottoWinningResults = new ArrayList<>();
        for (LottoRank rank : LottoRank.values()) {
            if (rank == MISS) break;
            lottoWinningResults
                    .add(new LottoWinningResult(rank.getMatchCount(), rank.getPrize(), rankCounts.get(rank), rank.getBonus()));
        }
        Collections.reverse(lottoWinningResults);
        return lottoWinningResults;
    }

    public double calculateReturnRate(Lottos lottos) {
        return lottos.calculateReturnRate();
    }
}
