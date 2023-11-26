package lotto.domain;

import static lotto.validator.PurchaseAmountValidator.validatePurchaseAmount;

public class PurchaseAmount {
    public static final int AMOUNT_UNIT = 1_000;
    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public static PurchaseAmount from(final int amount) {
        validatePurchaseAmount(amount);

        return new PurchaseAmount(amount);
    }

    public int getAmount() {
        return amount/AMOUNT_UNIT;
    }
}
