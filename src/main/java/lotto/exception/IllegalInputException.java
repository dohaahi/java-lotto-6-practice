package lotto.exception;

public class IllegalInputException extends IllegalArgumentException {
    public static final String ERROR_FORMAT = "[ERROR] ";

    public IllegalInputException(final String message) {
        super(ERROR_FORMAT + message);
    }
}