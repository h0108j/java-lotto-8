package lotto.validation;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidatorTest {
    private final LottoValidator validator = new LottoValidator();

    @Test
    void 정상_번호() {
        assertDoesNotThrow(() -> validator.validate(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 숫자_개수_미달() {
        assertThrows(Exception.class, () -> validator.validate(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void 숫자_개수_초과() {
        assertThrows(Exception.class, () -> validator.validate(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void 중복_값() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(List.of(1, 1, 2, 3, 4, 5)));
    }

    @Test
    void 범위_초과() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(List.of(1, 2, 3, 4, 5, 46)));
    }

    @Test
    void 범위_미달() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(List.of(0, 2, 3, 4, 5, 45)));
    }
}
