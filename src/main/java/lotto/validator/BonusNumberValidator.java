package lotto.validator;

import static lotto.validator.InputValidator.validateDomainIsEmpty;

import java.util.List;
import lotto.exception.IllegalBonusNumberException;

public class BonusNumberValidator {
    private static final String DUPLICATE_NUMBER_MESSAGE = "보너스 숫자가 당첨번호와 중복되었습니다. 다시 입력해 주세요.";
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

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

    public static void validateBonusNumber(final int number) {
        validateNumberInRange(number);
    }

    private static void validateNumberInRange(final int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalBonusNumberException();
        }
    }

    public static void validateBonusNumberDuplicate(final List<Integer> numbers, final int bonusNumber) {
        long duplicateNumberCount = numbers.stream()
                .filter(number -> number == bonusNumber)
                .count();

        if (duplicateNumberCount > 0) {
            throw new IllegalBonusNumberException(DUPLICATE_NUMBER_MESSAGE);
        }
    }
}