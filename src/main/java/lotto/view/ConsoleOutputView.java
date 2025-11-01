package lotto.view;

import lotto.DTO.LottoDTO;
import lotto.DTO.LottoGenerateResult;

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

    public void printRankingCount(List<Integer> rankings) {
        System.out.println("3개 일치 (5,000원) - " +  rankings.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " +  rankings.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " +  rankings.get(2) + "개");
        System.out.println("5개 일치, 보너스 불 일치 (30,000,000원) - " +  rankings.get(1) + "개");
        System.out.println("6개 일치 (20,000,000원) - " +  rankings.get(0) + "개");
    }
}
