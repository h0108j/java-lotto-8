package lotto.view;

import lotto.DTO.LottoGenerateResult;
import lotto.DTO.LottoWinningResult;

import java.util.List;

public interface OutputView {
    void printPurchasePriceMessage();
    void printErrorMessage(String message);
    void printLottoGenerateResult(LottoGenerateResult lottoGenerateResult);
    void printWinningNumberMessage();
    void printBonusNumberMessage();
    void printRankingCount(List<LottoWinningResult> lottoWinningResults);
    void printReturnRate(double returnRate);
}
