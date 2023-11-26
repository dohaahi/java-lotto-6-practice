package lotto.view;

import static lotto.validator.BonusNumberValidator.validateInputBonusNumber;
import static lotto.validator.LottoValidator.validateInputLottoNumbers;
import static lotto.validator.PurchaseAmountValidator.validateInputPurchaseAmount;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBERS_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static PurchaseAmount readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String input = readLine();
        validateInputPurchaseAmount(input);

        int amount = InputConverter.mapToInt(input);

        return PurchaseAmount.from(amount);
    }

    public static Lotto readLottoNumbers() {
        System.out.println(LOTTO_NUMBERS_INPUT_MESSAGE);
        String input = readLine();
        validateInputLottoNumbers(input);

        List<Integer> numbers = InputConverter.mapToIntegerList(input);

        return new Lotto(numbers);
    }

    public static BonusNumber readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String input = readLine();
        validateInputBonusNumber(input);

        int number = InputConverter.mapToInt(input);

        return BonusNumber.from(number);
    }


    private static String readLine() {
        return Console.readLine().trim();
    }
}