package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoService lottoService = new LottoService();

        Lottos lottos = readPurchasePrice(lottoService);
        outputView.printLottoGenerateResult(lottoService.buildLottoGenerateResult(lottos));
        readWinningNumbers(lottoService, lottos);
        readBonusNumber(lottoService, lottos);
        outputView.printRankingCount(lottoService.calculateLottoWinningResult(lottos));
        outputView.printReturnRate(lottoService.calculateReturnRate(lottos));
    }

    private Lottos readPurchasePrice(LottoService lottoService) {
        Lottos lottos = null;
        while (lottos == null) {
            outputView.printPurchasePriceMessage();
            try {
                lottos = lottoService.createLottos(inputView.read());
            } catch(IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return lottos;
    }

    private void readWinningNumbers(LottoService lottoService, Lottos lottos) {
        boolean haveWinningNumbers = false;
        while (!haveWinningNumbers) {
            outputView.printWinningNumberMessage();
            try {
                haveWinningNumbers = lottoService.createWinningNumbers(inputView.read(), lottos);
            } catch(IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void readBonusNumber(LottoService lottoService, Lottos lottos) {
        boolean haveBonusNumbers = false;
        while (!haveBonusNumbers) {
            outputView.printBonusNumberMessage();
            try {
                haveBonusNumbers = lottoService.createBonusNumber(inputView.read(), lottos);
            } catch(IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
