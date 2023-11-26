package lotto.domain;

import static lotto.validator.LottoValidator.validateLottoNumbers;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        validateLottoNumbers(numbers);

        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int matchNumberCount(final DrawLotto drawLotto) {
        int totalMatchNumberCount = 0;

        for (Integer number : numbers) {
            totalMatchNumberCount += (int) drawLotto.getNumbers()
                    .stream()
                    .filter(drawNumber -> drawNumber.equals(number))
                    .count();
        }

        return totalMatchNumberCount;
    }

    public boolean isMatchBonusNumber(final BonusNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(number -> number == bonusNumber.getBonusNumber());
    }
}