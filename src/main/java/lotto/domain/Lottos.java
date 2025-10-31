package lotto.domain;

import lotto.domain.factory.LottoFactory;
import lotto.domain.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.Constants.LOTTO_UNIT_PRICE;

public class Lottos {
    private LottoFactory lottoFactory;

    private static int purchasePrice;
    private static int purchaseCount;

    private List<Lotto> lottos;

    public Lottos(int purchasePrice) {
        this.lottoFactory = new LottoFactory(new RandomNumberGenerator());
        this.purchasePrice = purchasePrice;
        this.purchaseCount = purchasePrice / LOTTO_UNIT_PRICE;
    }

    public void generateLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(lottoFactory.createLotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
