package lotto.DTO;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerateResult {
    private int purchaseCount;
    private List<LottoDTO> lottos;

    public LottoGenerateResult(int purchaseCount, List<LottoDTO> lottos) {
        this.purchaseCount = purchaseCount;
        this.lottos = new ArrayList<>(lottos);
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public List<LottoDTO> getLottos() {
        return lottos;
    }
}
