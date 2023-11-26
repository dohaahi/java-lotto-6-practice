package lotto.domain;

import java.util.List;
import lotto.domain.dto.DrawLottoDto;
import lotto.util.RandomNumberGenerator;

public class DrawLotto {
    private final List<Integer> numbers;

    private DrawLotto() {
        List<Integer> numbers = RandomNumberGenerator.generate()
                .stream()
                .sorted()
                .toList();
        this.numbers = numbers;
    }

    public static DrawLotto from() {
        return new DrawLotto();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public DrawLottoDto toDrawLottoDto() {
        return new DrawLottoDto(numbers);
    }
}
