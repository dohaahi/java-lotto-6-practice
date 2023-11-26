package lotto.exception;

public class IllegalBonusNumberException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 보너스 숫자입니다. 다시 입력해 주세요.";

    public IllegalBonusNumberException() {
        super(EXCEPTION_MESSAGE);
    }

    public IllegalBonusNumberException(final String message) {
        super(message);
    }
}