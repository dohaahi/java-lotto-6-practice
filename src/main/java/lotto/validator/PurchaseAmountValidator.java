package lotto.validator;

import lotto.exception.IllegalLottoNumbersException;
import lotto.exception.IllegalPurchaseAmountException;

public class PurchaseAmountValidator {
    public static final int MIN_AMOUNT = 1_000;
    public static final int MAX_AMOUNT = 100_000;

    public static void validateInputPurchaseAmount(final String input) {
        validateDomainIsEmpty(input);
        validateInputIntPurchaseAmount(input);
    }

    private static void validateDomainIsEmpty(final String input) {
        if (input.isBlank()) {
            throw new IllegalLottoNumbersException();
        }
    }

    private static void validateInputIntPurchaseAmount(final String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalPurchaseAmountException();
        }
    }

    public static void validatePurchaseAmount(final String input) {
        // TODO: 1,000원 단위 검증
    }
}