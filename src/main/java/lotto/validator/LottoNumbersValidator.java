package lotto.validator;

import static lotto.validator.InputValidator.validateDomainIsEmpty;

import java.util.Arrays;
import java.util.regex.Pattern;
import lotto.exception.IllegalLottoNumbersException;

public class LottoNumbersValidator {
    private static final String LOTTO_NUMBERS_REGEX = "^[0-9]+(,[0-9]+)*$";
    public static final String DOMAIN_DELIMITER = ",";
    public static final int MIN_LOTTO_NUMBER_COUNT = 6;

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

    public static void validateDomain(final String input) {
        validateLottoNumbersCount(input);
        validateLottoNumbersDuplicate(input);
    }

    private static void validateLottoNumbersCount(final String input) {
        // TODO: domains 이름 수정
        long domains = Arrays.stream(input.split(DOMAIN_DELIMITER))
                .count();

        if (domains <= MIN_LOTTO_NUMBER_COUNT) {
            throw new IllegalLottoNumbersException();
        }
    }

    private static void validateLottoNumbersDuplicate(final String input) {
        final long count = Arrays.stream(input.split(DOMAIN_DELIMITER))
                .distinct()
                .count();

        if (count != input.length()) {
            throw new IllegalLottoNumbersException();
        }
    }
}