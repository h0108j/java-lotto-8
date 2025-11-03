package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void 일치_개수에_따라_등수반환() {
        assertEquals(LottoRank.FIRST, LottoRank.from(6, false));
        assertEquals(LottoRank.SECOND, LottoRank.from(5, true));
        assertEquals(LottoRank.THIRD, LottoRank.from(5, false));
        assertEquals(LottoRank.FOURTH, LottoRank.from(4, true));
        assertEquals(LottoRank.FOURTH, LottoRank.from(4, false));
        assertEquals(LottoRank.FIFTH, LottoRank.from(3, true));
        assertEquals(LottoRank.FIFTH, LottoRank.from(3, false));
    }

    @Test
    void 개수_0부터_2는_미당첨() {
        assertEquals(LottoRank.MISS, LottoRank.from(0, false));
        assertEquals(LottoRank.MISS, LottoRank.from(1, false));
        assertEquals(LottoRank.MISS, LottoRank.from(2, false));
        assertEquals(LottoRank.MISS, LottoRank.from(0, true));
        assertEquals(LottoRank.MISS, LottoRank.from(1, true));
        assertEquals(LottoRank.MISS, LottoRank.from(2, true));
    }
}
