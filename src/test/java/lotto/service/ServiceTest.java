package lotto.service;

import lotto.DTO.LottoDTO;
import lotto.DTO.LottoGenerateResult;
import lotto.DTO.LottoWinningResult;
import lotto.domain.Lottos;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoServiceTest {

    private LottoService lottoService;
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        lottos = lottoService.createLottos("5000");
    }

    @Test
    void createLottos_Test() {
        assertThat(lottos.getLottos()).hasSize(5);
        assertThat(lottos.calculatePurchaseCount()).isEqualTo(5);
    }

    @Test
    void buildLottoGenerateResult_Test() {
        LottoGenerateResult result = lottoService.buildLottoGenerateResult(lottos);

        assertThat(result.getPurchaseCount()).isEqualTo(5);
        assertThat(result.getLottos()).allMatch(dto -> dto instanceof LottoDTO);
        assertThat(result.getLottos().get(0).getNumbers()).hasSize(6);
    }

    @Test
    void createWinningNumbers_Test() {
        boolean result = lottoService.createWinningNumbers("1,2,3,4,5,6", lottos);
        assertThat(result).isTrue();
    }

    @Test
    void createWinningNumbers_FailTest() {
        assertThatThrownBy(() -> lottoService.createWinningNumbers("1,2,3,4,5", lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createBonusNumberTest() {
        lottoService.createWinningNumbers("1,2,3,4,5,6", lottos);
        boolean result = lottoService.createBonusNumber("7", lottos);

        assertThat(result).isTrue();
    }

    @Test
    void createBonusNumber_FailTest() {
        lottoService.createWinningNumbers("1,2,3,4,5,6", lottos);
        assertThatThrownBy(() -> lottoService.createBonusNumber("1", lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculateLottoWinningResultTest() {
        lottoService.createWinningNumbers("1,2,3,4,5,6", lottos);
        lottoService.createBonusNumber("7", lottos);

        List<LottoWinningResult> results = lottoService.calculateLottoWinningResult(lottos);
        assertThat(results.size()).isEqualTo(LottoRank.values().length - 1);
    }

    @Test
    void calculateReturnRateTest() {
        lottoService.createWinningNumbers("1,2,3,4,5,6", lottos);
        lottoService.createBonusNumber("7", lottos);
        lottoService.calculateLottoWinningResult(lottos);
        double rate = lottoService.calculateReturnRate(lottos);
        assertTrue(rate >= 0);
    }
}
