package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        int purchaseAmount = InputView.readPurchaseAmount();
        Lotto lotto = InputView.readLottoNumbers();
        int bonusNumber = InputView.readBonusNumber();
    }
}