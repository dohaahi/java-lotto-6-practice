package lotto.domain;

import static lotto.validator.BonusNumberValidator.validateBonusNumber;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber from(final int number) {
        validateBonusNumber(number);

        return new BonusNumber(number);
    }
}
