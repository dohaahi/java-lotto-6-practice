package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        PurchaseAmount purchaseAmount = InputView.readPurchaseAmount();
        Lotto lotto = InputView.readLottoNumbers();
        BonusNumber bonusNumber = InputView.readBonusNumber();
    }
}