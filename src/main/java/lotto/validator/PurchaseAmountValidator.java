package lotto.validator;

import static lotto.domain.PurchaseAmount.AMOUNT_UNIT;
import static lotto.validator.InputValidator.validateValueIsEmpty;

import lotto.exception.IllegalPurchaseAmountException;

public class PurchaseAmountValidator {
    private static final int MIN_AMOUNT = 1_000;
    private static final int MAX_AMOUNT = 100_000;

    public static void validateInputPurchaseAmount(final String input) {
        validateValueIsEmpty(input);
        validateInputInt(input);
    }

    private static void validateInputInt(final String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalPurchaseAmountException exception) {
            throw new IllegalPurchaseAmountException();
        }
    }

    public static void validatePurchaseAmount(final int amount) {
        validateAmountInRange(amount);
        validatePurchaseAmountUnit(amount);
    }

    private static void validateAmountInRange(final int amount) {
        if (amount < MIN_AMOUNT || amount > MAX_AMOUNT) {
            throw new IllegalPurchaseAmountException();
        }
    }

    private static void validatePurchaseAmountUnit(final int amount) {
        if (amount % AMOUNT_UNIT == 0) {
            throw new IllegalPurchaseAmountException();
        }
    }
}
