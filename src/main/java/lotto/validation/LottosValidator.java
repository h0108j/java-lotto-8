package lotto.validation;

import static lotto.common.Constants.LOTTO_UNIT_PRICE;
import static lotto.common.Constants.MAXIMUM_PURCHASE_PRICE;

public class LottosValidator implements Validator<String> {
    @Override
    public void validate(String purchasePrice) {
        int price = validateNumber(purchasePrice);
        validateUnit(price);
        validateMaximum(price);
    }

    private int validateNumber(String purchasePrice) {
        int price;
        try {
            price = Integer.parseInt(purchasePrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
        return price;
    }

    private void validateUnit(int price) {
        if (price < LOTTO_UNIT_PRICE) { throw new IllegalArgumentException("최소 입력 값은 " + LOTTO_UNIT_PRICE + "원 입니다."); }
        if (price % LOTTO_UNIT_PRICE != 0) { throw new IllegalArgumentException(LOTTO_UNIT_PRICE + "로 나누어 떨어져야 합니다."); }
    }

    private void validateMaximum(int price) {
        if (price > MAXIMUM_PURCHASE_PRICE) { throw new IllegalArgumentException( MAXIMUM_PURCHASE_PRICE + "이하의 값을 입력해야 합니다."); }
    }
}
