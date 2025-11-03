package lotto.domain;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    void 로또_결과계산_여부() {
        Lottos lottos = new Lottos(3000);
        lottos.generateLottos();
        assertEquals(3, lottos.calculatePurchaseCount());

        lottos.addWinningNumbers(new Lotto(java.util.List.of(1, 2, 3, 4, 5, 6)));
        lottos.addBonusNumber("7");

        Map<LottoRank, Integer> result = lottos.calculateEachResult();
        assertNotNull(result);
    }

    @Test
    void 수익률_계산_여부() {
        Lottos lottos = new Lottos(1000);
        lottos.generateLottos();
        lottos.addWinningNumbers(new Lotto(java.util.List.of(1, 2, 3, 4, 5, 6)));
        lottos.addBonusNumber("7");
        lottos.calculateEachResult();

        double rate = lottos.calculateReturnRate();
        assertTrue(rate >= 0);
    }
}
