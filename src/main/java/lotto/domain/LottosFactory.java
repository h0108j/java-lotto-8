package lotto.domain;

import lotto.validation.LottosValidator;
import lotto.validation.Validator;

public class LottosFactory {
    private final static Validator validator = new LottosValidator();

    public static Lottos createLottos(String purchasePrice) {
        validator.validate(purchasePrice);
        return new Lottos(Integer.parseInt(purchasePrice));
    }
}
