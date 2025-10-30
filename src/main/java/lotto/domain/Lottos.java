package lotto.domain;

import static lotto.common.Constants.LOTTO_UNIT_PRICE;

public class Lottos {
    private static int purchasePrice;
    private static int PurchaseCount;

    public Lottos(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.PurchaseCount = purchasePrice / LOTTO_UNIT_PRICE;
    }
}
