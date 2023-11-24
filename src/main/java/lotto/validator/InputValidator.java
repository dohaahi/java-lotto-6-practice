package lotto.validator;

import lotto.exception.IllegalInputException;

public class InputValidator {
    public static final String INPUT_VALUE_MESSAGE = "빈 값을 입력했습니다. 다시 입력해 주세요.";

    public static void validateDomainIsEmpty(final String input) {
        if (input.isBlank()) {
            throw new IllegalInputException(INPUT_VALUE_MESSAGE);
        }
    }
}