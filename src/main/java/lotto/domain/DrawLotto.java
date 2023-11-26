package lotto.domain;

import java.util.List;
import lotto.domain.dto.DrawLottoDto;
import lotto.util.RandomNumberGenerator;

public class DrawLotto {
    private List<Integer> numbers;

    private DrawLotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static DrawLotto from() {
        List<Integer> numbers = RandomNumberGenerator.generate()
                .stream()
                .sorted()
                .toList();

        return new DrawLotto(numbers);
    }

    public DrawLottoDto toDrawLottoDto() {
        return new DrawLottoDto(numbers);
    }
}