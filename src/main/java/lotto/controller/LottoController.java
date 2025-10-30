package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.LottosFactory;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        this.inputView = new ConsoleInputView();
        this.outputView = new ConsoleOutputView();
    }

    public void run() {
        Lottos lottos = buildLottos();
    }

    private Lottos buildLottos() {
        LottosFactory lottosFactory = new LottosFactory();
        Lottos lottos = null;
        while (lottos == null) {
            try {
                lottos = lottosFactory.createLottos(readPurchaseAmount());
            } catch(IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return lottos;
    }

    private String readPurchaseAmount() {
        outputView.printPurchasePriceMessage();
        return inputView.read();
    }
}
