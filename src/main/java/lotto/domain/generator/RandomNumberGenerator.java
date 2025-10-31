package lotto.domain.generator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.common.Constants.*;

public class RandomNumberGenerator implements NumberGenerator {
    public List<Integer> generateNumbers() {
        return pickUniqueNumbersInRange(LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE, LOTTO_UNIT_COUNT);
    }
}
