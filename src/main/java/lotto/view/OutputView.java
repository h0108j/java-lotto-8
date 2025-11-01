package lotto.view;

import lotto.DTO.LottoGenerateResult;

public interface OutputView {
    void printPurchasePriceMessage();
    void printErrorMessage(String message);
    void printLottoGenerateResult(LottoGenerateResult lottoGenerateResult);
    void printWinningNumberMessage();
}
