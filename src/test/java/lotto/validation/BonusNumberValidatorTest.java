package lotto.validation;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberValidatorTest {

    @Test
    void 정상번호() {
        BonusNumberValidator validator = new BonusNumberValidator(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertDoesNotThrow(() -> validator.validate("7"));
    }

    @Test
    void 중복번호() {
        BonusNumberValidator validator = new BonusNumberValidator(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1"));
    }

    @Test
    void 범위_초과_숫자() {
        BonusNumberValidator validator = new BonusNumberValidator(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("46"));
    }

    @Test
    void 범위_미만_숫자() {
        BonusNumberValidator validator = new BonusNumberValidator(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("0"));
    }

    @Test
    void 음수() {
        BonusNumberValidator validator = new BonusNumberValidator(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("-1"));
    }

    @Test
    void 숫자_외_문자() {
        BonusNumberValidator validator = new BonusNumberValidator(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("a"));
    }
}
