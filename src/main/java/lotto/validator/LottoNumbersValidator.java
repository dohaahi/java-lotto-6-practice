package lotto.validator;

import static lotto.validator.InputValidator.validateDomainIsEmpty;

import java.util.List;
import java.util.regex.Pattern;
import lotto.exception.IllegalLottoNumbersException;

public class LottoNumbersValidator {
    private static final String INVALID_LOTTO_NUMBER_COUNT_MESSAGE = "당첨 번호의 개수 유효하지 않습니다. 다시 입력해 주세요.";
    private static final String DUPLICATE_LOTTO_NUMBER_COUNT_MESSAGE = "당첨 번호가 중복 입력됐습니다. 다시 입력해 주세요.";
    private static final String LOTTO_NUMBERS_REGEX = "^[0-9]+(,[0-9]+)*$";
    public static final String DOMAIN_DELIMITER = ",";
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static void validateInputLottoNumbers(final String input) {
        validateDomainIsEmpty(input);
        validateLottoNumbersPatternInput(input);
    }

    public static void validateLottoNumbersPatternInput(final String input) {
        final String regex = LOTTO_NUMBERS_REGEX;

        if (!Pattern.matches(regex, input)) {
            throw new IllegalLottoNumbersException();
        }
    }

    public static void validateLottoNumbers(final List<Integer> numbers) {
//        validateLottoNumbersCount(numbers);
        validateLottoNumbersDuplicate(numbers);
    }

//    private static void validateLottoNumbersCount(final List<Integer> numbers) {
//        long numberSize = numbers.size();
//
//        if (numberSize != LOTTO_NUMBER_COUNT) {
//            throw new IllegalLottoNumbersException(INVALID_LOTTO_NUMBER_COUNT_MESSAGE);
//        }
//    }

    private static void validateLottoNumbersDuplicate(final List<Integer> numbers) {
        final long count = numbers.stream()
                .distinct()
                .count();

        if (count != numbers.size()) {
            throw new IllegalLottoNumbersException(DUPLICATE_LOTTO_NUMBER_COUNT_MESSAGE);
        }
    }
}