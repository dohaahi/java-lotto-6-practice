package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.IllegalInputException;
import lotto.exception.IllegalLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {
    @DisplayName("모든 형식을 잘 맞춰입력하면 검증 통과")
    @Test
    void test() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        // then
        new Lotto(numbers);
    }

    @Test
    @DisplayName("빈 값이 입력되면 예외 발생")
    void validateInputLottoNumbersEmpty() {
        assertThatThrownBy(() -> LottoValidator.validateInputLottoNumbers(""))
                .isInstanceOf(IllegalInputException.class);
    }

    @Test
    @DisplayName("로또 숫자 패턴에 맞지 않으면 예외 발생")
    void validateInputLottoNumbersInvalidPattern() {
        assertThatThrownBy(() -> LottoValidator.validateInputLottoNumbers("1,2,a,4,5,6"))
                .isInstanceOf(IllegalLottoException.class);
    }

    @Test
    @DisplayName("로또 번호의 길이가 6이 아니면 예외 발생")
    void validateLottoNumbersInvalidLength() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalLottoException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 값이 있으면 예외 발생")
    void validateLottoNumbersDuplicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalLottoException.class);
    }
}