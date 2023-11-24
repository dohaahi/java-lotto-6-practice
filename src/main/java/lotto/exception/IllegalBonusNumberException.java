package lotto.exception;

import static lotto.exception.IllegalInputException.ERROR_FORMAT;

public class IllegalBonusNumberException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 보너스 번호입니다. 다시 입력해 주세요.";

    public IllegalBonusNumberException() {
        super(ERROR_FORMAT + EXCEPTION_MESSAGE);
    }

    public IllegalBonusNumberException(final String message) {
        super(ERROR_FORMAT + message);
    }
}