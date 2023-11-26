package lotto.exception;

public class IllegalPurchaseAmountException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 금액입니다. 다시 입력해 주세요.";

    public IllegalPurchaseAmountException() {
        super(EXCEPTION_MESSAGE);
    }

    public IllegalPurchaseAmountException(final String message) {
        super(message);
    }
}