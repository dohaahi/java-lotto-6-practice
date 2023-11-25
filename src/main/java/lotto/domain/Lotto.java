package lotto.domain;

import static lotto.validator.LottoValidator.validateLotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        validateLotto(numbers);
    }

    // TODO: 추가 기능 구현
}
