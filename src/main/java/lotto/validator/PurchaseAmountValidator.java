package lotto.validator;

import static lotto.domain.PurchaseAmount.LOTTO_PURCHASE_AMOUNT;

import lotto.exception.IllegalLottoNumbersException;
import lotto.exception.IllegalPurchaseAmountException;

public class PurchaseAmountValidator {
    private static final String INVALID_PURCHASE_AMOUNT_MESSAGE = "구입 금액은 1,000원 단위로 입력해야 합니다. 다시 입력해 주세요.";
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

    public static void validatePurchaseAmount(final int amount) {
        if (amount % LOTTO_PURCHASE_AMOUNT != 0) {
            throw new IllegalPurchaseAmountException(INVALID_PURCHASE_AMOUNT_MESSAGE);
        }

        if (amount < LOTTO_PURCHASE_AMOUNT || amount > MAX_AMOUNT) {
            throw new IllegalPurchaseAmountException();
        }
    }
}