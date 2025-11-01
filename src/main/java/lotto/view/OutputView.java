package lotto.view;

import lotto.DTO.LottoGenerateResult;

import java.util.List;

public interface OutputView {
    void printPurchasePriceMessage();
    void printErrorMessage(String message);
    void printLottoGenerateResult(LottoGenerateResult lottoGenerateResult);
    void printWinningNumberMessage();
    void printBonusNumberMessage();
    void printRankingCount(List<Integer> rankings);
}
