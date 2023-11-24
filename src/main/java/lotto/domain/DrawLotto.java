package lotto.domain;

import java.util.List;
import lotto.util.RandomNumberGenerator;

public class DrawLotto {
    private final List<Integer> numbers;

    private DrawLotto() {
        List<Integer> numbers = RandomNumberGenerator.generate();
        this.numbers = numbers;
    }

    public static DrawLotto from() {
        return new DrawLotto();
    }
}
