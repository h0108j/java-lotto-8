package lotto.domain.factory;

import lotto.domain.Lottos;
import lotto.validation.LottosValidator;
import lotto.validation.Validator;

public class LottosFactory {
    private static Validator<String> validator;

    public LottosFactory() {
        this.validator = new LottosValidator();
    }

    public Lottos createLottos(String purchasePrice) {
        validator.validate(purchasePrice);
        return new Lottos(Integer.parseInt(purchasePrice));
    }
}
