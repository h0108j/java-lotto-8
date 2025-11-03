package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottosValidatorTest {
    private final LottosValidator validator = new LottosValidator();

    @Test
    void 정상_입력값() {
        assertDoesNotThrow(() -> validator.validate("5000"));
    }

    @Test
    void 숫자_외_문자() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("abc"));
    }

    @Test
    void 숫자와_문자() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("b1c2"));
    }

    @Test
    void 범위_미만_숫자() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("0"));
    }

    @Test
    void 범위_초과_숫자() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("100000000"));
    }

    @Test
    void 천원_단위가_아닌경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1500"));
    }
}
