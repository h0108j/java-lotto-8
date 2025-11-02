package lotto.view;

import lotto.DTO.LottoDTO;
import lotto.DTO.LottoGenerateResult;
import lotto.DTO.LottoWinningResult;

import java.util.List;

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

    public void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printRankingCount(List<LottoWinningResult> lottoWinningResults) {
        for (LottoWinningResult result : lottoWinningResults) {
            System.out.printf("%d개 일치", result.getMatchCount());
            if (result.isBonusMatched()) { System.out.print(", 보너스 볼 일치"); }
            System.out.printf(" (%,d원) - %d개\n", result.getPrize(), result.getWinningCount());
        }
    }

    public void printReturnRate(double returnRate) {
        System.out.println("총 수익률은 " +  String.format("%.1f", returnRate) + "%입니다.");
    }
}
