package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.IllegalInputException;
import lotto.exception.IllegalPurchaseAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {
    @Test
    @DisplayName("빈 값이 입력되면 예외 발생")
    void validateInputPurchaseAmountEmpty() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateInputPurchaseAmount(""))
                .isInstanceOf(IllegalInputException.class);
    }

    @Test
    @DisplayName("정수가 아닌 값이 입력되면 예외 발생")
    void validateInputPurchaseAmountNotInteger() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateInputPurchaseAmount("abc"))
                .isInstanceOf(IllegalPurchaseAmountException.class);
    }

    @Test
    @DisplayName("구매 금액이 최소값 미만이거나 최대값 초과하면 예외 발생")
    void validatePurchaseAmountOutOfRange() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(999))
                .isInstanceOf(IllegalPurchaseAmountException.class);

        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(100_001))
                .isInstanceOf(IllegalPurchaseAmountException.class);
    }

    @Test
    @DisplayName("구매 금액이 단위로 나누어 떨어지지 않으면 예외 발생")
    void validatePurchaseAmountNotMultipleOfUnit() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(1_500))
                .isInstanceOf(IllegalPurchaseAmountException.class);
    }

}