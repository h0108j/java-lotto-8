package lotto.domain.factory;

import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lotto.common.Constants.LOTTO_UNIT_PRICE;
import static lotto.common.Constants.MAXIMUM_PURCHASE_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosFactoryTest {

    private LottosFactory lottosFactory;

    @BeforeEach
    void setUp() {
        lottosFactory = new LottosFactory();
    }

    @Test
    void 로또s_생성_성공_1() {
        String validPrice = "6000";
        Lottos lottos = lottosFactory.createLottos(validPrice);
        lottos.generateLottos();
        assertThat(lottos).isNotNull();
        assertThat(lottos.getLottos()).hasSize(6);
    }

    @Test
    void 로또s_생성_실패_1() {
        String invalidPrice = "5500";
        assertThatThrownBy(() -> lottosFactory.createLottos(invalidPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_UNIT_PRICE + "로 나누어 떨어져야 합니다.");
    }

    @Test
    void 로또s_생성_실패_2() {
        String invalidInput = "aaaa";
        assertThatThrownBy(() -> lottosFactory.createLottos(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 숫자가 아닙니다.");
    }

    @Test
    void 로또s_생성_실패_3() {
        String invalidInput = "500";
        assertThatThrownBy(() -> lottosFactory.createLottos(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 입력 값은 " + LOTTO_UNIT_PRICE + "원 입니다.");
    }

    @Test
    void 로또s_생성_실패_4() {
        String invalidInput = "10000000";
        assertThatThrownBy(() -> lottosFactory.createLottos(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MAXIMUM_PURCHASE_PRICE + "이하의 값을 입력해야 합니다.");
    }
}
