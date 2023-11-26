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

    public int matchNumberCount(final DrawLotto drawLotto) {
        int matchNumberCount = 0;
        List<Integer> drawLottoNumbers = drawLotto.getNumbers();

        for (Integer number : numbers) {
            matchNumberCount += (int) drawLottoNumbers.stream()
                    .filter(drawNumber -> drawNumber.equals(number))
                    .count();
        }

        return matchNumberCount;
    }

    public boolean isBonusNumberDuplicate(final int bonusNumber) {
        return numbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }
}
