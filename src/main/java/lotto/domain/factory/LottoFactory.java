package lotto.domain.factory;

import lotto.domain.Lotto;
import lotto.domain.generator.NumberGenerator;
import lotto.validation.LottoValidator;
import lotto.validation.Validator;

import java.util.List;

public class LottoFactory {
    private NumberGenerator numberGenerator;
    private Validator validator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.validator = new LottoValidator();
    }

    public Lotto createLotto() {
        List<Integer> numbers = numberGenerator.generateNumbers();
        validator.validate(numbers);
        return new Lotto((numbers));
    }
}
