package lotto.view;

import lotto.DTO.LottoDTO;
import lotto.DTO.LottoGenerateResult;

public class ConsoleOutputView implements OutputView {
    public void printPurchasePriceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printLottoGenerateResult(LottoGenerateResult lottoGenerateResult) {
        System.out.println(lottoGenerateResult.getPurchaseCount() + "개를 구매했습니다.");
        lottoGenerateResult.getLottos().stream()
                .map(LottoDTO::getNumbers)
                .forEach(System.out::println);
    }

    public void printWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
