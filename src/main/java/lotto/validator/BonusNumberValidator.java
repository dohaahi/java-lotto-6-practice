package lotto.validator;

import static lotto.validator.InputValidator.validateValueIsEmpty;
import static lotto.validator.LottoValidator.MAX_LOTTO_NUMBER;
import static lotto.validator.LottoValidator.MIN_LOTTO_NUMBER;

import java.util.List;
import lotto.exception.IllegalBonusNumberException;
import lotto.exception.IllegalPurchaseAmountException;

public class BonusNumberValidator {
    public static void validateInputBonusNumber(final String input) {
        validateValueIsEmpty(input);
        validateInputInt(input);
    }

    private static void validateInputInt(final String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalPurchaseAmountException exception) {
            throw new IllegalBonusNumberException();
        }
    }

    public static void validateBonusNumber(final List<Integer> numbers, final int bonusNumber) {
        validateBonusNumberInRange(bonusNumber);
        validateBonusNumberDuplicate(numbers, bonusNumber);
    }

    private static void validateBonusNumberInRange(final int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalBonusNumberException();
        }
    }

    private static void validateBonusNumberDuplicate(final List<Integer> numbers, final int bonusNumber) {
        boolean hasDuplicateNumber = numbers.stream()
                .filter(number -> number == bonusNumber)
                .count() > 0;

        if (hasDuplicateNumber) {
            throw new IllegalBonusNumberException();
        }
    }
}