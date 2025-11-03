package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @Test
    void 일치_번호_0개() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lotto.calculateMatchResult(List.of(11, 12, 13, 4, 5, 6), 10);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.MISS, rank);
    }

    @Test
    void 일치_번호_1개() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lotto.calculateMatchResult(List.of(11, 12, 3, 4, 5, 6), 10);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.MISS, rank);
    }

    @Test
    void 일치_번호_2개() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lotto.calculateMatchResult(List.of(11, 2, 3, 4, 5, 6), 15);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.MISS, rank);
    }

    @Test
    void 보너스_번호가_일치하는_5등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lotto.calculateMatchResult(List.of(1, 2, 3, 4, 5, 6), 10);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.FIFTH, rank);
    }

    @Test
    void 보너스_번호가_일치하지_않는_5등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lotto.calculateMatchResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.FIFTH, rank);
    }

    @Test
    void 보너스_번호가_일치하는_4등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lotto.calculateMatchResult(List.of(1, 2, 3, 8, 5, 6), 10);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.FOURTH, rank);
    }

    @Test
    void 보너스_번호가_일치하지_않는_4등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lotto.calculateMatchResult(List.of(1, 2, 3, 8, 5, 6), 7);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.FOURTH, rank);
    }

    @Test
    void 보너스_번호가_일치하는_2등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lotto.calculateMatchResult(List.of(1, 2, 3, 8, 9, 6), 10);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.SECOND, rank);
    }

    @Test
    void 보너스_번호가_일치하지_않는_3등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lotto.calculateMatchResult(List.of(1, 2, 3, 8, 9, 6), 7);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.THIRD, rank);
    }

    @Test
    void 보너스_번호가_일치하지_않는_1등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lotto.calculateMatchResult(List.of(1, 2, 3, 8, 9, 10), 7);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.FIRST, rank);
    }

    @Test
    void 순서가_섞여있는_1등() {
        Lotto lotto = new Lotto(List.of(9, 3, 8, 1, 10, 2));
        lotto.calculateMatchResult(List.of(1, 2, 3, 8, 9, 10), 7);
        LottoRank rank = lotto.calculateRanking();
        assertEquals(LottoRank.FIRST, rank);
    }

    @Test
    void 번호_정렬_테스트() {
        Lotto lotto = new Lotto(List.of(5, 1, 3, 2, 4, 6));
        List<Integer> sorted = lotto.getSortedNumbers();
        assertEquals(List.of(1, 2, 3, 4, 5, 6), sorted);
    }
}
