package lotto.domain.factory;

import lotto.domain.Lotto;
import lotto.domain.generator.ManualNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.common.Constants.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoFactoryTest {
    @Test
    public void 로또_생성_성공_테스트_1() {
        LottoFactory lottoFactory = new LottoFactory(new ManualNumberGenerator(List.of(3, 6, 1, 2, 5, 4)));
        Lotto lotto = lottoFactory.createLotto();
        assertThat(lotto.getSortedNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 로또_생성_실패_테스트_1() {
        LottoFactory lottoFactory = new LottoFactory(new ManualNumberGenerator(List.of(6, 1, 2, 5, 4)));
        assertThatThrownBy(() -> lottoFactory.createLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @Test
    public void 로또_생성_실패_테스트_2() {
        LottoFactory lottoFactory = new LottoFactory(new ManualNumberGenerator(List.of(3, 3, 1, 2, 5, 4)));
        assertThatThrownBy(() -> lottoFactory.createLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 중복 입력할 수 없습니다.");
    }

    @Test
    public void 로또_생성_실패_테스트_3() {
        LottoFactory lottoFactory = new LottoFactory(new ManualNumberGenerator(List.of(0, 6, 1, 2, 5, 4)));
        assertThatThrownBy(() -> lottoFactory.createLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자의 범위는 " + LOTTO_START_INCLUSIVE + "에서 " +  LOTTO_END_INCLUSIVE + " 사이입니다.");
    }

    @Test
    public void 로또_생성_실패_테스트_4() {
        LottoFactory lottoFactory = new LottoFactory(new ManualNumberGenerator(List.of(46, 6, 1, 2, 5, 4)));
        assertThatThrownBy(() -> lottoFactory.createLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자의 범위는 " + LOTTO_START_INCLUSIVE + "에서 " +  LOTTO_END_INCLUSIVE + " 사이입니다.");
    }
}
