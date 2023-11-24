package lotto.validator;

import static lotto.validator.InputValidator.validateDomainIsEmpty;

import lotto.exception.IllegalBonusNumberException;

public class BonusNumberValidator {
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

    public static void validateDomain(final String input) {
        validateBonusNumberDuplicate(input);
    }

    private static void validateBonusNumberDuplicate(final String input) {
        // TODO: 당첨 번호와 중복 검사
    }
}