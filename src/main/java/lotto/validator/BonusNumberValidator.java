package lotto.validator;

import static lotto.validator.InputValidator.validateDomainIsEmpty;
import static lotto.validator.LottoValidator.MAX_RANGE;
import static lotto.validator.LottoValidator.MIN_RANGE;

import lotto.domain.Lotto;
import lotto.exception.IllegalBonusNumberException;

public class BonusNumberValidator {
    private static final String DUPLICATE_NUMBER_MESSAGE = "보너스 숫자가 당첨번호와 중복되었습니다. 다시 입력해 주세요.";


    public static void validateInputBonusNumber(final String input) {
        validateDomainIsEmpty(input);
        validateInputIntBonusNumber(input);
    }

    private static void validateInputIntBonusNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalBonusNumberException();
        }
    }

    public static void validateBonusNumber(final Lotto lotto, final int bonusNumber) {
        validateNumberInRange(bonusNumber);
        validateBonusNumberDuplicate(lotto, bonusNumber);
    }

    private static void validateNumberInRange(final int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalBonusNumberException();
        }
    }

    public static void validateBonusNumberDuplicate(final Lotto lotto, final int bonusNumber) {
        boolean isBonusNumberDuplicate = lotto.isBonusNumberDuplicate(bonusNumber);

        if (isBonusNumberDuplicate) {
            throw new IllegalBonusNumberException(DUPLICATE_NUMBER_MESSAGE);
        }
    }
}