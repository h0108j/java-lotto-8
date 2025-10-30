package lotto.view;

public class ConsoleOutputView implements OutputView {
    public void printPurchasePriceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
