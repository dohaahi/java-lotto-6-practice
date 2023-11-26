package lotto.domain;

import static lotto.validator.BonusNumberValidator.validateBonusNumber;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(final List<Integer> numbers, final int bonusNumber) {
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(final List<Integer> numbers, final int bonusNumber) {
        return new BonusNumber(numbers, bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
