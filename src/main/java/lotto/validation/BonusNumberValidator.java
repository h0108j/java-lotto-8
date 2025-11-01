package lotto.validation;

import lotto.domain.Lotto;

import static lotto.common.Constants.LOTTO_END_INCLUSIVE;
import static lotto.common.Constants.LOTTO_START_INCLUSIVE;

public class BonusNumberValidator implements Validator<String> {
    private Lotto winningNumber;

    public BonusNumberValidator(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    }

    @Override
    public void validate(String number) {
        int bonusNumber = validateInteger(number);
        validateDuplicate(bonusNumber);
        validateRange(bonusNumber);
    }

    private int validateInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력할 수 있습니다.");
        }
    }

    private void validateDuplicate(int bonusNumber) {
        if (winningNumber.getSortedNumbers().stream().anyMatch(number -> number == bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복일 수 없습니다.");
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < LOTTO_START_INCLUSIVE || bonusNumber > LOTTO_END_INCLUSIVE) {
            throw new IllegalArgumentException("보너스 번호의 범위는 " + LOTTO_START_INCLUSIVE + "에서 " +  LOTTO_END_INCLUSIVE + " 사이입니다.");
        }
    }
}
