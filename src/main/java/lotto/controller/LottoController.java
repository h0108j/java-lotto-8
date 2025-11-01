package lotto.controller;

import lotto.DTO.LottoDTO;
import lotto.DTO.LottoGenerateResult;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.factory.LottoFactory;
import lotto.domain.factory.LottosFactory;
import lotto.domain.generator.ManualNumberGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        this.inputView = new ConsoleInputView();
        this.outputView = new ConsoleOutputView();
    }

    public void run() {
        Lottos lottos = buildLottos();
        outputView.printLottoGenerateResult(toLottoGenerateResult(lottos));
        Lotto winningLotto = readWinningNumber();
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

    private LottoGenerateResult toLottoGenerateResult(Lottos lottos) {
        List<LottoDTO> lottoDTOs = lottos.getLottos().stream()
                .map(lotto -> new LottoDTO(lotto.getSortedNumbers()))
                .toList();

        return new LottoGenerateResult(lottos.getPurchaseCount(), lottoDTOs);
    }

    private String readPurchaseAmount() {
        outputView.printPurchasePriceMessage();
        return inputView.read();
    }

    private Lotto readWinningNumber() {
        LottoFactory lottoFactory;
        Lotto winningLotto = null;
        while (winningLotto == null) {
            outputView.printWinningNumberMessage();
            lottoFactory = new LottoFactory(new ManualNumberGenerator(inputView.read()));
            try {
                winningLotto = lottoFactory.createLotto();
            } catch(IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return winningLotto;
    }
}
