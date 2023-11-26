package lotto.validator;

import ex.exception.NumberException;
import java.util.regex.Pattern;
import lotto.exception.IllegalInputException;
import lotto.exception.IllegalPurchaseAmountException;

public class InputValidator {
    private static final String INVALID_NUMBER_MESSAGE = "유효하지 않은 숫자입니다. 다시 입력해 주세요.";
    private static final String INVALID_PATTERN_MESSAGE = "유효하지 않은 형식의 입력입니다. 다시 입력해 주세요.";
    private static final String INPUT_VALUE_MESSAGE = "값을 입력해주세요.";

    // TODO: 모든 미션에서 사용한 regex 작성 후 골라서 사용
    private static final String REGEX = "";
    private static final String XXX_REGEX = "^[a-zA-Z가-힣]+($DELIMITER$[a-zA-Z가-힣]+)*$";
    private static final String NUMBER_REGEX = "^[\\d]+($DELIMITER$[\\d]+)*$";

    public static void validateValueIsEmpty(final String input) {
        if (input.isBlank()) {
            throw new IllegalInputException(INPUT_VALUE_MESSAGE);
        }
    }

    public static void validateInputPurchaseAmount(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberException exception) {
            // TODO: 예외 class 변경
            throw new IllegalPurchaseAmountException(INVALID_NUMBER_MESSAGE);
        }
    }

    public static void validateXXXPatternInput(final String input) {
        // TODO: regex 변경하여 사용
        if (!Pattern.matches(REGEX, input)) {
            // TODO: 예외 class 변경
            throw new IllegalPurchaseAmountException(INVALID_PATTERN_MESSAGE);
        }
    }
}