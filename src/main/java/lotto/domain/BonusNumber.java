package lotto.domain;

import static lotto.validator.BonusNumberValidator.validateBonusNumber;

import java.util.List;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber from(final Lotto lotto, final int number) {
        validateBonusNumber(lotto, number);

        return new BonusNumber(number);
    }

    public boolean hasBonusNumber(final DrawLotto drawLotto) {
        List<Integer> lottoNumbers = drawLotto.getNumbers();

        for (Integer lottoNumber : lottoNumbers) {
            if (lottoNumber.equals(number)) {
                return true;
            }
        }

        return false;
    }
}
