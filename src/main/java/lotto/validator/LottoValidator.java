package lotto.validator;

import static lotto.validator.InputValidator.validateValueIsEmpty;

import java.util.List;
import java.util.regex.Pattern;
import lotto.exception.IllegalLottoException;

public class LottoValidator {
    private static final String DELIMITER = ",";
    private static final int LOTTO_NUMBERS_LENGTH = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final String LOTTO_NUMBERS_REGEX = "^[\\d]+(" + DELIMITER + "[\\d]+)*$";
    private static final String INVALID_LOTTO_LENGTH_MESSAGE = "당첨 숫자는 " + LOTTO_NUMBERS_LENGTH + "자리 입니다. 다시 입력해 주세요.";
    private static final String INVALID_LOTTO_NUMBERS_DUPLICATE_MESSAGE = "당첨 숫자는 중복되는 값을 입력할 수 없습니다. 다시 입력해 주세요.";

    public static void validateInputLottoNumbers(final String input) {
        validateValueIsEmpty(input);
        validateLottoNumbersPatternInput(input);
    }

    private static void validateLottoNumbersPatternInput(final String input) {
        if (!Pattern.matches(LOTTO_NUMBERS_REGEX, input)) {
            throw new IllegalLottoException();
        }
    }


    public static void validateLottoNumbers(final List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoNumbersDuplicate(numbers);
    }


    private static void validateLottoLength(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalLottoException(INVALID_LOTTO_LENGTH_MESSAGE);
        }
    }

    private static void validateLottoNumbersDuplicate(final List<Integer> numbers) {
        long uniqueNumberCount = numbers.stream()
                .distinct()
                .count();

        if (numbers.size() != uniqueNumberCount) {
            throw new IllegalLottoException(INVALID_LOTTO_NUMBERS_DUPLICATE_MESSAGE);
        }
    }
}
