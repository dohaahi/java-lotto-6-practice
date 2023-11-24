package lotto.domain;

import static lotto.validator.PurchaseAmountValidator.validatePurchaseAmount;

public class PurchaseAmount {
    public static final int LOTTO_PURCHASE_AMOUNT = 1_000;
    private final int amount;

    private PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public static PurchaseAmount from(final int amount) {
        validatePurchaseAmount(amount);

        return new PurchaseAmount(amount);
    }

    public int getAmount() {
        return amount;
    }
}
