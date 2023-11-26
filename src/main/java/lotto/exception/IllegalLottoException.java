package lotto.exception;

public class IllegalLottoException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 당첨 숫자입니다. 다시 입력해 주세요.";

    public IllegalLottoException() {
        super(EXCEPTION_MESSAGE);
    }

    public IllegalLottoException(final String message) {
        super(message);
    }
}